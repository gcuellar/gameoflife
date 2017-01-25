package gol.config;

import gol.render.datatypes.Color;

public class Config {

	public static final int FLOAT_BUFFER_SIZE = 4096; // Bytes
	
	public static final int WINDOW_WIDTH = 640;
	public static final int WINDOW_HEIGHT = 480;
	
	public static final int TARGET_UPS = 30;
	public static final int TARGET_FPS = 75;
	
//	public static final int TARGET_UPS = 1;
//	public static final int TARGET_FPS = 1;
	
	
	
	public static final Color COLOR_GRID_LINES = new Color(255f, 255f, 255f);
	public static final Color COLOR_BOX_ALIVE = new Color(170f, 155f, 168f);
	public static final Color COLOR_BOX_DEAD = new Color(84f, 56f, 63f);
}
