package org.example;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Pop_up {
    public JFrame frame = new JFrame();
    public JOptionPane optionPane = new JOptionPane();


    public void askUser() {
        String [] options = {"Add user", "Existing User"};
        var choices = JOptionPane.showOptionDialog(frame, "What would you like to do?", "Select",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
        frame.dispose();

        if (choices == 0) {
            Registration registration = new Registration();
            registration.show();

        }
        else {
            Existing_User existingUser = new Existing_User();
            existingUser.show();

        }
    }
}
