package gol;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import gol.render.managers.RenderManager;

@Configuration
@ComponentScan(basePackages="gol")
public class App {

	@Bean
	public RenderManager renderManager(){
		RenderManager renderManager = new RenderManager();
		return renderManager;
	}
}
