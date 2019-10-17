import java.awt.Color;
import java.awt.Graphics;

public class GameState extends State{
	
	
	private EntityManager entityManager;
	private Level levelOne;
	public GameState(Game game) {
		super(game);
		entityManager = new EntityManager(new Player(game,235,235), new Shield(game,225,205));
		levelOne = new LevelOne(game, entityManager);
		Level.setLevel(levelOne);
		
		
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
		
		entityManager.render(g);
		
		
	}
	

}
