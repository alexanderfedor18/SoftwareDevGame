import java.awt.Color;
import java.awt.Graphics;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game,float x, float y) {
		
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
		super.setHealth(5);
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillOval((int) x, (int) y, width, height);
		g.drawString("Health: " + super.getHealth(), 0, 480);
	}

	@Override
	public void die() {
		System.out.println("You lose");
		
	}

}
