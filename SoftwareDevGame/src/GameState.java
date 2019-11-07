import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class GameState extends State{
	
	
	private EntityManager entityManager;
	private Level levelOne;
	Font levelFont;
	public GameState(Game game) {
		super(game);
		entityManager = new EntityManager(new Player(game,235,235), new Shield(game,225,205));
		levelOne = new LevelOne(game, entityManager);
		Level.setLevel(levelOne);
		levelFont = new Font("TimesNewRoman", Font.PLAIN, 30);
		
	}
	
	@Override
	public void tick() {
		Level.getLevel().tick();
		entityManager.tick();
		if (Level.getLevel() != null) {
			Level.getLevel().tick();
		}
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, 500, 500);	
		if (Level.getLevel() != null) {
			Level.getLevel().render(g);
		}
		
		
		int currentlevel = Level.getLevel().returnLevelNumber();
		g.setFont(levelFont);
		g.setColor(Color.red);
		if (currentlevel == 1) {
			g.drawString("Level One", 5, 30);
		} else if (currentlevel == 2) {
			g.drawString("Level Two", 5, 30);
		} else if (currentlevel == 3) {
			g.drawString("Level Three", 5, 30);
		} else if (currentlevel == 4) {
			g.drawString("Level Four" , 5, 30);
		}
		
		entityManager.render(g);
		
		
	}
	

}
