import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameOverState extends State{

	public GameOverState(Game game) {
		super(game);
	}

	@Override
	public void tick() {
		if (game.getKeyManager().escape) {
			System.exit(0);
		}
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(0, 0, 500, 500);
		
		g.setColor(Color.white);
		Font gameOver = new Font("TimesNewRoman", Font.PLAIN, 50);
		g.setFont(gameOver);
		g.drawString("Sorry, you lost!", 90, 150);
		g.drawString("Press Escape to Exit,", 10, 210);
		g.setFont(new Font("TimesNewRoman", Font.PLAIN, 40));
		g.drawString("and try to win next time!", 50, 250);
		
		
	}

}
