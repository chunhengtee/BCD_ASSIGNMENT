package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class OrderDetails extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JButton button1;
    private JPanel panel1;

    private JFrame frame;

    public OrderDetails(){
        frame = new JFrame("OrderList");
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
