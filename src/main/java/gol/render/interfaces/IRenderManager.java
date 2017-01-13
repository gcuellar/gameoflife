package gol.render.interfaces;

import gol.render.datatypes.VertexArrayObject;
import gol.render.datatypes.VertexBufferObject;

public interface IRenderManager {
	
	public void init();
	
	public void useVertexShader(String filePath);
	public void useFragmentShader(String filePath, int colorNumber, String name);
	public void linkProgram();
	
	public void render(VertexBufferObject vbo, VertexArrayObject vao, int numVertices);
}
