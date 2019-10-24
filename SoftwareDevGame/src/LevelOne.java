import java.awt.Graphics;

public class LevelOne extends Level {
	
	private final int ENEMY_SIZE = 30;
	
	
	
	
	public LevelOne(Game game,EntityManager entityManager) {
		super(game, entityManager);
		this.setEnemyCooldown(800);
		this.setEnemyTimer(this.getEnemyCooldown());
		
	}
	
	@Override
	public void tick() {
		
		spawnEnemy();
	}

	@Override
	public void render(Graphics g) {
		
	}
	
	
	public void spawnEnemy() {
		this.setEnemyTimer(this.getEnemyTimer() + System.currentTimeMillis() - this.getLastEnemyTimer());
		this.setLastEnemyTimer(System.currentTimeMillis());
		if (this.getEnemyTimer() < this.getEnemyCooldown()) {
			return;
		} else {
			if (game.getKeyManager().eU) {
				entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "up"));
			} else if (game.getKeyManager().eD) {
				entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "down"));
			} else if (game.getKeyManager().eL) {
				entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "left"));
			} else if (game.getKeyManager().eR) {
				entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "right"));
			}

			this.setEnemyTimer(0);
	
		}
			
			}

}
