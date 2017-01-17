package gol.scene.entities;

import java.util.HashMap;
import java.util.Map;

import gol.config.Window;
import gol.render.datatypes.Quad;
import gol.render.datatypes.Vertex;
import gol.render.interfaces.IRenderer;

/**
 * Game board class.
 * 
 * Origin box is located at 0,0 in bottom left corner of the board.
 * 
 * @author gcuellar
 */
public class Grid extends Entity {

	private int rows;
	private int columns;

	private float boxWidth;
	private float boxHeight;

	private Map<String, GridBox> board;

	public Grid(int numberOfRows, int numberOfColumns) {

		super();

		// Init number of columns and rows
		rows = numberOfRows;
		columns = numberOfColumns;

		// Calculate width and height in pixel for one box
		boxWidth = Window.width / columns;
		boxHeight = Window.height / rows;

		// Init map
		board = new HashMap<String, GridBox>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				GridBox box = new GridBox(false);
				Quad quad = new Quad();
				quad.setV1(new Vertex(j*boxWidth, (i+1)*boxHeight, 0f));
				quad.setV2(new Vertex(j*boxWidth, i*boxHeight, 0f));
				quad.setV3(new Vertex((j+1)*boxWidth, (i+1)*boxHeight, 0f));
				quad.setV4(new Vertex((j+1)*boxWidth, i*boxHeight, 0f));
				box.setQuad(quad);
				
				board.put(i+";"+j, box);
			}
		}
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	@Override
	public void render(IRenderer renderer, float alpha) {
		
		Quad q1 = board.get("0;0").getQuad();
		
		renderer.drawTriangle(q1.getV1(), q1.getV2(), q1.getV3());
		renderer.drawTriangle(q1.getV2(), q1.getV4(), q1.getV3());
	}

	

}
