package gol.render.interfaces;

import gol.render.datatypes.VertexArrayObject;
import gol.render.datatypes.VertexBufferObject;

public interface IRenderManager {
	
	public void init();
	public void render(VertexBufferObject vbo, VertexArrayObject vao, int numVertices);
}
