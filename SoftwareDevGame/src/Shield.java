import java.awt.Color;
import java.awt.Graphics;

public class Shield extends Entity{

	private static final int baseWidth = 50;
	private static final int baseHeight = 20;
	
	private String state;
	private Game game;
	
	public Shield(Game game, float x, float y) {
		super(x, y, baseWidth, baseHeight);
		state = "up";
		this.game = game;
	}

	@Override
	public void tick() {
		if (game.getKeyManager().up) {
			state = "up";
			super.setX(225);
			super.setY(205);
			super.setHeight(baseHeight);
			super.setWidth(baseWidth);
		}
		if (game.getKeyManager().left) {
			state = "left";
			super.setX(205);
			super.setY(225);
			super.setHeight(baseWidth);
			super.setWidth(baseHeight);
		}
		if (game.getKeyManager().down) {
			state = "down";
			super.setX(225);
			super.setY(275);
			super.setHeight(baseHeight);
			super.setWidth(baseWidth);
		}
		if (game.getKeyManager().right) {
			state = "right";
			super.setX(275);
			super.setY(225);
			super.setHeight(baseWidth);
			super.setWidth(baseHeight);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) x,(int) y, width, height);
		
	}
	
	public String getState() {
		return state;
	}
	
}
