import javax.swing.JFrame;


//used to store the JFrame data and create the display
public class Display {
	
	private JFrame frame;
	
	private String title;
	private int width, height;
	
	//constructor
	public Display(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
		
		createDisplay();
	}
	
	//creates the display using the variables input beforehand
	public void createDisplay() {
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
