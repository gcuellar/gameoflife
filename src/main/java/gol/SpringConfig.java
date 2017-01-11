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
@ComponentScan(basePackages="gol.*")
public class SpringConfig {

	@Bean(name="launcher")
	public GolLauncher createLauncher(){
		return new GolLauncher();
	}
	
	@Bean
	public MainScene mainScene(){
		return new MainScene("Game of life");
	}
	
	@Bean
	public ISceneManager sceneManager() {
		SceneManager sceneManager = new SceneManager();
		sceneManager.putScene(SceneEnum.MAIN, mainScene());
		sceneManager.current(SceneEnum.MAIN);
		return sceneManager;
	}
	
	
	@Bean
	public IRenderManager renderManager() {
		RenderManager renderManager = new RenderManager();
		return renderManager;
	}
}
