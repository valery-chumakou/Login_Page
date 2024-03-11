package org.example;
import javax.swing.*;

public class Pop_up {
    public JFrame frame = new JFrame();
    public JOptionPane optionPane = new JOptionPane();


    public void askUser() {
        String [] options = {"Add user", "Existing User"};
        var choices = JOptionPane.showOptionDialog(frame, "What would you like to do?", "Select",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        frame.dispose();
    }
}
