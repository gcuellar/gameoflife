package gol.interfaces;

public interface IUpdatable {

	public void input();

	public default void update() {
		update(1f);
	}

	public void update(float delta);

	/**
	 * Gets executed when entering the state, useful for initialization.
	 */
	public void enter();

	/**
	 * Gets executed when leaving the state, useful for disposing.
	 */
	public void exit();
}
