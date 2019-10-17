import java.awt.Graphics;

public abstract class Entity {

	public static final int DEFAULT_HEALTH = 3;
	protected float x,y;
	protected int width, height;
	protected int health;

	protected boolean active = true;
	
	//constructor
	public Entity(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		health = DEFAULT_HEALTH;
	}
	

	public abstract void tick();
	
	public abstract void render(Graphics g);
	
	//decreases entity health
	public void hurt(int amt) {
		health -= amt;
		if (health <= 0) {
			active = false;
			die();
		}
	}
	
	//does certain commands upon losing all health
	public abstract void die();
	
	
	
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
