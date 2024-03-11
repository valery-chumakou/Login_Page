/*
 * Created by JFormDesigner on Mon Mar 11 09:34:28 EDT 2024
 */

package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.*;

/**
 * @author Valery Chumakou
 */
public class Registration extends JFrame {
    public Registration() {
        initComponents();
        addUser();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Valery Chumakou
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label1 ----
            label1.setText("Username");
            panel1.add(label1);
            label1.setBounds(new Rectangle(new Point(45, 40), label1.getPreferredSize()));

            //---- label2 ----
            label2.setText("Password");
            panel1.add(label2);
            label2.setBounds(45, 75, 61, 17);
            panel1.add(textField1);
            textField1.setBounds(140, 35, 114, textField1.getPreferredSize().height);
            panel1.add(passwordField1);
            passwordField1.setBounds(140, 75, 115, passwordField1.getPreferredSize().height);

            //---- button1 ----
            button1.setText("Submit");
            panel1.add(button1);
            button1.setBounds(new Rectangle(new Point(130, 130), button1.getPreferredSize()));

            {
                // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(10, 5, 375, 255);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Valery Chumakou
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on

    public void addUser() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "BostonVenyaGlobe9357");
                    String sql = "INSERT INTO users (name, password) VALUES(?,?)";
                    PreparedStatement ps = con.prepareStatement(sql);
                    String user_name = textField1.getText();
                    String password_field = new String(passwordField1.getPassword());
                    ps.setString(1, user_name);
                    ps.setString(2, password_field);
                    ps.executeUpdate();
                    int result = ps.executeUpdate();

                    if (result == 1) {
                        JOptionPane.showMessageDialog(null, "Successfully added");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to add user");
                    }
                    con.close();
                } catch (Exception exception) {
                    exception.printStackTrace();

                }

            }

        });
        

    }

}
