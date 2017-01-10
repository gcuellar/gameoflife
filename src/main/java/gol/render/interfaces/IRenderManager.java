package gol.render.interfaces;

import java.nio.FloatBuffer;

public interface IRenderManager {
	
	public void render(FloatBuffer vertices, int vertexCount);
}
