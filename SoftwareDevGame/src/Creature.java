
public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 3;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 30;
	public static final int DEFAULT_CREATURE_HEIGHT = 30;
	
	protected int health;
	protected float speed;
	
	public Creature(float x, float y, int width, int height) {
		super(x, y,width,height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	
}
