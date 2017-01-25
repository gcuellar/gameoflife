package gol.render.datatypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.util.CollectionUtils;

import gol.render.interfaces.IConvertibleIntoArray;

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
public class Quad implements IConvertibleIntoArray{

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
	
	public void setColor(Color color){
		v1.setRed(color.getRed());
		v2.setRed(color.getRed());
		v3.setRed(color.getRed());
		v4.setRed(color.getRed());
		
		v1.setGreen(color.getGreen());
		v2.setGreen(color.getGreen());
		v3.setGreen(color.getGreen());
		v4.setGreen(color.getGreen());
		
		v1.setBlue(color.getBlue());
		v2.setBlue(color.getBlue());
		v3.setBlue(color.getBlue());
		v4.setBlue(color.getBlue());
	}

	@Override
	public float[] toFloatArray() {

		List<Float> list = new ArrayList<Float>();
		CollectionUtils.mergeArrayIntoCollection(this.v1.toFloatArray(), list);
		CollectionUtils.mergeArrayIntoCollection(this.v2.toFloatArray(), list);
		CollectionUtils.mergeArrayIntoCollection(this.v3.toFloatArray(), list);
		
		CollectionUtils.mergeArrayIntoCollection(this.v2.toFloatArray(), list);
		CollectionUtils.mergeArrayIntoCollection(this.v4.toFloatArray(), list);
		CollectionUtils.mergeArrayIntoCollection(this.v3.toFloatArray(), list);
		
		float[] arr = new float[list.size()];
		for(int i=0;i<list.size();i++){
			arr[i] = list.get(i).floatValue();
		}

		return arr;
	}
	
	public Vertex[] toVertexArray(){
		Vertex[] arr = {
				v1,v2,v3,v2,v4,v3
		};
		
		return arr;
	}
	
	public Collection<Vertex> toVertexCollection(){
		List<Vertex> list = new ArrayList<Vertex>();
		list.add(v1);
		list.add(v2);
		list.add(v3);
		list.add(v2);
		list.add(v4);
		list.add(v3);
		return list;
	}

}
