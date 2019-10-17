import java.awt.Graphics;

public class LevelOne extends Level {
	
	private final int ENEMY_SIZE = 30;
	
	
	public LevelOne(Game game,EntityManager entityManager) {
		super(game, entityManager);
		
	}

	@Override
	public void tick() {
		if (game.getKeyManager().eU) {
			entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "up"));
		} else if (game.getKeyManager().eD) {
			entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "down"));
		} else if (game.getKeyManager().eL) {
			entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "left"));
		} else if (game.getKeyManager().eR) {
			entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "right"));
		}
	}

	@Override
	public void render(Graphics g) {
		
	}

}
