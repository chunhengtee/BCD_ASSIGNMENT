package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackingItemPage1 extends JFrame{
    private JTextField textField1;
    private JButton confirmButton;
    private JPanel panel1;
    private JButton backButton;
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

        confirmButton.addActionListener(new ActionListener() { // input the orderID
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {  // back button
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerPage customerPage = new CustomerPage();
                customerPage.setVisible(true);
                frame.setVisible(false);
            }
        });
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TrackingItemPage2 trackingItemPage2 = new TrackingItemPage2();
                trackingItemPage2.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
