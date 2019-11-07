import java.awt.Graphics;
import java.io.File;
import java.util.Scanner;

public class LevelTwo extends Level {
	
	private final int ENEMY_SIZE = 30;
	private final float ENEMY_SPEED = 2.0f;
	
	File file;
	Scanner sc;
	String direction;
	private LevelThree LevelThree;
	
	public LevelTwo(Game game,EntityManager entityManager) {
		super(game, entityManager);
		this.setEnemyCooldown(800);
		this.setEnemyTimer(this.getEnemyCooldown());
		LevelThree = new LevelThree(game, super.entityManager);
		file =  new File("H:\\git\\SoftwareDevGame\\LevelTwo.txt");
		//file = new File("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\LevelTwo.txt");
		
		
		try {

			sc = new Scanner(file);
		} catch (Exception e) {
			
		}
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
			}else if (entityManager.getEntities().isEmpty()) {
				Level.setLevel(LevelThree);
			}

			this.setEnemyTimer(0);
	
		}
			
			}


	@Override
	public int returnLevelNumber() {
		return 2;
	}

}
