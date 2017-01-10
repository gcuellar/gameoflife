package gol.scene;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;
import org.springframework.beans.factory.annotation.Autowired;

import gol.interfaces.IRenderizable;
import gol.interfaces.IUpdatable;
import gol.render.managers.RenderManager;

public class MainScene extends Scene implements IRenderizable, IUpdatable {

	@Autowired
	private RenderManager renderManager = null;
	
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

		float[] vertices = { 
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
				-0.5f,0.5f, 0f };

		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
		verticesBuffer.put(vertices);
		verticesBuffer.flip();
		
		renderManager.render(verticesBuffer, vertices.length);
	}

}
