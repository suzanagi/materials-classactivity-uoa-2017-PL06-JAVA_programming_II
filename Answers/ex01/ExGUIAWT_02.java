import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExGUIAWT_02 extends ExGUIAWT_01 implements ActionListener {
	
	private Button plus;
	private Button minus;
	private Label numLabel;
	private int number;
	
	public void init() {
		// Call super class's init() method
		super.init();
		
		// Initialize the components for Applet
		plus = new Button("+");
		minus = new Button("-");
		number = 0;
		numLabel = new Label(String.valueOf(number));
		
		// Add action listener (this) to each button (use addActionListener(this)). That is, we use one listener to catch events from all the buttons.
		plus.addActionListener(this);
		minus.addActionListener(this);
		
		// Place the buttons and the label on the Applet 
		add(minus);
		add(numLabel);
		add(plus);
	}
	
	// If the argument is true, change the value of label to positive, else, change it to negative.
	protected void editValue(int difference) {
		// Change the number by calculating it with the argument
		number += difference;
		// Update the label
		numLabel.setText(String.valueOf(number));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Get the source object on which the event occurred
		Object o = e.getSource();
		
		if(o ==  plus) {
			// Increase the number if the plus button is clicked
			editValue(1);
		}
		else if(o == minus) {
			// Decrease the number if the minus button is clicked
			editValue(-1);
		}
		else {
			// The source object should be one of the buttons saved in the attributes
			System.out.println("Something wrong ActionListener is running");
		}
	}

}
