package com.mycompany.bcd_assignment;

import model.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Register extends JFrame implements ActionListener {
    // component
    private JTextField name;
    private JTextField password;
    private JTextField phone;
    private JTextField email;
    private JTextField address;
    private JButton confirmButton;
    private JButton backToLoginButton;
    private JPanel panel1;
    private JFrame frame;

    public Register(){
        // layout
        frame = new JFrame("Register");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(450,400));
        frame.setResizable(false);

        //frame.add(name);
        //frame.add(password);

        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        //File file = new File("data.csv");

        backToLoginButton.addActionListener(new ActionListener() {  //back to login page button
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerLogin customerLogin = new CustomerLogin();
                customerLogin.setVisible(true);
                frame.setVisible(false);
            }
        });
        confirmButton.addActionListener(new ActionListener() {  // confirm to register button
            @Override
            public void actionPerformed(ActionEvent e) {

                //compare
                if (name.equals("") || password.equals("") || phone.equals("")|| email.equals("") || address.equals("")){  // not allow blank input
                    JOptionPane.showMessageDialog(frame,"The input cannot be blank !", "Info", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    //Customer customer = new Customer ();
                    try {
                        writeToFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        });
    }
    public String getPassword(){
        return getPassword();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //file
    }
    //void createAccount(ActionEvent)throws IOException{
        //writeToFile();
    //}
    public void writeToFile() throws IOException{
        String name = this.name.getText();
        String password = this.password.getText();
        String phone = this.phone.getText();
        String email = this.email.getText();
        String address = this.address.getText();

        BufferedWriter writer = new BufferedWriter(new FileWriter("Register.txt",true));

        writer.write(name + "||" + "||"+ password + "||" + phone + "||"+ email+address + "\n");
        writer.close();

    }
}
