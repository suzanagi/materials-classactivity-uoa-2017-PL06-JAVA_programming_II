
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class ExGUISwing_02 extends ExGUISwing_01 {

	// Use a JButton object for each button
	protected JButton[] buttons;
	// Use a JPanel object
	private JPanel[] panel;
	// Use a BevelBorder object for the central display
	private BevelBorder bb;
	// For showing text on the central display, use JLabel object
	private JLabel textLabel;
	// For showing text on the central display
	private JLabel titleLabel;
	
	// Declare the number of buttons
	protected final int buttonNum = 6;
	// Display size
	private int displayWidth = 353;
	private int displayHeight = 141;
	// Space size
	private int spaceEdge = 10;
	private int spaceMiddle = 10;
	private int spaceButtonTop = 8;
	private int spaceDisplayTop = 3;
	private int spaceDisplayBottom = 31;
	// Button size
	private final int buttonWidth = 55;
	private final int buttonHeight = 20;
	// Center Display size
	private int centerDispWidth = this.displayWidth - this.buttonWidth * 2 - this.spaceEdge * 2 - this.spaceMiddle * 2 - this.spaceDisplayTop;
	private int centerDispHeight = this.displayHeight - this.spaceDisplayTop - this.spaceDisplayBottom;
	
	/* Constructor */
	public ExGUISwing_02(String title) {
		// Call the constructor of its super class.
		super(title);
		// Create above JButton, JLabel and JPanel objects as attributes for future use.
		this.initComponents();
		// Get the Container object of the JFrame  (by getContentPane() of JFrame)
		Container ctn = this.getContentPane();
		// Remove the layout manager of the Container and JPanel objects by calling their setLayout(null). (This is to control the location and the size of the buttons and text by ourselves)
		ctn.setLayout(null);
		// Create a BevelBorder object and set it to the JPanel by its setBorder() method.
		this.bb = new BevelBorder(BevelBorder.LOWERED);
		this.panel[1].setBorder(this.bb);
		// Add the JButton and JPanel objects to the Container object (use add() method).
		this.placeComponents(ctn);
		// Change the JLabel object's foreground color to dark green.
		Color darkGreen = new Color(0, 130, 0);
		this.textLabel.setForeground(darkGreen);
		// Resize the display
		this.setDisplaySize(this.displayWidth, this.displayHeight);
	}
	
	/* Create above JButton, JLabel and JPanel objects as attributes for future use. */
	private void initComponents() {
		// Initialize the JButton objects
		this.buttons = new JButton[this.buttonNum];
		this.buttons[0] = new JButton("PW");
		this.buttons[1] = new JButton("AM");
		this.buttons[2] = new JButton("FM");
		this.buttons[3] = new JButton("CD");
		this.buttons[4] = new JButton("Up");
		this.buttons[5] = new JButton("Down");
		// Initialize the JLabel objects
		this.textLabel = new JLabel("Power off");
		this.titleLabel = new JLabel(" ");
		// Initialize the JPanel objects
		this.panel = new JPanel[3];
		for(int i = 0; i < 3; i++) this.panel[i] = new JPanel();
		// For each created object: Set the size (use setSize() method). 
		for(int i = 0; i < this.buttonNum; i++) this.buttons[i].setSize(this.buttonWidth, this.buttonHeight);
		this.panel[0].setSize(this.spaceEdge + this.buttonWidth + this.spaceMiddle, this.displayHeight);
		this.panel[1].setSize(this.centerDispWidth, this.centerDispHeight);
		this.panel[2].setSize(this.spaceEdge + this.buttonWidth + this.spaceMiddle, this.displayHeight);
		this.panel[1].setLayout(new BorderLayout());
		// For each created object: Set the location (use setLocation() method).
		for(int i = 0; i < this.buttonNum / 2; i++) this.buttons[i].setLocation(this.spaceEdge, this.spaceButtonTop + i * this.buttonHeight * 2);
		for(int i = this.buttonNum / 2; i < this.buttonNum; i++) this.buttons[i].setLocation(this.spaceEdge, this.spaceButtonTop + i * this.buttonHeight * 2);
		this.panel[0].setLocation(0, 0);
		this.panel[1].setLocation(this.spaceEdge + this.buttonWidth + this.spaceMiddle, spaceDisplayTop);
		this.panel[2].setLocation(this.spaceEdge + this.buttonWidth + this.spaceMiddle + this.centerDispWidth, 0);
//		this.textLabel.setLocation(0, 100);
//		this.titleLabel.setLocation(0, 0);
		// For the JLabel object: Create a Font object and set it to the JLabel (use setFont()).
		Font font = new Font("Arial", Font.BOLD, 30);
		this.textLabel.setFont(font);
	}
	
	/* Put the components on the container */
	private void placeComponents(Container c) {
		// Place each components
		JPanel temp = new JPanel();
		temp.setLayout(new FlowLayout(FlowLayout.CENTER));
		temp.add(textLabel);
		this.panel[1].add("North", this.titleLabel);
		this.panel[1].add("Center", temp);
		// Add the JLabel object  to the JPanel object.
		for(int i = 0; i < this.buttonNum / 2; i++) this.panel[0].add(buttons[i]);
		for(int i = this.buttonNum / 2; i < this.buttonNum; i++) this.panel[2].add(buttons[i]);
		for(int i = 0; i < 3; i++) c.add(panel[i]);
	
	}
	
	/* Change the content of titleLabel */
	protected void changeTitleString(String str) {
		System.out.println("ChangeTitle called");
		this.titleLabel.setText(str);
	}
	
	/* Change the content of textLabel */
	protected void changeTextString(String str) {
		this.textLabel.setText(str);
	}
	
	/* Main Method */
	public static void main(String argv[]) {
		// Create a ExGUISwing_02 object.
		ExGUISwing_02 egs02 = new ExGUISwing_02("Application of ExGUISwing-02::[Application of ExGUISwing-01]");
		// Call ExGUISwing_02's setVisible() with parameter "true".
		egs02.setVisible(true);
	}

}
