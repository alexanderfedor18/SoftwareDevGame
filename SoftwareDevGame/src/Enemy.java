import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Enemy extends Creature{

	private String startPoint;

	private BufferedImage upImage;
	private BufferedImage downImage;
	private BufferedImage leftImage;
	private BufferedImage rightImage;
	
		
	//Constructor
	public Enemy(float x, float y, int width, int height, String direction, float speed) {
		super(x, y, width, height);
		super.setHealth(1);
		super.setSpeed(speed);
		this.startPoint = direction;
		if (direction.equals("up")) {
			super.setX(235);
			super.setY(0);
		} else if(direction.equals("down")) {
			super.setX(235);
			super.setY(500);
		} else if(direction.equals("left")) {
			super.setX(0);
			super.setY(235);
		} else if (direction.equals("right")) {
			super.setX(500);
			super.setY(235);
		}

		//upImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\up.png");
		upImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\up.png");

		//downImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\down.png");
		downImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\down.png");
		
		//leftImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\left.png");
		leftImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\left.png");
		
		//rightImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\right.png");
		rightImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\right.png");		
	}

	@Override
	public void tick() {
		if (startPoint.equals("up")) {
			super.setY(super.getY()+super.getSpeed());			
		} else if (startPoint.equals("down")) {
			super.setY(super.getY() - super.getSpeed());
		} else if (startPoint.equals("left")) {
			super.setX(super.getX() + super.getSpeed());
		} else if (startPoint.equals("right")) {
			super.setX(super.getX() - super.getSpeed());
		}
		
		
	}

	@Override
	public void render(Graphics g) {
		if (startPoint.equals("up")) {
			g.drawImage(upImage, (int) x, (int)y, null);			
		} else if (startPoint.equals("down")) {
			g.drawImage(downImage, (int) x, (int)y, null);	
		} else if (startPoint.equals("left")) {
			g.drawImage(leftImage, (int) x, (int)y, null);	
		} else if (startPoint.equals("right")) {
			g.drawImage(rightImage, (int) x, (int)y, null);	
		}
		
		//g.setColor(new Color(238,33,68));
		//g.fillRect((int) super.getX(), (int)super.getY(), width, height);
		
	}

	//checks to see if the enemy was shielded, and if it was returns true
	public boolean checkShielded(Shield shield) {
		
		if (startPoint.equals("up")) {
			if (shield.getState() == "up" && shield.getY() <= super.getY() + super.getHeight()) {
				return true;
			}
		} else if (startPoint.equals("down")) {
			if (shield.getState() == "down" && shield.getY()+shield.getHeight() >= super.getY()) {
				return true;
			}
		} else if (startPoint.equals("left")) {
			if (shield.getState() == "left" && shield.getX() <= super.getX() + super.getWidth()) {
				return true;
			}
			
		} else if (startPoint.equals("right")) {
			if (shield.getState() == "right" && shield.getX() + shield.getWidth() >= super.getX()) {
				return true;
			}
		}
				
		return false;
	}
	
	
	//checks to see if the enemy hit the player, and if so returns true
	public boolean checkSucceed(Player player) {
		if (startPoint.equals("up")) {
			if (super.getY() + super.getHeight() >= 235) {
				return true;
			}
			
		} else if (startPoint.equals("down")) {
			if (super.getY() <= 265) {
				return true;
			}
		} else if (startPoint.equals("left")) {
			if (super.getX() + super.getWidth() >= 235) {
				return true;
			}
			
		} else if (startPoint.equals("right")) {
			if (super.getX() <= 265) {
				return true;
			}
		}
		return false;
	}
	
	
}
