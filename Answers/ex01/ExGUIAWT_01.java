import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/*
 	<applet code = "ExGUIAWT_01" width = 400 height = 300>
 	</applet>
 */

public class ExGUIAWT_01 extends Applet {
	
	private final int windowWidth = 400;
	private final int windowHeight = 300;
	private int radius = 100;
	private String words = "April 13, 2018";
	private int xCenter = 100, yCenter = 50;

	/* Initialize */
	public void init() {
		this.setSize(new Dimension(this.windowWidth, this.windowHeight));
	}
	
	/* Paint the screen */
	public void paint(Graphics g) {
		g.setColor(Color.red);
		g.drawOval(this.xCenter, this.yCenter, this.radius * 2, this.radius * 2);
		g.setColor(Color.black);
		g.drawString(this.words, this.xCenter / 2 + this.radius, this.yCenter + this.radius);
	}
	
	

}
