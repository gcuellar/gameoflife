package gol.scene;

public enum SceneEnum {

	TITLE(0), MAIN(1);

	private int index;

	SceneEnum(int index) {
		this.index = index;
	}
	
	public int index(){
		return this.index;
	}
}
