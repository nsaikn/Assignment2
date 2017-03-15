import javax.swing.*;
import java.awt.*;

public class GuiExampleMain {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(new Dimension(500, 400));
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("First GUI");
		frame.setResizable(false);
		frame.setVisible(true);
	}
}
