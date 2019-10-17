import java.awt.Graphics;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game,float x, float y) {
		
		super(x, y, Creature.DEFAULT_CREATURE_WIDTH,Creature.DEFAULT_CREATURE_HEIGHT);
		this.game = game;
	}

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.fillOval((int) x, (int) y, width, height);
	}

}
