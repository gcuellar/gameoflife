package gol.scene.entities;

import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.BufferUtils;
import org.springframework.beans.factory.annotation.Autowired;

import gol.config.Window;
import gol.interfaces.IRenderizable;
import gol.render.managers.RenderManager;

/**
 * Game board class.
 * 
 * Origin box is located at 0,0 in bottom left corner of the board.
 * 
 * @author gcuellar
 */
public class Board extends Entity implements IRenderizable {

	private int rows;
	private int columns;

	private float boxWidth;
	private float boxHeight;

	private Map<BoardCoordinate, BoardBox> board;
	
	@Autowired
	RenderManager renderManager;

	public Board(int numberOfRows, int numberOfColumns) {

		super();

		// Init number of columns and rows
		rows = numberOfRows;
		columns = numberOfColumns;

		// Calculate width and height in pixel for one box
		boxWidth = Window.width / columns;
		boxHeight = Window.height / rows;

		// Init map
		board = new HashMap<BoardCoordinate, BoardBox>();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; i < rows; i++) {
				board.put(new BoardCoordinate(i, j), new BoardBox(false));
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void renderize() {
		

		float[] vertices = { 
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
				-0.5f,0.5f, 0f };

		FloatBuffer verticesBuffer = BufferUtils.createFloatBuffer(vertices.length);
		verticesBuffer.put(vertices);
		verticesBuffer.flip();
	}

}
