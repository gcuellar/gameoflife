package gol.scene.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gol.config.Colors;
import gol.config.Config;
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
		boxWidth = Config.WINDOW_WIDTH / columns;
		boxHeight = Config.WINDOW_HEIGHT / rows;

		// Grid instantiation
		board = new HashMap<String, GridBox>();
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				GridBox box = new GridBox(false);
				Quad quad = new Quad();
				quad.setV1(new Vertex(i*boxWidth, (j+1)*boxHeight, 0f, Colors.BOX_DEAD));
				quad.setV2(new Vertex(i*boxWidth, j*boxHeight, 0f, Colors.BOX_DEAD));
				quad.setV3(new Vertex((i+1)*boxWidth, (j+1)*boxHeight, 0f, Colors.BOX_DEAD));
				quad.setV4(new Vertex((i+1)*boxWidth, j*boxHeight, 0f, Colors.BOX_DEAD));
				box.setQuad(quad);
				
				board.put(i+";"+j, box);
			}
		}
		
		initGridLines();
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	@Override
	public void render(IRenderer renderer, float alpha) {
		
		renderer.clearColor(Colors.BOX_DEAD);
		
		renderer.drawLines(boardLines);
		renderer.drawTriangles(alives());
	}
	
	public void initialState(String[] alives){
		for(String s : alives){
			board.get(s).setAlive(true);
		}
	}
	
	private void initGridLines(){
		List<Vertex> list = new ArrayList<Vertex>();
		for(int i=0;i<columns;i++){
			Vertex v1 = new Vertex(board.get(i+";0").getQuad().getV2(), Colors.GRID_LINES);
			list.add(v1);
			Vertex v2 = new Vertex(board.get(i+";"+(rows-1)).getQuad().getV1(), Colors.GRID_LINES);
			list.add(v2);
		}
		Vertex v1 = new Vertex(board.get((columns-1)+";0").getQuad().getV4(), Colors.GRID_LINES);
		list.add(v1);
		Vertex v2 = new Vertex(board.get((columns-1)+";"+(rows-1)).getQuad().getV3(), Colors.GRID_LINES);
		list.add(v2);
		
		for(int i=0;i<rows;i++){
			Vertex vA = new Vertex(board.get("0;"+i).getQuad().getV2(), Colors.GRID_LINES);
			list.add(vA);
			Vertex vB = new Vertex(board.get((columns-1)+";"+i).getQuad().getV4(), Colors.GRID_LINES);
			list.add(vB);
		}
		Vertex vA = new Vertex(board.get("0;"+(rows-1)).getQuad().getV1(), Colors.GRID_LINES);
		list.add(vA);
		Vertex vB = new Vertex(board.get((columns-1)+";"+(rows-1)).getQuad().getV3(), Colors.GRID_LINES);
		list.add(vB);
		
		boardLines = list.stream().toArray(size -> new Vertex[size]);
	}
	
	private Vertex[] alives(){
		
		List<Vertex> list = new ArrayList<Vertex>();
		for(int i=0;i<columns;i++){
			for(int j=0;j<rows;j++){
				if(board.get(i+";"+j).isAlive()){
					list.addAll(board.get(i+";"+j).getQuad().toVertexCollection());
				}
			}
		}
		
		return list.stream().toArray(size -> new Vertex[size]);
	}

	public GridBox gridBox(int x, int y){
		return board.get(x+";"+y);
	}
	
	public int aliveNeighbours(int x, int y) {
		int counter = 0;

		if (x - 1 >= 0 && board.get((x-1)+";"+y) != null) {
			counter++;
		}

		if (x - 1 >= 0 && y - 1 >= 0 && board.get((x-1)+";"+(y-1)) != null) {
			counter++;
		}

		if (x - 1 >= 0 && y + 1 < rows && board.get((x-1)+";"+(y+1)) != null) {
			counter++;
		}

		if (x + 1 < columns && board.get((x+1)+";"+y) != null) {
			counter++;
		}

		if (x + 1 < columns && y - 1 >= 0 && board.get((x+1)+";"+(y-1)) != null) {
			counter++;
		}

		if (x + 1 < columns && y + 1 < rows && board.get((x+1)+";"+(y+1)) != null) {
			counter++;
		}

		if (y - 1 >= 0 && board.get(x+";"+(y-1)) != null) {
			counter++;
		}

		if (y + 1 < rows && board.get(x+";"+(y+1)) != null) {
			counter++;
		}

		return counter;
	}

}
