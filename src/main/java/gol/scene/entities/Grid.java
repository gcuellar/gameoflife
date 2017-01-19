package gol.scene.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gol.config.Colors;
import gol.config.Window;
import gol.render.datatypes.Color;
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
	private Vertex[] boardLines;

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
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				GridBox box = new GridBox(false);
				Quad quad = new Quad();
				quad.setV1(new Vertex(i*boxWidth, (j+1)*boxHeight, 0f, Colors.dead));
				quad.setV2(new Vertex(i*boxWidth, j*boxHeight, 0f, Colors.dead));
				quad.setV3(new Vertex((i+1)*boxWidth, (j+1)*boxHeight, 0f, Colors.dead));
				quad.setV4(new Vertex((i+1)*boxWidth, j*boxHeight, 0f, Colors.dead));
				box.setQuad(quad);
				
				board.put(i+";"+j, box);
			}
		}
		
		List<Vertex> list = new ArrayList<Vertex>();
		for(int i=0;i<columns;i++){
			Vertex v1 = new Vertex(board.get(i+";0").getQuad().getV2(), Colors.lines);
			list.add(v1);
			Vertex v2 = new Vertex(board.get(i+";"+(rows-1)).getQuad().getV1(), Colors.lines);
			list.add(v2);
		}
		Vertex v1 = new Vertex(board.get((columns-1)+";0").getQuad().getV4(), Colors.lines);
		list.add(v1);
		Vertex v2 = new Vertex(board.get((columns-1)+";"+(rows-1)).getQuad().getV3(), Colors.lines);
		list.add(v2);
		
		for(int i=0;i<rows;i++){
			Vertex vA = new Vertex(board.get("0;"+i).getQuad().getV2(), Colors.lines);
			list.add(vA);
			Vertex vB = new Vertex(board.get((columns-1)+";"+i).getQuad().getV4(), Colors.lines);
			list.add(vB);
		}
		Vertex vA = new Vertex(board.get("0;"+(rows-1)).getQuad().getV1(), Colors.lines);
		list.add(vA);
		Vertex vB = new Vertex(board.get((columns-1)+";"+(rows-1)).getQuad().getV3(), Colors.lines);
		list.add(vB);
		
		boardLines = list.stream().toArray(size -> new Vertex[size]);
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	@Override
	public void render(IRenderer renderer, float alpha) {
		
//		renderer.clearColor(new Color(0.7f,0.7f,0.5f,0f));
		
		board.get("12;12").setAlive(true);
		
		
		renderer.drawTriangles(board.get("12;12").getQuad().toVertexArray());
		renderer.drawLines(boardLines);
	}

	

}
