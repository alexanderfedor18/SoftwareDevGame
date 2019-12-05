import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class MenuState extends State{

	Font buttonFont;
	private GameState gameState;
	private BufferedImage menuImage;
	public MenuState(Game game) {
		super(game);
		buttonFont = new Font("TimesRoman", Font.PLAIN, 30);
		gameState = new GameState(game);
		menuImage = ImageLoader.loadImage("H:\\git\\SoftwareDevGame\\mainmenu.jpg");
		//menuImage = ImageLoader.loadImage("C:\\Users\\ultim\\Documents\\Git\\SoftwareDevGame\\mainmenu'.jpg");
	}
	
	
	
	@Override
	public void tick() {
		if (game.getKeyManager().enter) {
			State.setState(gameState);
		} else if (game.getKeyManager().escape) {
			System.exit(0);
		}
	}

	@Override
	public void render(Graphics g) {
//			
//		g.setColor(new Color(100,100,100));
//		g.fillRect(0, 0, 500, 500);
//		g.setColor(new Color(50,50,255));
//		g.fillRect(125, 125, 250, 150);
//		
//		g.setColor(new Color(255,60,60));
//		g.fillRect(125, 300, 250, 150);
//		
//		g.setFont(new Font("Comic Sans", Font.PLAIN, 40));
//		g.setColor(Color.white);
//		g.drawString("Software Development", 60, 50);
//		g.drawString("Game", 200, 100);
//		
//		g.setFont(buttonFont);
//		g.setColor(new Color(255,75,75));
//		g.drawString("Press Enter to", 160, 195);
//		g.drawString("Start the Game!", 160, 225);
//		g.setColor(new Color(50,50,255));
//		g.drawString("Press Escape to", 160, 365);
//		g.drawString("Exit the Game!", 160, 395);
		g.drawImage(menuImage,0, 0, null);
		
		
	}

}
