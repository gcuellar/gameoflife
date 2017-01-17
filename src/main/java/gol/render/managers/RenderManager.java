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
	
	private int wireframeMode = GL11.GL_FILL;
	
	public int getWireframeMode() {
		return wireframeMode;
	}

	public void setWireframeMode(int wireframeMode) {
		this.wireframeMode = wireframeMode;
	}

	@Override
	public void init(){
		// Compile shaders
		vertexShader = Shader.loadShader(GL20.GL_VERTEX_SHADER, "shaders/vs_basic");
		fragmentShader = Shader.loadShader(GL20.GL_FRAGMENT_SHADER, "shaders/fs_basic");
		
		// Link program
		shaderProgram = new ShaderProgram();
		shaderProgram.attachShader(vertexShader);
		shaderProgram.attachShader(fragmentShader);
		shaderProgram.bindFragmentDataLocation(0, "fragColor");
		shaderProgram.link();
		
		// Set viewport
		GL11.glViewport(0, 0, Window.width, Window.height);
	}

	@Override
	public void render(VertexBufferObject vbo, VertexArrayObject vao, int numVertices) {
		
		shaderProgram.bind();
		vao.bind();
		
		int posAttrib = shaderProgram.getAttributeLocation("position");
		shaderProgram.enableVertexAttribute(posAttrib);
		shaderProgram.pointVertexAttribute(posAttrib, 3, Vertex.NUM_OF_COMPONENTS * Float.BYTES, 0);

		int colAttrib = shaderProgram.getAttributeLocation("color");
		shaderProgram.enableVertexAttribute(colAttrib);
		shaderProgram.pointVertexAttribute(colAttrib, 3, Vertex.NUM_OF_COMPONENTS * Float.BYTES, 3 * Float.BYTES);
		
		
		
		int uniModel = shaderProgram.getUniformLocation("model");
		Matrix4f model = new Matrix4f();
		shaderProgram.setUniform(uniModel, model);

		
		int uniView = shaderProgram.getUniformLocation("view");
		Matrix4f view = new Matrix4f();
		shaderProgram.setUniform(uniView, view);

		int uniProjection = shaderProgram.getUniformLocation("projection");
//		float ratio = Window.width / Window.height;
		Matrix4f projection = Matrix4f.orthographic(0, Window.width, 0, Window.height, -1f, 1f);
		shaderProgram.setUniform(uniProjection, projection);
		
		GL11.glPolygonMode(GL11.GL_FRONT_AND_BACK, wireframeMode);

		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, numVertices);
		
		shaderProgram.disableVertexAttribute(posAttrib);
		shaderProgram.disableVertexAttribute(colAttrib);
		
		shaderProgram.unbind();
	}
	
	public void render2(){
		
	}

	@Override
	public void useVertexShader(String filePath) {
		shaderProgram.detachShader(vertexShader);
		vertexShader = Shader.loadShader(GL20.GL_VERTEX_SHADER, filePath);
		shaderProgram.attachShader(vertexShader);
	}

	@Override
	public void useFragmentShader(String filePath, int colorNumber, String name) {
		shaderProgram.detachShader(fragmentShader);
		fragmentShader = Shader.loadShader(GL20.GL_FRAGMENT_SHADER, filePath);
		shaderProgram.attachShader(fragmentShader);
		shaderProgram.bindFragmentDataLocation(colorNumber, name);
	}
	
	@Override
	public void linkProgram(){
		shaderProgram.link();
	}
	
	
}
