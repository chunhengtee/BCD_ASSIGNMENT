package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class CustomerLogin extends JFrame{
    private JLabel userNameLabel;
    private JTextField userText;
    private JPanel panel1;
    private JPasswordField password;
    private JButton loginButton;
    private JLabel stillDonTHaveLabel;
    private JButton registerButton;
    private JRadioButton customerRadioButton;
    private JRadioButton adminRadioButton;
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

    }
}
