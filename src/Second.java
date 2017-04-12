import jdk.nashorn.internal.ir.Assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Sai on 25/03/2017.
 */
public class Second extends JFrame{

    private JButton buttonCounter, buttonReset;
    private JLabel labelCount;
    public int clicks = 0;

    public Second(){
        createView();
        // dont need to specify a JFrame object as these methods are available directly from the extension.
        setTitle("Click Me");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // instead of setting the size of the frame, it makes it just big enough to fit everything
        // changing the order of the code to make pack before setLocation changes where on the screen it appears
        setLocationRelativeTo(null);
        setResizable(false);


    }

    public void createView(){
        // initialize the code
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        // note that the name of the JFrame is not mentioned, because it is extended ???
        labelCount = new JLabel("Clicked " + clicks + " times.");
        labelCount.setPreferredSize( new Dimension(400, 30));
        panel.add(labelCount);

        buttonCounter = new JButton("Click Me");
        buttonCounter.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        clicks ++;
                        updateCounter();
                    }
                }
        );
        panel.add(buttonCounter);

        buttonReset = new JButton("Reset");
        buttonReset.addActionListener(
                new ResetActionListener()
        );
        panel.add(buttonReset);

    }

    private void updateCounter(){
        labelCount.setText("Clicked " + clicks + " times.");
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Second().setVisible(true);
            } // not sure how this line works expeically the setVisible part, how can u do it when your making a new object
        });

    }

    private class ResetActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clicks = 0;
            updateCounter();
        }
    }
}
