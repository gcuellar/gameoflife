package gol.game;

import org.springframework.stereotype.Component;

import gol.config.Config;

/**
 * This class contains the implementation for a fixed timestep game loop.
 *
 * @author Heiko Brumme
 */
@Component
public class FixedTimestepGame extends Game {
	
    @Override
    public void gameLoop() {
        float delta;
        float accumulator = 0f;
        float interval = 1f / Config.TARGET_UPS;
        float alpha;

        while (running) {
            /* Check if game should close */
            if (window.isClosing()) {
                running = false;
            }

            /* Get delta time and update the accumulator */
            delta = timer.getDelta();
            accumulator += delta;

            /* Handle input */
            input();

            /* Update game and timer UPS if enough time has passed */
            while (accumulator >= interval) {
                update();
                timer.updateUPS();
                accumulator -= interval;
            }

            /* Calculate alpha value for interpolation */
            alpha = accumulator / interval;

            /* Render game and update timer FPS */
            render(alpha);
            timer.updateFPS();

            /* Update timer */
            timer.update();

            /* Draw FPS, UPS and Context version */
//            int height = renderManager.getDebugTextHeight("Context");
//            renderManager.drawDebugText("FPS: " + timer.getFPS() + " | UPS: " + timer.getUPS(), 5, 5 + height);
//            renderManager.drawDebugText("Context: " + (Game.isDefaultContext() ? "3.2 core" : "2.1"), 5, 5);

            /* Update window to show the new screen */
            window.update();

            /* Synchronize if v-sync is disabled */
            if (!window.isVSyncEnabled()) {
                sync(Config.TARGET_FPS);
            }
        }
    }

}