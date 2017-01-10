package gol.scene;

import java.util.ArrayList;
import java.util.List;

import gol.scene.entities.Entity;

public abstract class Scene {

	private List<Entity> entities;

	public Scene() {
		this.entities = new ArrayList<Entity>();
	}

	public List<Entity> getEntities() {
		return entities;
	}
	
	
}
