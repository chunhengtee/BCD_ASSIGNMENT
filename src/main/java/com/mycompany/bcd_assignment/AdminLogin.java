package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class AdminLogin extends JFrame{
    private JFrame frame;
    private JTextField textField1;
    private JTextField textField2;
    private JButton confirmButton;
    private JPanel panel1;

    public AdminLogin(){
        frame = new JFrame("Admin Login");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
