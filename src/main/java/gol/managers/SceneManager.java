package gol.managers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import gol.interfaces.IRenderizable;
import gol.interfaces.ISceneManager;
import gol.interfaces.IUpdatable;
import gol.scene.Scene;
import gol.scene.SceneEnum;

@Service
public class SceneManager implements ISceneManager {

	private Map<SceneEnum, Scene> scenes;
	private Scene currentScene;

	public SceneManager() {
		scenes = new HashMap<SceneEnum, Scene>();
	}

	@Override
	public void putScene(SceneEnum name, Scene obj) {
		scenes.put(name, obj);
	}

	@Override
	public Scene getScene(SceneEnum name) {
		return scenes.get(name);
	}

	@Override
	public void current(SceneEnum name) {
		Scene scene = scenes.get(name);
		this.currentScene = scene;
	}

	@Override
	public void renderScene() {
		if(this.currentScene instanceof IRenderizable){
			((IRenderizable)this.currentScene).render(1f);
		}
	}

	@Override
	public void updateScene() {
		if(this.currentScene instanceof IUpdatable){
			((IUpdatable)this.currentScene).update(1f);
		}
	}

}
