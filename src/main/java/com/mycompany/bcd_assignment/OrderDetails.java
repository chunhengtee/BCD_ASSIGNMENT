package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class OrderDetails extends JFrame {
    private JButton verifyButton;
    private JPanel panel1;
    private JButton button1;
    private JTextPane textPane1;

    private JFrame frame;

    public OrderDetails(){
        frame = new JFrame("OrderDetails");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
