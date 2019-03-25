
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExGUISwing_03 extends ExGUISwing_02 implements ActionListener {
	
	// Last pushed button
	private int lastButton = 0;
//	// Power on/off
//	private boolean power = false;
	// AM Hz value
	private int amhz = 594;
	// FM Mhz value
	private double fmmhz = 76.1;
	
	/* Constructor */
	public ExGUISwing_03(String title) {
		// Call the constructor of its super class
		super(title);
//		// Implement ActionListener for all of the buttons
//		for(int i = 0; i < this.buttonNum; i++) {
//			this.buttons[i].addActionListener(new ActionListener{
//				public void actionPerformed(ActionEvent e) {
//					
//				}
//			});
//		}
		this.buttons[0].setEnabled(false);
		this.buttons[4].setEnabled(false);
		this.buttons[5].setEnabled(false);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.buttons[0]) {
			// Power off
//			if(this.power) {
//			this.power = false;
			this.buttons[0].setEnabled(false);
			this.buttons[4].setEnabled(false);
			this.buttons[5].setEnabled(false);
			this.changeTitleString(" ");
			this.changeTextString("Power off");
			this.lastButton = 0;
//			}
		}
		else if(e.getSource() == this.buttons[1]) {
			// AM
			this.buttons[0].setEnabled(true);
			this.buttons[4].setEnabled(true);
			this.buttons[5].setEnabled(true);
			super.changeTitleString("AM");
			this.changeTextString(this.amhz + " kHz");
			this.lastButton = 1;
		}
		else if(e.getSource() == this.buttons[2]) {
			// FM
			this.buttons[0].setEnabled(true);
			this.buttons[4].setEnabled(true);
			this.buttons[5].setEnabled(true);
			this.changeTitleString("FM");
			this.lastButton = 2;
		}
		else if(e.getSource() == this.buttons[3]) {
			// CD
			this.buttons[0].setEnabled(true);
			this.buttons[4].setEnabled(true);
			this.buttons[5].setEnabled(true);
			this.changeTitleString("CD");
			this.lastButton = 3;
		}
		else if(e.getSource() == this.buttons[4]) {
			// Up
			if(lastButton == 1) {
				if(this.amhz == 594) this.amhz = 954;
				else if(this.amhz == 954) this.amhz = 1134;
				else this.amhz = 1242;
				this.changeTextString(this.amhz + " kHz");
			}
			else if(lastButton == 2) {
				if(this.fmmhz == 76.1) this.fmmhz = 80.0;
				else if(this.fmmhz == 80.0) this.fmmhz = 81.3;
				else this.fmmhz = 82.5;
				this.changeTextString(this.fmmhz + " MHz");
			}
		}
		else if(e.getSource() == this.buttons[5]) {
			// Down
			
		}
	}

	public static void main(String[] args) {
		// Create a ExGUISwing_02 object.
		ExGUISwing_03 egs03 = new ExGUISwing_03("Application of ExGUISwing-03::[Application of ExGUISwing-02]");
		// Call ExGUISwing_02's setVisible() with parameter "true".
		egs03.setVisible(true);
	}

}
