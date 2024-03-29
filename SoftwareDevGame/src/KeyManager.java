import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener{
	
	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean eU,eD,eL,eR;
	public boolean enter, escape;
	public boolean spacebar;
	
	public KeyManager() {
		keys = new boolean[256];
	}
	
	public void tick() {
		up = keys[KeyEvent.VK_UP];
		down = keys[KeyEvent.VK_DOWN];
		left = keys[KeyEvent.VK_LEFT];
		right = keys[KeyEvent.VK_RIGHT];
		
		eU = keys[KeyEvent.VK_W];
		eD = keys[KeyEvent.VK_S];
		eL = keys[KeyEvent.VK_A];
		eR = keys[KeyEvent.VK_D];
		
		enter = keys[KeyEvent.VK_ENTER];
		escape = keys[KeyEvent.VK_ESCAPE];
		spacebar = keys[KeyEvent.VK_SPACE];
		
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	
}
