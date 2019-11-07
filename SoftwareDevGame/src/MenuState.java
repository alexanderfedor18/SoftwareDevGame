import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuState extends State{

	private boolean startButton;
	Font buttonFont;
	private GameState gameState;
	public MenuState(Game game) {
		super(game);
		startButton = true;
		buttonFont = new Font("TimesRoman", Font.PLAIN, 30);
		gameState = new GameState(game);
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
			
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 500, 500);
		g.setColor(new Color(0,100,225));
		g.fillRect(125, 125, 250, 150);
		
		g.setColor(new Color(255,25,25));
		g.fillRect(125, 300, 250, 150);
		
		g.setFont(new Font("TimeNewRoman", Font.PLAIN, 40));
		g.setColor(Color.white);
		g.drawString("Software Development", 60, 50);
		g.drawString("Game", 200, 100);
		
		g.setFont(buttonFont);
		g.setColor(new Color(200,175,0));
		g.drawString("Press Enter to", 160, 195);
		g.drawString("Start the Game!", 160, 225);
		g.setColor(new Color(70,70,255));
		g.drawString("Press Escape to", 160, 365);
		g.drawString("Exit the Game!", 160, 395);
		
		
	}

}
