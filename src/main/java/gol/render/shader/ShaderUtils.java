package gol.render.shader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;

public class ShaderUtils {

	/**
	 * Load shader from file into GPU
	 * 
	 * @param fileName path
	 * @param type GL_VERTEX_SHADER or GL_FRAGMENT_SHADER
	 * @return
	 */
	public static int compileShader(String fileName, int type){
		StringBuilder shaderSource = new StringBuilder();
		try {
			File file = new File(Thread.currentThread()
					.getContextClassLoader()
					.getResource(fileName)
					.getFile());
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while ((line = reader.readLine()) != null){
				shaderSource.append(line).append("\n");{
				}
			}
			reader.close();
		} catch (Exception e) {
			System.err.println("Could not read file! - "+fileName);
			e.printStackTrace();
		}
		int shaderID = GL20.glCreateShader(type);
		GL20.glShaderSource(shaderID, shaderSource);
		GL20.glCompileShader(shaderID);
		
		int status = GL20.glGetShaderi(shaderID, GL20.GL_COMPILE_STATUS);
		if (status != GL11.GL_TRUE){
			 throw new RuntimeException(GL20.glGetShaderInfoLog(shaderID, 5000));
		}
		
		return shaderID;
	}
	
	public static int linkProgram(int vertexShaderId, int fragmentShaderId){
		int shaderProgram = GL20.glCreateProgram();
		GL20.glAttachShader(shaderProgram, vertexShaderId);
		GL20.glAttachShader(shaderProgram, fragmentShaderId);
		// Next line is optional when we have just one out variable in our fragment shader and
		// it gets bound to the color number 0 by default
		GL30.glBindFragDataLocation(shaderProgram, 0, "fragColor");
		GL20.glLinkProgram(shaderProgram);
		
		int status = GL20.glGetProgrami(shaderProgram, GL20.GL_LINK_STATUS);
		if (status != GL11.GL_TRUE) {
		    throw new RuntimeException(GL20.glGetProgramInfoLog(shaderProgram));
		}
		
		return shaderProgram;
	}
}
