import java.awt.Graphics;

public abstract class Level {
	public static Level currentLevel = null;
	
	

	public Level(Game game, EntityManager entityManager) {
		this.game = game;
		this.entityManager = entityManager;
	}
	
	
	
	public static void setLevel(Level level) {
		currentLevel = level;
	}
	
	public static Level getLevel() {
		return currentLevel;
	}
	
	protected Game game;
	protected EntityManager entityManager;
	
	
	public abstract void tick(); 
	
	public abstract void render(Graphics g);
}
