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
	
	
	public Game(String title, int width, int height) {
		this.width = width;
		this.height = height;
		this.title = title;
	}
	
	//runs once, initializes the graphics of our game
	private void init() {
		display = new  Display(title, width, height);
		
	}
	int x = 0;
	
	//updates the games data over and over
	private void tick() {
		x += 1;
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
		//Draw here!
		
		g.setColor(Color.green);
		g.fillRect(x,0,10,10);
		
		
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
		long timer = 0;
		int ticks = 0;
		
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) {
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		stop();
		
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
