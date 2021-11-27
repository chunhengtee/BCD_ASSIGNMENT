package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class CustomerPage extends JFrame{
    private JPanel panel1;
    private JButton checkDeliveryStatusButton;
    private JButton deliveryItemButton;
    private JButton logOutButton;
    private JFrame frame;

    public CustomerPage()throws HeadlessException{

        //configuration of page
        frame = new JFrame("Customer Page");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(false);

    }
}
