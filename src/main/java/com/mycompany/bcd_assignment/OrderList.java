package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class OrderList extends JFrame{
    private JTable table1;
    private JButton confirmOrderButton;
    private JButton backButton;
    private JPanel panel1;
    private JFrame frame;

    public OrderList(){
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
