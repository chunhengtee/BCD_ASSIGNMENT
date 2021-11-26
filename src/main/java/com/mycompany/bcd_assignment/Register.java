package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class Register extends JFrame{
    private JTextField name;
    private JTextField ps;
    private JTextField phone;
    private JTextField email;
    private JTextField address;
    private JButton confirmButton;
    private JButton backToLoginButton;
    private JPanel panel1;
    private JFrame frame;

    public Register(){
        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450,400));
        frame.setResizable(false);

        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
