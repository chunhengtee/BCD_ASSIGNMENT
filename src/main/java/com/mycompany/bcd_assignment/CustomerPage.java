package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPage extends JFrame{
    private JPanel panel1;
    private JButton checkDeliveryStatusButton;
    private JButton deliveryItemButton;
    private JButton logOutButton;
    private JFrame frame;

    public CustomerPage(){

        //configuration of page
        frame = new JFrame("Customer Page");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        logOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerLogin customerLogin = new CustomerLogin();
                customerLogin.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
