/**
 * Created by Sai on 14/03/2017.
 */

//swing is a library of Java GUI components Standard WINdownG toolkit
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener{
    //all GUI panels in Java need a unique identifier for the windowing system
    private static final long serialVersionUID=123456789;
    //a text entry box to store the user's input sequence
    JTextArea inputSequence;
    //a text entry box to store the user's search string
    JTextArea searchBox;
    //a button that that user can click to search the input sequence for the string entered in the search box
    Button searchButton;
    //this label will display a result for the user - we declare it here, because we need to change its value later
    Label searchResult;
    /**
     *     let's create a constructor that sets up our GUI when the application is launched
     */
    public GUI(){
        //create a layout within our MyFirstGUI JPanel
        //note: the layout itself is going to be contained within another JPanel
        //JPanel controlsArea = new JPanel(new GridLayout(2,2));
        JPanel controlsArea = new JPanel(new GridLayout(3,2, 5, 5));

        //try to set the preferred size of the window
        setPreferredSize(new Dimension(500,400));

        //populate the layout with controls

        //Label is a non-interactive text display control
        //https://docs.oracle.com/javase/7/docs/api/java/awt/Label.html
        controlsArea.add(new Label("Enter sequence data:"));

        //IMPORTANT!: make sure to add the controlsArea layout to this JPanel
        //or else it won't display
        this.add(controlsArea, BorderLayout.SOUTH); //BorderLayout.SOUTH is a constant indicating where to place the control

        //just for fun, let's add some controls to let the user enter a sequence and search it for some text
        inputSequence = new JTextArea();
        //add the inputSequence textbox to the layout
        controlsArea.add(inputSequence);

        //notice the pattern; instantiate a new conrol and add it to the layout
        //add another label to indicate to the user that they can search
        controlsArea.add(new Label("search for: "));

        //create a JTextArea to let the user input a string to search for
        searchBox = new JTextArea();
        controlsArea.add(searchBox);

        //add a button to let the user click to perform the search
        searchButton = new Button("Search!");
        controlsArea.add(searchButton);
        //Button expects a ActionListener object to receive its click events
        //simplest thing is to make MyFirstGUI an ActionListener
        //associate the searchButton's ActionEvent with our actionPerformed method below
        searchButton.setActionCommand("search_button_was_pressed");
        //tell the searchButton that MyFirstGUI is its ActionListener
        searchButton.addActionListener(this);

        //instantiate & add the search result to the layout
        searchResult = new Label("<== click the button to search!");
        controlsArea.add(searchResult);

    }

}
