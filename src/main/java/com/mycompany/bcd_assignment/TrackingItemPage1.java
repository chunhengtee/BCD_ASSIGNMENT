package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class TrackingItemPage1 extends JFrame{
    private JTextField textField1;
    private JButton confirmButton;
    private JPanel panel1;
    private JFrame frame;

    public TrackingItemPage1(){
        frame = new JFrame("Tracking Item Page");
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
