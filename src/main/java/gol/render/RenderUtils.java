package gol.render;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import gol.render.datatypes.Vertex;

public class RenderUtils {

	public static FloatBuffer floatBufferFrom(Vertex[] array){
		FloatBuffer fBuffer = null;
		
		if(array != null && array.length > 0){
			fBuffer = BufferUtils.createFloatBuffer(array.length * Vertex.NUM_OF_COMPONENTS);
			for(int i=0;i<array.length;i++){
				fBuffer.put(array[i].toFloatArray());
			}
			fBuffer.flip();
		}
		return fBuffer;
	}
}
