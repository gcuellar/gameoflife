package gol.scene;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL15;
import org.springframework.stereotype.Component;

import gol.interfaces.IRenderizable;
import gol.interfaces.IUpdatable;
import gol.render.RenderUtils;
import gol.render.datatypes.Vertex;
import gol.render.datatypes.VertexBufferObject;

@Component
public class MainScene extends Scene implements IRenderizable, IUpdatable {

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

		
		
		Vertex[] vertices = {
			new Vertex(-0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f),
			new Vertex(-0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f),
			new Vertex(0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f),
			new Vertex(0.5f, -0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f),
			new Vertex(0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f),
			new Vertex(-0.5f, 0.5f, 0f, 1.0f, 1.0f, 0.0f, 0.0f)
		};
		
		FloatBuffer fBuffer = RenderUtils.floatBufferFrom(vertices);

		if(vbo == null)
			vbo = new VertexBufferObject();
		
		vbo.bind(GL15.GL_ARRAY_BUFFER);
		vbo.uploadData(GL15.GL_ARRAY_BUFFER, fBuffer, GL15.GL_STATIC_DRAW);
		
		
		renderManager.render(vbo.getID());
	}

}
