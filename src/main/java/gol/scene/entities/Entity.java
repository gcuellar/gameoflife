package gol.scene.entities;

import gol.render.datatypes.VertexData;

public abstract class Entity {

	private VertexData[] vertices;

	public VertexData[] getVertices() {
		return vertices;
	}

	public void setVertices(VertexData[] vertices) {
		this.vertices = vertices;
	}
	
}
