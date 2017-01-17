package gol.scene;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gol.render.interfaces.IRenderManager;
import gol.scene.entities.Entity;

/**
 * It isn't abstract because Spring couldn't use it for prototyping/injection
 * 
 * @author gcuellar
 */
@Component
public class Scene {

	@Autowired
	protected IRenderManager renderManager;

	protected List<Entity> entities;
	protected String title;

	public Scene() {
		this.entities = new ArrayList<Entity>();
	}

	public Scene(String title) {
		this.entities = new ArrayList<Entity>();
		this.title = title;
	}

	public List<Entity> getEntities() {
		return entities;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void renderize() {

	}

	public void update() {

	}

}
