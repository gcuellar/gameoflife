package gol.render.shader;

import static org.lwjgl.opengl.GL11.GL_TRUE;
import static org.lwjgl.opengl.GL20.GL_COMPILE_STATUS;
import static org.lwjgl.opengl.GL20.glCompileShader;
import static org.lwjgl.opengl.GL20.glCreateShader;
import static org.lwjgl.opengl.GL20.glDeleteShader;
import static org.lwjgl.opengl.GL20.glGetShaderInfoLog;
import static org.lwjgl.opengl.GL20.glGetShaderi;
import static org.lwjgl.opengl.GL20.glShaderSource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * This class represents a shader.
 *
 * @author Heiko Brumme
 */
public class Shader {

    /**
     * Stores the handle of the shader.
     */
    private final int id;

    /**
     * Creates a shader with specified type and source and compiles it. The type
     * in the tutorial should be either <code>GL_VERTEX_SHADER</code> or
     * <code>GL_FRAGMENT_SHADER</code>.
     *
     * @param type   Type of the shader
     * @param source Source of the shader
     */
    public Shader(int type, CharSequence source) {
        id = glCreateShader(type);
        glShaderSource(id, source);
        glCompileShader(id);

        checkStatus();
    }
    


    /**
     * Checks if the shader was compiled successfully.
     */
    private void checkStatus() {
        int status = glGetShaderi(id, GL_COMPILE_STATUS);
        if (status != GL_TRUE) {
            throw new RuntimeException(glGetShaderInfoLog(id));
        }
    }

    /**
     * Deletes the shader.
     */
    public void delete() {
        glDeleteShader(id);
    }

    /**
     * Getter for the shader ID.
     *
     * @return Handle of this shader
     */
    public int getID() {
        return id;
    }

    /**
     * Load shader from file.
     *
     * @param type Type of the shader
     * @param fileName File path of the shader
     *
     * @return Shader from specified file
     */
    public static Shader loadShader(int type, String fileName) {
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
		
		return new Shader(type, shaderSource);
    }

}
