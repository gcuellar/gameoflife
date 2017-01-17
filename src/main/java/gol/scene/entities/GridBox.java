package gol.scene.entities;

import gol.render.datatypes.Quad;

public class GridBox {

	private Quad quad = null;
	
	private boolean alive;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public GridBox(boolean alive) {

		this.alive = alive;
	}

	public Quad getQuad() {
		return quad;
	}

	public void setQuad(Quad quad) {
		this.quad = quad;
	}

	
}
