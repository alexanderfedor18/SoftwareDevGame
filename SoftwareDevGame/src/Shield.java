import java.awt.Color;
import java.awt.Graphics;

public class Shield extends Entity{

	private static final int baseWidth = 50;
	private static final int baseHeight = 20;
	
	private static final int vertX = 225;
	private static final int upY = 205;
	private static final int downY = 275;
	
	private static final int horizonY = 225;
	private static final int leftX = 205;
	private static final int rightX = 275;
	
	
	
	
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
			super.setX(vertX);
			super.setY(upY);
			super.setHeight(baseHeight);
			super.setWidth(baseWidth);
		}
		if (game.getKeyManager().left) {
			state = "left";
			super.setX(leftX);
			super.setY(horizonY);
			super.setHeight(baseWidth);
			super.setWidth(baseHeight);
		}
		if (game.getKeyManager().down) {
			state = "down";
			super.setX(vertX);
			super.setY(downY);
			super.setHeight(baseHeight);
			super.setWidth(baseWidth);
		}
		if (game.getKeyManager().right) {
			state = "right";
			super.setX(rightX);
			super.setY(horizonY);
			super.setHeight(baseWidth);
			super.setWidth(baseHeight);
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect((int) x,(int) y, width, height);
		
	}
	
	public String getState() {
		return state;
	}

	@Override
	public void die() {
		
	}
	
}
