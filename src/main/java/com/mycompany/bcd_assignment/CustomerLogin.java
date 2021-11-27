package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerLogin extends JFrame implements ActionListener{
    private JLabel userNameLabel;
    private JLabel stillDonTHaveLabel;

    private JTextField userText;
    private JPasswordField password;

    private JButton loginButton;
    private JButton registerButton;
    private JRadioButton customerRadioButton;
    private JRadioButton adminRadioButton;

    private JPanel panel1;
    private JFrame frame;

    public CustomerLogin(){
        frame = new JFrame("Customer Login");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(350,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        loginButton.addActionListener(e -> {

            EventQueue.invokeLater(() -> {
                if (userText.getText().equals("") || password.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "user name or password cannot be empty", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    redirectToPage();
                }
            });

        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register = new Register();
                register.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
    public void redirectToPage() {
        String user;
        String pwd;
        user= userText.getText();
        pwd= password.getText();
        if (customerRadioButton.isSelected()) {

        }
        if (adminRadioButton.isSelected()) {

            if (user.equalsIgnoreCase( "admin") && pwd.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                //this.setVisible(false);
                new AdminHomePage();



            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // File file = new File (data.csv);

    }
}
