import java.awt.*;
import java.awt.image.*;

// acts as the main space for our game's basic functions to be run


public class Game implements Runnable{

	
	private Display display;
	private int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs; // tells computer how to draw things to the screen, prevents flickering
	private Graphics g;
	
	//Input
	private KeyManager keyManager;
	
	//States
	private State gameState;
	private State menuState;
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}
	
	//runs once, initializes the graphics of our game
	private void init() {
		display = new  Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		gameState = new GameState(this);
		menuState = new MenuState(this);
		State.setState(menuState);
		
		
	}
	
	
	//updates the games data over and over
	private void tick() {
		keyManager.tick();
		
		if (State.getState() != null) {
			State.getState().tick();
		}
	}
	
	//renders game items over and over
	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0,0,width,height);
		if (State.getState() != null) {
			State.getState().render(g);
		}
		//Draw here!
		
		//End Drawing
		bs.show();
		g.dispose(); 
	}
	
	public void run() {
		
		init();
		
		//the following ensures that the game runs at the same speed on any computer
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		//long timer = 0;
		//int ticks = 0;
		
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			//timer += now - lastTime;
			
			
			if (delta >= 1) {
				tick();
				render();
				//ticks++;
				delta--;
			}
			
			/*if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}*/
		}
		
		stop();
		
	}
	
	public KeyManager getKeyManager() {
		return keyManager;
	}
	
	
	
	//starts the thread after checking if the game is already running
	public synchronized void start() {
		if(running) 
			return;
		running = true;
		thread = new Thread(this); //initializes thread to this game class
		thread.start(); //starts thread
	}
	
	//safely stops the thread unless the game has already been stopped
	public synchronized void stop() {
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
