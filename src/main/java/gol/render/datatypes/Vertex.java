package gol.render.datatypes;

import gol.render.interfaces.IConvertibleIntoArray;

public class Vertex implements IConvertibleIntoArray{

	public static final int NUM_OF_COMPONENTS = 7;
	
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
	
	public Vertex(Vertex another, Color color){
		x = another.getX();
		y = another.getY();
		z = another.getZ();

		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		alpha = color.getAlpha();
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

	public Vertex(float xCoord, float yCoord, float zCoord, Color color) {
		x = xCoord;
		y = yCoord;
		z = zCoord;

		red = color.getRed();
		green = color.getGreen();
		blue = color.getBlue();
		alpha = color.getAlpha();
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

	@Override
	public float[] toFloatArray() {
		float[] arr = {
			x,y,z,red,green,blue,alpha	
		};
		
		return arr;
	}

}
