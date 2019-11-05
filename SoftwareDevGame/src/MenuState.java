import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuState extends State{

	private boolean startButton;
	Font buttonFont;
	public MenuState(Game game) {
		super(game);
		startButton = true;
		buttonFont = new Font("TimesRoman", Font.PLAIN, 30);
	}
	
	
	
	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 500, 500);
		g.setColor(new Color(200,200,230));
		g.fillRect(150, 150, 200, 100);
		
		
		g.setFont(buttonFont);
		g.setColor(new Color(200,0,0));
		g.drawString("Start Game", 185, 205);
	}

}
