package gol.interfaces;

import gol.scene.Scene;
import gol.scene.SceneEnum;

public interface ISceneManager {

	public void putScene(SceneEnum name, Scene obj);
	
	public Scene getScene(SceneEnum name);
	
	public void current(SceneEnum name);
	
	public void renderScene();
	public void renderScene(float alpha);
	
	public void updateScene();
	public void updateScene(float delta);
	
	public void input();
}
