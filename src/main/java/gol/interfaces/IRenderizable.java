package gol.interfaces;

public interface IRenderizable {

	/**
	 * Renders the state (no interpolation).
	 */
	public default void render() {
		render(1f);
	}

	/**
	 * Renders the state (with interpolation).
	 *
	 * @param alpha
	 *            Alpha value, needed for interpolation
	 */
	public void render(float alpha);
}
