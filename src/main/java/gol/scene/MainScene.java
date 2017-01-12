package gol.scene;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL15;
import org.springframework.stereotype.Component;

import gol.interfaces.IRenderizable;
import gol.interfaces.IUpdatable;
import gol.render.datatypes.Quad;
import gol.render.datatypes.Vertex;
import gol.render.datatypes.VertexArrayObject;
import gol.render.datatypes.VertexBufferObject;

@Component
public class MainScene extends Scene implements IRenderizable, IUpdatable {

	VertexArrayObject vao = null;
	VertexBufferObject vbo = null;

	public MainScene() {
		super();
	}

	public MainScene(String title) {
		super(title);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void renderize() {

		Quad quad = new Quad();
		quad.setV1(new Vertex(-0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f));
		quad.setV2(new Vertex(-0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f));
		quad.setV3(new Vertex(0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f));
		quad.setV4(new Vertex(0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f));
		
		float[] arr = quad.toFloatArray();
		FloatBuffer fBuffer = BufferUtils.createFloatBuffer(arr.length);
		fBuffer.put(arr);
		fBuffer.flip();
		
		if(vbo == null)
			vbo = new VertexBufferObject();

		if(vao == null)
			vao = new VertexArrayObject();
		
		vao.bind();
		vbo.bind(GL15.GL_ARRAY_BUFFER);
		vbo.uploadData(GL15.GL_ARRAY_BUFFER, fBuffer, GL15.GL_STATIC_DRAW);
		vao.unbind();
		
		renderManager.render(vbo, vao, 4);
	}

}
