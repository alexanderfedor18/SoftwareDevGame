import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class EntityManager {

	private Player player;
	private Shield shield;
	private ArrayList<Entity> entities;
	
	
	public EntityManager(Player player, Shield shield) {
		this.player = player;
		this.shield = shield;
		entities = new ArrayList<Entity>();
		
	}
	
	public void tick() {
		player.tick();
		shield.tick();
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			e.tick();
			if (e instanceof Enemy) {
				Enemy en = (Enemy) e;
				
				//checks if the enemy is shielded, and if it does it kills the enemy
				if (en.checkShielded(shield)) {
					e.hurt(1);
				}
				
				//checks if the enemy successfully got through to the player, and if it does hurts the player
				if (en.checkSucceed(player)) {
				e.setActive(false);
				player.hurt(1);
				}
				
				
			}
			//checks to see if the entity is still active, and if not removes it
			if(!e.isActive()) {
				entities.remove(e);
			}
		}
		
		
	}
	
	public void render (Graphics g) {

		player.render(g);
		shield.render(g);
		
		g.setColor(Color.RED);
		for (Entity e : entities) {
			e.render(g);
		}

		
	}
	
	
	public void addEntity(Entity e) {
		entities.add(e);
	}
	
	
	
	//Getters and Setters
	
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public ArrayList<Entity> getEntities() {
		return entities;
	}
	public void setEntities(ArrayList<Entity> entities) {
		this.entities = entities;
	}
	
}
