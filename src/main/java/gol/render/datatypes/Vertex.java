package gol.render.datatypes;

public class Vertex {

	private float x, y, z;
	private float red, green, blue, alpha;

	public Vertex() {
		x = 0.0f;
		y = 0.0f;
		z = 0.0f;

		red = 0.0f;
		green = 0.0f;
		blue = 0.0f;
		alpha = 0.0f;
	}

	public Vertex(float xCoord, float yCoord, float zCoord) {
		x = xCoord;
		y = yCoord;
		z = zCoord;

		red = 0.0f;
		green = 0.0f;
		blue = 0.0f;
		alpha = 0.0f;
	}

	public Vertex(float xCoord, float yCoord, float zCoord, float redComp, float greenComp, float blueComp,
			float alphaComp) {
		x = xCoord;
		y = yCoord;
		z = zCoord;

		red = redComp;
		green = greenComp;
		blue = blueComp;
		alpha = alphaComp;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}

	public float getRed() {
		return red;
	}

	public void setRed(float red) {
		this.red = red;
	}

	public float getGreen() {
		return green;
	}

	public void setGreen(float green) {
		this.green = green;
	}

	public float getBlue() {
		return blue;
	}

	public void setBlue(float blue) {
		this.blue = blue;
	}

	public float getAlpha() {
		return alpha;
	}

	public void setAlpha(float alpha) {
		this.alpha = alpha;
	}

}
