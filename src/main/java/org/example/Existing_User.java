/*
 * Created by JFormDesigner on Wed Mar 13 23:36:21 EDT 2024
 */

package org.example;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

/**
 * @author Valery Chumakou
 */
public class Existing_User extends JFrame {
    public Existing_User() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        // Generated using JFormDesigner Educational license - Valery Chumakou
        panel1 = new JPanel();
        label2 = new JLabel();
        label3 = new JLabel();
        textField1 = new JTextField();
        passwordField1 = new JPasswordField();
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== panel1 ========
        {
            panel1.setLayout(null);

            //---- label2 ----
            label2.setText("Username");
            label2.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            panel1.add(label2);
            label2.setBounds(new Rectangle(new Point(45, 40), label2.getPreferredSize()));

            //---- label3 ----
            label3.setText("Password");
            label3.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
            panel1.add(label3);
            label3.setBounds(45, 75, 61, 17);
            panel1.add(textField1);
            textField1.setBounds(140, 35, 114, textField1.getPreferredSize().height);
            panel1.add(passwordField1);
            passwordField1.setBounds(140, 75, 115, passwordField1.getPreferredSize().height);

            //---- button1 ----
            button1.setText("Log In");
            button1.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
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

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField1.getText();
                String password = new String(passwordField1.getPassword());
                Existing_User user = logIn(name, password);

            }
        });
    }

        public Existing_User logIn(String name, String password) {
            Existing_User user = null;
            try {
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql",
                        "root", "BostonVenyaGlobe9357");
                String sql = "SELECT * FROM users WHERE name=? AND password=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, password);
                ResultSet resultSet = ps.executeQuery();
                if (resultSet.next()) {
                    textField1 = new JTextField();
                    name = resultSet.getString("name");
                    password = resultSet.getString("password");
                    JOptionPane.showMessageDialog(null, "User exist");
                } else {
                    JOptionPane.showMessageDialog(null,"Doesn't Exist");
                }
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
            return user;

        }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    // Generated using JFormDesigner Educational license - Valery Chumakou
    private JPanel panel1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on




}
