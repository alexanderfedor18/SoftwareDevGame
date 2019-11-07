import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

public class LevelThree extends Level {
	
	private final int ENEMY_SIZE = 30;
	private final float ENEMY_SPEED = 3.0f;
	File file;
	Scanner sc;
	private LevelFour levelFour;
	
	public LevelThree(Game game,EntityManager entityManager) {
		super(game, entityManager);
		this.setEnemyCooldown(500);
		this.setEnemyTimer(this.getEnemyCooldown());
		//file = new File("H:\\git\\SoftwareDevGame\\LevelThree.txt");
		file = new File("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\LevelThree.txt");
		try {
			sc =new Scanner(file);	
		} catch (Exception e) {
			
		}
		levelFour = new LevelFour(game, entityManager);
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
			if (sc.hasNext()) {
				String direction = sc.next();
				entityManager.addEntity(new Enemy(0,0, ENEMY_SIZE, ENEMY_SIZE, direction, ENEMY_SPEED));
			} else if (entityManager.getEntities().isEmpty()) {
				Level.setLevel(levelFour);
			}
				

			this.setEnemyTimer(0);
	
		}
			
			}




	@Override
	public int returnLevelNumber() {
		return 3;
	}

}
