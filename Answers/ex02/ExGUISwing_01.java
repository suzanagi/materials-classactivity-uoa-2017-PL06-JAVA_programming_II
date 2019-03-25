import javax.swing.JFrame;

public class ExGUISwing_01 extends JFrame {
	
	// Size of display
	private int displayWidth = 400;
	private int displayHeight = 200;
	
	/* Constructor */
	public ExGUISwing_01(String title) {
		// Call the constructor of JFrame with a title string.
		super(title);
		// Set the initial size of the window (by setSize() of JFrame) .
		setSize(this.displayWidth, this.displayHeight);
		// Call the setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) for termination of the program when the window is closed.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/* change display size (For inherited classes) */
	protected void setDisplaySize(int width, int height) {
		this.displayWidth = width;
		this.displayHeight = height;
		this.setSize(this.displayWidth, this.displayHeight);
	}
	
	/* Main Method */
	public static void main(String argv[ ]) {
		// The string value given to ExGUISwing_01 object as a title.
		String title = "Application of ExGUISwing-01";
		// Create a ExGUISwing_01 object.
		ExGUISwing_01 egs1 = new ExGUISwing_01(title);
		// Call ExGUISwing_01's setVisible() with parameter "true".
		egs1.setVisible(true);
	}
}
