package gol.scene.entities;

import gol.render.datatypes.Vertex;

public abstract class Entity {

	private Vertex[] vertices;

	public Vertex[] getVertices() {
		return vertices;
	}

	public void setVertices(Vertex[] vertices) {
		this.vertices = vertices;
	}
	
}
