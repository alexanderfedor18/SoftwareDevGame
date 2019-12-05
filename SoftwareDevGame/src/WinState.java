import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class WinState extends State{


	private BufferedImage winImage;
	
	public WinState(Game game) {
		super(game);
		winImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\win.png");
		//winImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\win.png");
	}

	@Override
	public void tick() {
		if (game.getKeyManager().escape) {
			System.exit(0);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(winImage, 0, 0, null);	
		
//		g.setColor(Color.gray);
//		g.fillRect(0, 0, 500, 500);
//		
//		g.setColor(Color.BLUE);
//		Font gameOver = new Font("TimesNewRoman", Font.PLAIN, 50);
//		g.setFont(gameOver);
//		g.drawString("Congrats, you win!", 40, 150);
//		g.drawString("Press Escape to Exit,", 20, 210);
//		//g.setFont(new Font("TimesNewRoman", Font.PLAIN, 40));
//		g.drawString("and try to win again!", 30, 260);
}
		
	}


