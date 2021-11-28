package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class DeliveryOrderPage extends JFrame {
    private JTextField item;
    private JTextField address;
    private JTextField phoneNumber;
    private JTextField name;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton confirmOrderButton;
    private JPanel panel1;
    private JButton backButton;
    private JFrame frame;

    public DeliveryOrderPage(){
        frame = new JFrame("DeliveryOrderPage");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        confirmOrderButton.addActionListener(new ActionListener() {  //confirm order button
            @Override
            public void actionPerformed(ActionEvent e) {
                //String name = this.name.getText();
                /*
                if (name.equals("") || address.equals("") || phoneNumber.equals("")|| item.equals("")){  // not allow blank input
                    JOptionPane.showMessageDialog(frame,"The input cannot be blank !", "Info", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    try {
                        //\\writeToBlock();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    CustomerLogin customerLogin = new CustomerLogin();
                    customerLogin.setVisible(true);
                    frame.setVisible(false);
                }

                 */



            }
        });
        backButton.addActionListener(new ActionListener() {  // back to customer page button
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerPage customerPage = new CustomerPage();
                customerPage.setVisible(true);
                frame.setVisible(false);

            }
        });
        /*public void writeToBlock() throw IOException{
            String name = this.name.getText();
            String phoneNum = this.phoneNumber.getText();
            String address = this.address.getText();
            String item = this.item.getText();
            String sc  = this.comboBox1.getSelectedItem().toString();
            String paymentMethod = this.comboBox2.getSelectedItem().toString();





        }*/
    }
}
