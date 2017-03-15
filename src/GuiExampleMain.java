import javax.swing.*;
import java.awt.*;

public class GuiExampleMain {
	public static void main(String[] args) {
		// creates an instance of JFrame which is the main container box 
		JFrame frame = new JFrame();
		//sets the dimensions of the JFrame, height then width
		frame.setSize(new Dimension(500, 400));
		// This centers the file in the middle, the default is top left corner
		frame.setLocationRelativeTo(null);
		// Explains what to do when the X button is pressed, there is another option to close the window but still be active in the process
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sets the tile of the window 
		frame.setTitle("First GUI");
		//makes sure the GUI is not expandable or shrinkable 
		frame.setResizable(false);
		// Makes JFrame visible
		frame.setVisible(true);
	}
}
