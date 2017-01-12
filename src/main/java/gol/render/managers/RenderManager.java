package gol.render.managers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.springframework.stereotype.Service;

import gol.config.Window;
import gol.render.datatypes.Vertex;
import gol.render.datatypes.VertexArrayObject;
import gol.render.datatypes.VertexBufferObject;
import gol.render.interfaces.IRenderManager;
import gol.render.math.Matrix4f;
import gol.render.shader.Shader;
import gol.render.shader.ShaderProgram;

@Service
public class RenderManager implements IRenderManager{

	private Shader vertexShader = null;
	private Shader fragmentShader = null;
	
	private ShaderProgram shaderProgram = null;
	

	
	private final int floatSize = Float.BYTES;
	
	@Override
	public void init(){
		// Compile shaders
		vertexShader = Shader.loadShader(GL20.GL_VERTEX_SHADER, "shaders/vertexShader");
		fragmentShader = Shader.loadShader(GL20.GL_FRAGMENT_SHADER, "shaders/fragmentShader");
		
		// Link program
		shaderProgram = new ShaderProgram();
		shaderProgram.attachShader(vertexShader);
		shaderProgram.attachShader(fragmentShader);
		shaderProgram.bindFragmentDataLocation(0, "fragColor");
		shaderProgram.link();
	}

	@Override
	public void render(VertexBufferObject vbo, VertexArrayObject vao, int numVertices) {
		
		shaderProgram.bind();
		vao.bind();
		
		int posAttrib = shaderProgram.getAttributeLocation("position");
		shaderProgram.enableVertexAttribute(posAttrib);
		shaderProgram.pointVertexAttribute(posAttrib, 3, Vertex.NUM_OF_COMPONENTS * floatSize, 0);

		int colAttrib = shaderProgram.getAttributeLocation("color");
		shaderProgram.enableVertexAttribute(colAttrib);
		shaderProgram.pointVertexAttribute(colAttrib, 3, Vertex.NUM_OF_COMPONENTS * floatSize, 3 * floatSize);
		
		
		
		int uniModel = shaderProgram.getUniformLocation("model");
		Matrix4f model = new Matrix4f();
		shaderProgram.setUniform(uniModel, model);

		
		int uniView = shaderProgram.getUniformLocation("view");
		Matrix4f view = new Matrix4f();
		shaderProgram.setUniform(uniView, view);

		int uniProjection = shaderProgram.getUniformLocation("projection");
		float ratio = Window.width / Window.height;
		Matrix4f projection = Matrix4f.orthographic(-ratio, ratio, -1f, 1f, -1f, 1f);
		shaderProgram.setUniform(uniProjection, projection);
		
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, numVertices);
		
		shaderProgram.disableVertexAttribute(posAttrib);
		shaderProgram.disableVertexAttribute(colAttrib);
		
		shaderProgram.unbind();
	}
	
	
}
