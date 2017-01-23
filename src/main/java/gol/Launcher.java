package gol;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import gol.game.Game;


public class Launcher {
	
	private static GenericApplicationContext context;

	public static void main(String[] args) {
		context = new AnnotationConfigApplicationContext(SpringConfig.class);
		Game game = (Game)context.getBean("game");
		game.start();
    }
}
