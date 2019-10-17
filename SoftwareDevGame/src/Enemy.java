import java.awt.Color;
import java.awt.Graphics;

public class Enemy extends Creature{

	private String startPoint;
		
	//Constructor
	public Enemy(float x, float y, int width, int height, String direction) {
		super(x, y, width, height);
		super.setHealth(1);
		super.setSpeed(2);
		this.startPoint = direction;
		if (direction == "up") {
			super.setX(235);
			super.setY(0);
		} else if(direction == "down") {
			super.setX(235);
			super.setY(500);
		} else if(direction == "left") {
			super.setX(0);
			super.setY(235);
		} else if (direction == "right") {
			super.setX(500);
			super.setY(235);
		}
		
	}

	@Override
	public void tick() {
		if (startPoint == "up") {
			super.setY(super.getY()+super.getSpeed());			
		} else if (startPoint == "down") {
			super.setY(super.getY() - super.getSpeed());
		} else if (startPoint == "left") {
			super.setX(super.getX() + super.getSpeed());
		} else if (startPoint == "right") {
			super.setX(super.getX() - super.getSpeed());
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect((int) super.getX(), (int)super.getY(), width, height);
	}

	@Override
	public void die() {
		
	}
	
	//checks to see if the enemy was shielded, and if it was returns true
	public boolean checkShielded(Shield shield) {
		
		if (startPoint == "up") {
			if (shield.getState() == "up" && shield.getY() <= super.getY() + super.getHeight()) {
				return true;
			}
		} else if (startPoint == "down") {
			if (shield.getState() == "down" && shield.getY()+shield.getHeight() >= super.getY()) {
				return true;
			}
		} else if (startPoint == "left") {
			if (shield.getState() == "left" && shield.getX() <= super.getX() + super.getWidth()) {
				return true;
			}
			
		} else if (startPoint == "right") {
			if (shield.getState() == "right" && shield.getX() + shield.getWidth() >= super.getX()) {
				return true;
			}
		}
				
		return false;
	}
	
	
	//checks to see if the enemy hit the player, and if so returns true
	public boolean checkSucceed(Player player) {
		if (startPoint == "up") {
			if (super.getY() + super.getHeight() >= 235) {
				return true;
			}
			
		} else if (startPoint == "down") {
			if (super.getY() <= 265) {
				return true;
			}
		} else if (startPoint == "left") {
			if (super.getX() + super.getWidth() >= 235) {
				return true;
			}
			
		} else if (startPoint == "right") {
			if (super.getX() <= 265) {
				return true;
			}
		}
		return false;
	}
	
	
}
