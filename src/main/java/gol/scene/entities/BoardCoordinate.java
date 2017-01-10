package gol.scene.entities;

public class BoardCoordinate {

	private int row;
	private int column;

	public int getRow() {
		return row;
	}

	public int getColumn() {
		return column;
	}

	public BoardCoordinate(int row, int column) {
		super();
		this.row = row;
		this.column = column;
	}

}
