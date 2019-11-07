import java.awt.Graphics;

public abstract class Level {
	public static Level currentLevel = null;
	
	private long lastEnemyTimer, enemyCooldown, enemyTimer;

	

	public Level(Game game, EntityManager entityManager) {
		this.game = game;
		this.entityManager = entityManager;
	}
	
	
	protected Game game;
	protected EntityManager entityManager;
	
	
	public abstract void tick(); 
	
	public abstract void render(Graphics g);
	
	
	//getters and setters

	public static void setLevel(Level level) {
		currentLevel = level;
	}
	
	public static Level getLevel() {
		return currentLevel;
	}
	
	
	
	public long getLastEnemyTimer() {
		return lastEnemyTimer;
	}



	public void setLastEnemyTimer(long lastEnemyTimer) {
		this.lastEnemyTimer = lastEnemyTimer;
	}



	public long getEnemyCooldown() {
		return enemyCooldown;
	}



	public void setEnemyCooldown(long enemyCooldown) {
		this.enemyCooldown = enemyCooldown;
	}



	public long getEnemyTimer() {
		return enemyTimer;
	}



	public void setEnemyTimer(long enemyTimer) {
		this.enemyTimer = enemyTimer;
	}
	
	public abstract int returnLevelNumber();


}
