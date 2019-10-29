import java.awt.Graphics;

public class LevelOne extends Level {
	
	private final int ENEMY_SIZE = 30;
	private final float ENEMY_SPEED = 2.0f;
	
	
	
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
			
				entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, "up", ENEMY_SPEED));
			

			this.setEnemyTimer(0);
	
		}
			
			}

}
