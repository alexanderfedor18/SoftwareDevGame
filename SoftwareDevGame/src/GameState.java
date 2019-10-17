import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State{
	
	
	
	private Player player;
	private Shield shield;
	
	public GameState(Game game) {
		super(game);
		player = new Player(game,235,235);
		shield = new Shield(game,225,205);
	}
	
	@Override
	public void tick() {
		player.tick();
		shield.tick();
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 500, 500);
		g.setColor(Color.CYAN);
		player.render(g);
		shield.render(g);
	}
	

}
