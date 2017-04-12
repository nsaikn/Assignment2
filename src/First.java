/**
 * Created by Sai on 25/03/2017.
 */

package gui;
import javax.swing.*;
import java.awt.*;
public class First {
    public static void main(String[] args){
         // creates a window object (frame = window)
        JFrame frame = new JFrame();
        //panels can hold other components or even other panels inside of it. but default it is flow layout
        JPanel panel = new JPanel();
        // can set the panel's color with setBackground()
        panel.setBackground(Color.BLACK);
        // getContentPane() is not necessary but is good practice. .add(), .remove() and .setLayout do not need the getContentPane but other methods do. This was done for convenience sake.
        frame.getContentPane().add(panel);

        //JButton is used to create a button and allows us to pass the text on the button as an argument
        JButton button = new JButton("Button 1");
        panel.add(button);

        // to create a textfield, use the JTextField class
        JTextField textField = new JTextField();
        // anytime when setting a size, use new Dimension along with setPreferredSize/setSize and pass the size arguments)
        textField.setPreferredSize(new Dimension(200, 20));
        panel.add(textField);



        // setSize feeds in the beginning size of the window
        frame.setSize(new Dimension(500, 400));
        // .setLocationRelativeTo() is one way to set the beginning location of the window
        frame.setLocationRelativeTo(null);
        // setDefaultCloseOperation() determines the behaviour of the close button on the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // sets the name of the frame
        frame.setTitle("Assignment 2");
        /* setVisible controls the visibility of the object, allow it to come to light or not.
        Usually do this visibility last. */
        frame.setVisible(true);

    }
}
