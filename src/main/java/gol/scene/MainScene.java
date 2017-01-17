package gol.scene;

import org.springframework.stereotype.Component;

import gol.interfaces.IRenderizable;
import gol.interfaces.IUpdatable;
import gol.scene.entities.Grid;

@Component
public class MainScene extends Scene implements IRenderizable, IUpdatable {

	private Grid grid;

	public MainScene(String title) {
		super(title);
		
		grid = new Grid(20, 20);
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
		// TODO Auto-generated method stub
		
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
