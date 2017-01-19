package gol.render.interfaces;

import gol.render.datatypes.Color;
import gol.render.datatypes.Vertex;

public interface IRenderer {
	
	public void init();
	
    /**
     * Clears the drawing area.
     */
    public void clear();
    
    public void clearColor(Color color);

    /**
     * Begin rendering.
     */
    public void begin();

    /**
     * End rendering.
     */
    public void end();

    /**
     * Flushes the data to the GPU to let it get rendered.
     */
    public void flush();

    /**
     * Calculates total width of a text.
     *
     * @param text The text
     *
     * @return Total width of the text
     */
//    public int getTextWidth(CharSequence text);

    /**
     * Calculates total height of a text.
     *
     * @param text The text
     *
     * @return Total width of the text
     */
//    public int getTextHeight(CharSequence text);

    /**
     * Calculates total width of a debug text.
     *
     * @param text The text
     *
     * @return Total width of the text
     */
//    public int getDebugTextWidth(CharSequence text);

    /**
     * Calculates total height of a debug text.
     *
     * @param text The text
     *
     * @return Total width of the text
     */
//    public int getDebugTextHeight(CharSequence text);

    /**
     * Draw text at the specified position.
     *
     * @param text Text to draw
     * @param x    X coordinate of the text position
     * @param y    Y coordinate of the text position
     */
//    public void drawText(CharSequence text, float x, float y);

    /**
     * Draw debug text at the specified position.
     *
     * @param text Text to draw
     * @param x    X coordinate of the text position
     * @param y    Y coordinate of the text position
     */
//    public void drawDebugText(CharSequence text, float x, float y);

    /**
     * Draw text at the specified position and color.
     *
     * @param text Text to draw
     * @param x    X coordinate of the text position
     * @param y    Y coordinate of the text position
     * @param c    Color to use
     */
//    public void drawText(CharSequence text, float x, float y, Color c);

    /**
     * Draw debug text at the specified position and color.
     *
     * @param text Text to draw
     * @param x    X coordinate of the text position
     * @param y    Y coordinate of the text position
     * @param c    Color to use
     */
//    public void drawDebugText(CharSequence text, float x, float y, Color c);

    /**
     * Draws the currently bound texture on specified coordinates.
     *
     * @param texture Used for getting width and height of the texture
     * @param x       X position of the texture
     * @param y       Y position of the texture
     */
//    public void drawTexture(Texture texture, float x, float y);

    /**
     * Draws the currently bound texture on specified coordinates and with
     * specified color.
     *
     * @param texture Used for getting width and height of the texture
     * @param x       X position of the texture
     * @param y       Y position of the texture
     * @param c       The color to use
     */
//    public void drawTexture(Texture texture, float x, float y, Color c);

    /**
     * Draws a texture region with the currently bound texture on specified
     * coordinates.
     *
     * @param texture   Used for getting width and height of the texture
     * @param x         X position of the texture
     * @param y         Y position of the texture
     * @param regX      X position of the texture region
     * @param regY      Y position of the texture region
     * @param regWidth  Width of the texture region
     * @param regHeight Height of the texture region
     */
//    public void drawTextureRegion(Texture texture, float x, float y, float regX, float regY, float regWidth, float regHeight);

    /**
     * Draws a texture region with the currently bound texture on specified
     * coordinates.
     *
     * @param texture   Used for getting width and height of the texture
     * @param x         X position of the texture
     * @param y         Y position of the texture
     * @param regX      X position of the texture region
     * @param regY      Y position of the texture region
     * @param regWidth  Width of the texture region
     * @param regHeight Height of the texture region
     * @param c         The color to use
     */
//    public void drawTextureRegion(Texture texture, float x, float y, float regX, float regY, float regWidth, float regHeight, Color c);

    /**
     * Draws a texture region with the currently bound texture on specified
     * coordinates.
     *
     * @param x1 Bottom left x position
     * @param y1 Bottom left y position
     * @param x2 Top right x position
     * @param y2 Top right y position
     * @param s1 Bottom left s coordinate
     * @param t1 Bottom left t coordinate
     * @param s2 Top right s coordinate
     * @param t2 Top right t coordinate
     */
//    public void drawTextureRegion(float x1, float y1, float x2, float y2, float s1, float t1, float s2, float t2);

    /**
     * Draws a texture region with the currently bound texture on specified
     * coordinates.
     *
     * @param x1 Bottom left x position
     * @param y1 Bottom left y position
     * @param x2 Top right x position
     * @param y2 Top right y position
     * @param s1 Bottom left s coordinate
     * @param t1 Bottom left t coordinate
     * @param s2 Top right s coordinate
     * @param t2 Top right t coordinate
     * @param c  The color to use
     */
//    public void drawTextureRegion(float x1, flosat y1, float x2, float y2, float s1, float t1, float s2, float t2, Color c);

    /**
     * Dispose renderer and clean up its used data.
     */
    public void dispose();
    
    
    public void drawTriangles(Vertex[] arr);
    public void drawLines(Vertex[] arr);
    
    public void setViewport(int x, int y, int width, int height);

}
