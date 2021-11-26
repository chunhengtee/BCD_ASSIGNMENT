package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;

public class DeliveryOrderPage extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton confirmOrderButton;
    private JPanel panel1;
    private JFrame frame;

    public DeliveryOrderPage(){
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
