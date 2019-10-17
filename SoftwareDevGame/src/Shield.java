import java.awt.Color;
import java.awt.Graphics;

public class Shield extends Entity{

	private static final int baseWidth = 50;
	private static final int baseHeight = 20;
	
	private Game game;
	
	public Shield(Game game, float x, float y) {
		super(x, y, baseWidth, baseHeight);
		this.game = game;
	}

	@Override
	public void tick() {
		if (game.getKeyManager().up) {
			super.setX(225);
			super.setY(205);
			super.setHeight(baseHeight);
			super.setWidth(baseWidth);
		}
		if (game.getKeyManager().left) {
			super.setX(205);
			super.setY(225);
			super.setHeight(baseWidth);
			super.setWidth(baseHeight);
		}
		if (game.getKeyManager().down) {
			super.setX(225);
			super.setY(275);
			super.setHeight(baseHeight);
			super.setWidth(baseWidth);
		}
		if (game.getKeyManager().right) {
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

}
