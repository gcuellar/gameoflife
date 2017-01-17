package gol.scene.entities;

import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.BufferUtils;
import org.springframework.beans.factory.annotation.Autowired;

import gol.config.Window;
import gol.interfaces.IBufferable;
import gol.render.datatypes.Quad;
import gol.render.datatypes.Vertex;
import gol.render.managers.RenderManager;

/**
 * Game board class.
 * 
 * Origin box is located at 0,0 in bottom left corner of the board.
 * 
 * @author gcuellar
 */
public class Grid extends Entity implements IBufferable {

	private int rows;
	private int columns;

	private float boxWidth;
	private float boxHeight;

	private Map<String, GridBox> board;
	
	@Autowired
	RenderManager renderManager;

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
	public FloatBuffer createBuffer() {
		Quad q1 = board.get("0;0").getQuad();
		Quad q2 = board.get("19;19").getQuad();
		Quad q3 = board.get("11;11").getQuad();
		
		float[] arr1 = q1.toFloatArray();
		float[] arr2 = q2.toFloatArray();
		float[] arr3 = q3.toFloatArray();
		
		FloatBuffer buffer = BufferUtils.createFloatBuffer(arr1.length+arr2.length+arr3.length);
		buffer.put(arr1);
		buffer.put(arr2);
		buffer.put(arr3);
		buffer.flip();
		
		return buffer;
	}

	

}
