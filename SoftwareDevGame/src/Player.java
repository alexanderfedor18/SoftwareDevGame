import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Player extends Creature {

	private Game game;
	private BufferedImage earthImage;
	public Player(Game game,float x, float y) {
		
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		super.setHealth(3);
		//earthImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\SaberArtGoStage2.png");
		earthImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\earth.png");
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(earthImage, (int) x, (int) y, null);
		
//		g.setColor(new Color(97,219,255));
//		g.fillOval((int) x, (int) y, width, height);
		if (this.getHealth() > 0) {
			g.drawString("Health: " + super.getHealth(), 370, 30);	
		}
		else {
			State.setState(game.gameOverState);
			super.setHealth(3);
		
		}
	}



}
