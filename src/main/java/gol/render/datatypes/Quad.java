package gol.render.datatypes;


/**
 * Defines a quad primitive
 * 
 * v1---v3
 * |\   |
 * | \  |
 * |  \ |
 * v2---v4
 * 
 * @author gcuellar
 *
 */
public class Quad {

	private Vertex v1, v2, v3, v4;

	public Vertex getV1() {
		return v1;
	}

	public void setV1(Vertex v1) {
		this.v1 = v1;
	}

	public Vertex getV2() {
		return v2;
	}

	public void setV2(Vertex v2) {
		this.v2 = v2;
	}

	public Vertex getV3() {
		return v3;
	}

	public void setV3(Vertex v3) {
		this.v3 = v3;
	}

	public Vertex getV4() {
		return v4;
	}

	public void setV4(Vertex v4) {
		this.v4 = v4;
	}

}
