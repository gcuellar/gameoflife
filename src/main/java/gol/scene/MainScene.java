package gol.scene;

import org.springframework.stereotype.Component;

import gol.interfaces.IRenderizable;
import gol.interfaces.IUpdatable;
import gol.scene.entities.Grid;
import gol.scene.entities.GridBox;

@Component
public class MainScene extends Scene implements IRenderizable, IUpdatable {

	private Grid grid;

	public MainScene(String title) {
		super(title);
		
		grid = new Grid(20, 20);
		
		String[] alives = {"4;4","5;5","4;5","4;3"};
		grid.initialState(alives);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void input() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(float delta) {
//		for (int i = 0; i < grid.getColumns(); i++) {
//			for (int j = 0; j < grid.getRows(); j++) {
//				int nAlive = grid.aliveNeighbours(i, j);
//
//				GridBox box = grid.gridBox(i, j);
//				if (box.isAlive()) { // Is alive
//					if (nAlive == 2 || nAlive == 3) {
//						// Live
//						box.setAlive(true);
//					} else {
//						// Dead
//						box.setAlive(false);
//					}
//				} else { // Is dead
//					if (nAlive == 3) {
//						// Live
//						box.setAlive(true);
//					} else {
//						// Dead
//						box.setAlive(false);
//					}
//				}
//			}
//		}
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float alpha) {
		renderManager.clear();
		
		renderManager.begin();
		grid.render(renderManager, 1f);
		renderManager.end();
	}

}
