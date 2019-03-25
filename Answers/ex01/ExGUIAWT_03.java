import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ExGUIAWT_03 extends ExGUIAWT_02 implements MouseListener, MouseMotionListener {

	// An attribute to save mouse x position (It's initialized by -1 to detect the first position.)
	private int mouseX = -1;
	
	public void init() {
		// Call the same method of its super class
		super.init();
		// Add listeners (this) to the ExGUIAWT_03 object itself (use addMouseListener() and addMouseMotionListener()). That is, we use two listeners to catch events on one object.
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// Get mouse x position
		int temp = e.getX();
		// Change the number
		this.editValue(temp - mouseX);
		
		// Update current mouseX position for next session
		mouseX = temp;
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Get mouse x position(call getX() of the argument), save it to the attribute.
		mouseX = e.getX();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}
