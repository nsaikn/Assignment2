import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent; // why do we need this if we did import java.awt.*
import java.awt.event.ActionListener;
import java.util.regex.*;

/**
 * Created by Sai on 26/03/2017.
 */
public class SaiA2 extends JFrame {

    private JPanel panel;
    private JTextArea inRNA, outRNA, outStats;
    private JButton process, reset;
    private JLabel inRNALabel, inLengthLabel, inSpacingLabel, inCaseLabel, outStatsLabel, outRNALabel;
    private ButtonGroup caseGroup;
    private JRadioButton caseUpper;
    private JRadioButton caseLower;
    private JCheckBox spacing;
    private JComboBox lines;


    public SaiA2() {
        CreateView();
        setTitle("Java Assignment");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public void CreateView() {
        panel = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        getContentPane().add(panel);
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.anchor = GridBagConstraints.LINE_START;
        c.insets = new Insets(10, 10, 10, 10);

        inRNA = new JTextArea();
        inRNA.setPreferredSize(new Dimension(200, 50));

        outRNA = new JTextArea();
        outRNA.setPreferredSize(new Dimension(600, 50));

        outStats = new JTextArea();
        outStats.setPreferredSize(new Dimension(100, 50));

        process = new JButton("Process");

        reset = new JButton("Reset");

        inRNALabel = new JLabel("Enter RNA sequence");

        outRNALabel = new JLabel("RNA Sequence:");

        inLengthLabel = new JLabel("How many Characters per line:");

        String[] lengthOptions = {"40", "50", "60", "70"};
        lines = new JComboBox(lengthOptions);
        lines.setSelectedIndex(2);

        inSpacingLabel = new JLabel("Separate by 10 characters:");
        spacing = new JCheckBox("Yes");

        inCaseLabel = new JLabel("Uppercase/Lowercase");

        caseUpper = new JRadioButton("Upper");
        caseLower = new JRadioButton("Lower", true);
        caseGroup = new ButtonGroup();
        caseGroup.add(caseUpper);
        caseGroup.add(caseLower);


        outStatsLabel = new JLabel("Results:");

        c.gridx = 1;
        c.gridy = 1;
        c.gridheight = 1;
        c.gridwidth = 1;

        panel.add(inRNALabel, c);
        c.gridx = 1;
        c.gridy = 2;
        c.gridheight = 1;
        c.gridwidth = 2;
        panel.add(inRNA, c);
        c.gridx = 1;
        c.gridy = 3;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(inLengthLabel, c);
        c.gridx = 2;
        c.gridy = 3;
        panel.add(lines, c);

        c.gridx = 1;
        c.gridy = 4;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(inSpacingLabel, c);
        c.gridx = 2;
        c.gridy = 4;
        panel.add(spacing, c);

        c.gridx = 1;
        c.gridy = 5;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(inCaseLabel, c);
        c.gridx = 2;
        c.gridy = 5;
        panel.add(caseUpper, c);
        c.gridx = 2;
        c.gridy = 6;
        panel.add(caseLower, c);

        c.gridx = 1;
        c.gridy = 8;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(process, c);
        c.gridx = 2;
        c.gridy = 8;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(reset, c);
        c.gridx = 1;
        c.gridy = 9;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(outRNALabel, c);
        c.gridx = 1;
        c.gridy = 10;
        c.gridheight = 1;
        c.gridwidth = 4;
        panel.add(outRNA, c);
        c.gridx = 1;
        c.gridy = 11;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(outStatsLabel, c);
        c.gridx = 2;
        c.gridy = 11;
        c.gridheight = 1;
        c.gridwidth = 1;
        panel.add(outStats, c);

        // Aciton listeners for the process and reset buttons
        process.addActionListener(
                new processActionListener());
        reset.addActionListener(
                new resetActionListener());
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SaiA2().setVisible(true);
            }
        });
    }

    private class processActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int cPerLine;
            StringBuilder sequenceOut = new StringBuilder("");
            String input = inRNA.getText();
            if (input.matches("^[atcgATCG]+$")) {
                System.out.println("Valid sequence");
                if (caseUpper.isSelected()) {
                    input = input.toUpperCase();
                }else {
                    input = input.toLowerCase();
                }

                cPerLine = Integer.parseInt(lines.getSelectedItem().toString());
                for (int i = 0; i < input.length(); i += cPerLine) {
                    if (spacing.isSelected()) {
                        for (int m = i; m - i < cPerLine && m < input.length(); m += 10) {
                            if (input.length() < m + 10) {
                                // print rest of input
                                sequenceOut.append(input.substring(m));

                            } else {
                                // print subsets of 10 out
                                sequenceOut.append(input.substring(m, m + 10));
                                sequenceOut.append(" ");
                            }

                        }
                    } else {
                        //print subsets of cPerLine
                        if (i + cPerLine < input.length()) {
                            sequenceOut.append(input.substring(i, i + cPerLine));
                        } else {
                            sequenceOut.append(input.substring(i));
                        }
                    }
                    sequenceOut.append("\n");
                }
                outRNA.setText(sequenceOut.toString());

                // add the letter counter and display the results here
                int numA, numT, numC, numG;

                for(char c : input.toCharArray()){
                    if(c == 'a' | c == 'A'){
                        numA++;
                    }
                    if(c == 't' | c == 'T'){
                        numT++;
                    }
                    if(c == 'c' | c == 'C'){
                        numC++;
                    }
                    if(c == 'g' | c == 'G'){
                        numG++;
                    }
                    sequenceOut.setLength(0);
                    sequenceOut.append("A: " + numA + "\nT: " + numT + "\nC: " + numC + "\nG: " + numG );
                    outStats.setText(sequenceOut.toString());
                }
            } else {
                System.out.println("Invalid sequence");
                JOptionPane.showMessageDialog(null, "Invalid Sequence, make sure it only contains A,T, C and G.");
            }

        }
    }

    private class resetActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // make a popup with logic
            inRNA.setText("");
            outRNA.setText("");
            outStats.setText("");
            caseUpper.setSelected(false);
            caseLower.setSelected(true);
            spacing.setSelected(false);
            lines.setSelectedIndex(2);
        }
    }
}
