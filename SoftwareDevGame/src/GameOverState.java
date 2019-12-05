import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class GameOverState extends State{
	
	private BufferedImage lostImage;

	public GameOverState(Game game) {
		super(game);
		lostImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\lost.png");
		//lostImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\lost.png");
	}

	@Override
	public void tick() {
		if (game.getKeyManager().escape) {
			System.exit(0);
		}
		
	}

	@Override
	public void render(Graphics g) {
		
		g.drawImage(lostImage, 0, 0, null);
		
//		g.setColor(Color.gray);
//		g.fillRect(0, 0, 500, 500);
//		
//		g.setColor(Color.white);
//		Font gameOver = new Font("TimesNewRoman", Font.PLAIN, 50);
//		g.setFont(gameOver);
//		g.drawString("Sorry, you lost!", 90, 150);
//		g.drawString("Press Escape to Exit,", 10, 210);
//		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 40));
//		g.drawString("and try to win next time!", 50, 250);
		
		
	}

}
