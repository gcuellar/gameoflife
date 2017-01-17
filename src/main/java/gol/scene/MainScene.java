package gol.scene;

import java.nio.FloatBuffer;

import org.lwjgl.opengl.GL15;
import org.springframework.stereotype.Component;

import gol.interfaces.IUpdatable;
import gol.render.datatypes.VertexArrayObject;
import gol.render.datatypes.VertexBufferObject;
import gol.scene.entities.Grid;

@Component
public class MainScene extends Scene implements IUpdatable {

	Grid grid;
	
	VertexArrayObject vao = null;
	VertexBufferObject vbo = null;

	public MainScene(String title) {
		super(title);
		
		grid = new Grid(20, 20);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void renderize() {

		FloatBuffer fBuffer = grid.createBuffer();
		
		if(vbo == null)
			vbo = new VertexBufferObject();

		if(vao == null)
			vao = new VertexArrayObject();
		
		vao.bind();
		vbo.bind(GL15.GL_ARRAY_BUFFER);
		
		vbo.uploadData(GL15.GL_ARRAY_BUFFER, fBuffer, GL15.GL_STATIC_DRAW);
		
//		vbo.unbind(GL15.GL_ARRAY_BUFFER);
		vao.unbind();
		
		renderManager.render(vbo, vao, fBuffer.remaining() / 3);
	}
	
	public void renderize2(){
	}

}
