package gol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gol.game.FixedTimestepGame;
import gol.game.Game;
import gol.interfaces.ISceneManager;
import gol.managers.SceneManager;
import gol.render.interfaces.IRenderer;
import gol.render.managers.RenderManager;
import gol.scene.MainScene;
import gol.scene.SceneEnum;

@Configuration
@ComponentScan(basePackages="gol.*")
public class SpringConfig {

	@Bean(name="launcher")
	public TutorialLauncher createLauncher(){
		return new TutorialLauncher();
	}
	
	@Bean
	public Game game(){
		return new FixedTimestepGame();
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
	public IRenderer renderManager() {
		RenderManager renderManager = new RenderManager();
		return renderManager;
	}
}
