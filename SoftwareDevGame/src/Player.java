import java.awt.Graphics;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game,float x, float y) {
		
		super(x, y);
		this.game = game;
	}

	@Override
	public void tick() {
		if (game.getKeyManager().up) {
			y -= 3;
		}
		if (game.getKeyManager().down) {
			y += 3;
		}
		if (game.getKeyManager().left) {
			x -= 3;
		}
		if (game.getKeyManager().right) {
			x += 3;
		}
	}

	@Override
	public void render(Graphics g) {
		g.fillOval((int) x, (int) y, 30, 30);
	}

}
