package gol.scene.entities;

public class BoardBox {

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

}
