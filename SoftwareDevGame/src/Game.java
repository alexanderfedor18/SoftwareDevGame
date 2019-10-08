// acts as the main space for our game's basic functions to be run
public class Game {

	
	private Display display;
	
	private int width, height;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		display = new  Display(title, width, height);
	}
	
}
