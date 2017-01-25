package gol.render.datatypes;

public class Color {

	public static final Color WHITE = new Color(255f,255f,255f);
	public static final Color BLACK = new Color(0f,0f,0f);
	
	private float red;
	private float green;
	private float blue;

	/**
	 * 
	 * @param red Range 0 - 255
	 * @param green Range 0 - 255
	 * @param blue Range 0 - 255
	 */
	public Color(float red, float green, float blue) {
		super();
		this.red = red / 255f;
		this.green = green / 255f;
		this.blue = blue / 255f;
	}

	public float getRed() {
		return red;
	}

	public void setRed(float red) {
		this.red = red / 255f;
	}

	public float getGreen() {
		return green;
	}

	public void setGreen(float green) {
		this.green = green / 255f;
	}

	public float getBlue() {
		return blue;
	}

	/**
	 * @param blue Range 0 - 255
	 */
	public void setBlue(float blue) {
		this.blue = blue / 255f;
	}

}
