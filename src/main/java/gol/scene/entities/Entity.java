package gol.scene.entities;

import gol.render.datatypes.Vertex;
import gol.render.interfaces.IRenderer;

public abstract class Entity {

	private Vertex[] vertices;

	public Vertex[] getVertices() {
		return vertices;
	}

	public void setVertices(Vertex[] vertices) {
		this.vertices = vertices;
	}
	
	public abstract void render(IRenderer renderer, float alpha);
}
