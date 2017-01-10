package gol.interfaces;

import gol.scene.Scene;
import gol.scene.SceneEnum;

public interface ISceneManager {

	public void putScene(SceneEnum name, Scene obj);
	
	public Scene getScene(SceneEnum name);
	
	public void current(Scene scene);
	
	public void renderScene();
	
	public void updateScene();
}
