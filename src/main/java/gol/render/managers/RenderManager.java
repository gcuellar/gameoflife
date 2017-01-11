package gol.render.managers;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.springframework.stereotype.Service;

import gol.config.Window;
import gol.render.datatypes.Vertex;
import gol.render.interfaces.IRenderManager;
import gol.render.math.Matrix4f;
import gol.render.shader.ShaderUtils;

@Service
public class RenderManager implements IRenderManager{

	private int vertexShaderId = 0;
	private int fragmentShaderId = 0;
	
	private int shaderProgramId = 0;
	
	@Override
	public void init(){
		// Compile shaders
		vertexShaderId = ShaderUtils.compileShader("shaders/vertexShader", GL20.GL_VERTEX_SHADER);
		fragmentShaderId = ShaderUtils.compileShader("shaders/fragmentShader", GL20.GL_FRAGMENT_SHADER);
		
		// Link program
		shaderProgramId = ShaderUtils.linkProgram(vertexShaderId, fragmentShaderId);
	}

	@Override
	public void render(int vboId) {
		
		GL20.glUseProgram(shaderProgramId);
		
		int floatSize = Float.BYTES;

		int posAttrib = GL20.glGetAttribLocation(shaderProgramId, "position");
		GL20.glEnableVertexAttribArray(posAttrib);
		GL20.glVertexAttribPointer(posAttrib, 3, GL11.GL_FLOAT, false, Vertex.NUM_OF_COMPONENTS * floatSize, 0);

		int colAttrib = GL20.glGetAttribLocation(shaderProgramId, "color");
		GL20.glEnableVertexAttribArray(colAttrib);
		GL20.glVertexAttribPointer(colAttrib, 3, GL11.GL_FLOAT, false, Vertex.NUM_OF_COMPONENTS * floatSize, 3 * floatSize);
		
		
		
		
		
		
		int uniModel = GL20.glGetUniformLocation(shaderProgramId, "model");
		Matrix4f model = new Matrix4f();
		GL20.glUniformMatrix4fv(uniModel, false, model.getBuffer());

		int uniView = GL20.glGetUniformLocation(shaderProgramId, "view");
		Matrix4f view = new Matrix4f();
		GL20.glUniformMatrix4fv(uniView, false, view.getBuffer());

		int uniProjection = GL20.glGetUniformLocation(shaderProgramId, "projection");
		float ratio = Window.width / Window.height;
		Matrix4f projection = Matrix4f.orthographic(-ratio, ratio, -1f, 1f, -1f, 1f);
		GL20.glUniformMatrix4fv(uniProjection, false, projection.getBuffer());
		
		
		GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, 3);
	}
	
	
}
