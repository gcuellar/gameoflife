package gol.scene;

import java.util.ArrayList;
import java.util.List;

import gol.scene.entities.Entity;

public abstract class Scene {

	protected List<Entity> entities;
	protected String title;

	public Scene() {
		this.entities = new ArrayList<Entity>();
	}
	
	public Scene(String title){
		this.entities = new ArrayList<Entity>();
		this.title = title;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
}
