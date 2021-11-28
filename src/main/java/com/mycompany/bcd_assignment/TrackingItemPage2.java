package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TrackingItemPage2 extends JFrame{
    private JTextPane OrderID;
    private JTextPane DeliverFrom;
    private JTextPane DeliveryItem;
    private JTextPane PaymentMethod;
    private JTextPane Status;
    private JTextPane ActualEndDate;
    private JTextPane StartDate;
    private JTextPane ExpectedEndDate;
    private JButton OKButton;
    private JPanel panel1;
    private JFrame frame;

    public TrackingItemPage2(){
        frame = new JFrame("Tracking Item Page");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(500,600));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerPage customerPage = new CustomerPage();
                customerPage.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
}
