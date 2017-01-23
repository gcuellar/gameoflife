package gol.game;

import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwSetErrorCallback;
import static org.lwjgl.glfw.GLFW.glfwTerminate;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gol.config.Config;
import gol.interfaces.ISceneManager;
import gol.render.datatypes.Window;
import gol.render.interfaces.IRenderer;

/**
 * The game class just initializes the game and starts the game loop. After
 * ending the loop it will get disposed.
 *
 * @author Heiko Brumme
 */
@Component
public abstract class Game {

    /**
     * The error callback for GLFW.
     */
    private GLFWErrorCallback errorCallback;

    /**
     * Shows if the game is running.
     */
    protected boolean running;

    /**
     * The GLFW window used by the game.
     */
    protected Window window;
    /**
     * Used for timing calculations.
     */
    protected Timer timer;
    /**
     * Used for rendering.
     */
    @Autowired
    protected IRenderer renderManager;
    /**
     * Stores the current state.
     */
    @Autowired
    protected ISceneManager sceneManager;

    /**
     * Default contructor for the game.
     */
    public Game() {
        timer = new Timer();
        renderManager = null;
        sceneManager = null;
    }

    /**
     * This should be called to initialize and start the game.
     */
    public void start() {
        init();
        gameLoop();
        dispose();
    }

    /**
     * Releases resources that where used by the game.
     */
    public void dispose() {
        /* Dipose renderer */
        renderManager.dispose();

        /* Set empty state to trigger the exit method in the current state */
//        sceneManager.change(null);

        /* Release window and its callbacks */
        window.destroy();

        /* Terminate GLFW and release the error callback */
        glfwTerminate();
        errorCallback.free();
    }

    /**
     * Initializes the game.
     */
    public void init() {
        /* Set error callback */
        errorCallback = GLFWErrorCallback.createPrint();
        glfwSetErrorCallback(errorCallback);

        /* Initialize GLFW */
        if (!glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW!");
        }

        /* Create GLFW window */
        window = new Window(Config.WINDOW_WIDTH, Config.WINDOW_HEIGHT, "Default Game Window", true);

        /* Initialize timer */
        timer.init();

        /* Initialize renderer */
        renderManager.init();

        /* Initialize states */
        initStates();

        /* Initializing done, set running to true */
        running = true;
    }

    /**
     * Initializes the states.
     */
    public void initStates() {
    	
    	// Scene creation is performed in SpringConfig class.
    }

    /**
     * The game loop. <br>
     * For implementation take a look at <code>VariableDeltaGame</code> and
     * <code>FixedTimestepGame</code>.
     */
    public abstract void gameLoop();

    /**
     * Handles input.
     */
    public void input() {
        sceneManager.input();
    }

    /**
     * Updates the game (fixed timestep).
     */
    public void update() {
        sceneManager.updateScene();
    }

    /**
     * Updates the game (variable timestep).
     *
     * @param delta Time difference in seconds
     */
    public void update(float delta) {
        sceneManager.updateScene(delta);
    }

    /**
     * Renders the game (no interpolation).
     */
    public void render() {
        sceneManager.renderScene();
    }

    /**
     * Renders the game (with interpolation).
     *
     * @param alpha Alpha value, needed for interpolation
     */
    public void render(float alpha) {
        sceneManager.renderScene(alpha);
    }

    /**
     * Synchronizes the game at specified frames per second.
     *
     * @param fps Frames per second
     */
    public void sync(int fps) {
        double lastLoopTime = timer.getLastLoopTime();
        double now = timer.getTime();
        float targetTime = 1f / fps;

        while (now - lastLoopTime < targetTime) {
            Thread.yield();

            /* This is optional if you want your game to stop consuming too much
             * CPU but you will loose some accuracy because Thread.sleep(1)
             * could sleep longer than 1 millisecond */
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
            }

            now = timer.getTime();
        }
    }

    /**
     * Determines if the OpenGL context supports version 3.2.
     *
     * @return true, if OpenGL context supports version 3.2, else false
     */
    public static boolean isDefaultContext() {
        return GL.getCapabilities().OpenGL32;
    }

}