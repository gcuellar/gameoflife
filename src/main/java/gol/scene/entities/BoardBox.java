package gol.scene.entities;

import gol.render.datatypes.Quad;

public class BoardBox {

	private Quad quad = null;
	
	private boolean alive;

	public boolean isAlive() {
		return alive;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public BoardBox(boolean alive) {

		this.alive = alive;
	}

	public Quad getQuad() {
		return quad;
	}

	public void setQuad(Quad quad) {
		this.quad = quad;
	}

	
}
