import javax.swing.*;
import java.awt.*;

public class GuiExampleMain {
	public static void main(String[] args) {
		// creates an instance of JFrame which is the main container box 
		JFrame frame = new JFrame();
		//sets the dimensions of the JFrame, width then height
		frame.setSize(new Dimension(500, 400));
		//creates a new Jpanel which is what fills up a frame
		
		JPanel panel = new JPanel();
		//this sets the background color of the panel
		panel.setBackground(Color.BLACK);
		//this loads the JPanel onto the JFrame
		// added onto the center of the JFrame and expands to fit by default
		frame.getContentPane().add(panel);
		
		//button is created then added by panel
		JButton button = new JButton("Button 1");
		panel.add(button);
		
		//empty input textbox is generated and dimensions are set
		JTextField textField = new JTextField();
		//this preferred size locks the field to be of that size
		textField.setPreferredSize(new Dimension(200, 20));
		panel.add(textField);
		
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
