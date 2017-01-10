package gol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gol.interfaces.ISceneManager;
import gol.managers.SceneManager;
import gol.render.interfaces.IRenderManager;
import gol.render.managers.RenderManager;
import gol.scene.MainScene;
import gol.scene.SceneEnum;

@Configuration
public class SpringConfig {

	@Bean(name="launcher")
	public GolLauncher createLauncher(){
		return new GolLauncher();
	}
	
	@Bean
	public IRenderManager renderManager() {
		RenderManager renderManager = new RenderManager();
		return renderManager;
	}

	@Bean
	public ISceneManager sceneManager() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.putScene(SceneEnum.MAIN, new MainScene("Game of life"));
		sceneManager.current(SceneEnum.MAIN);
		return sceneManager;
	}
}
