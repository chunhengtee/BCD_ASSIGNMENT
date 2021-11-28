package com.mycompany.bcd_assignment;

import bcd.Hasher;
import keycreator.KeyAccess;
import model.Customer;
import keycreator.KeyPairMaker;
import keycreator.KeyAccess;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Base64;

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


        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


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

                    try {
                        writeToFile();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    CustomerLogin customerLogin = new CustomerLogin();
                    customerLogin.setVisible(true);
                    frame.setVisible(false);
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
    public void writeToFile() throws IOException{
        String name = this.name.getText();
        String password = this.password.getText();
        String hashPass = Hasher.hash(password, "SHA-256");
        String hashName = Hasher.hash(name, "SHA-256");

        String phone = this.phone.getText();
        String email = this.email.getText();
        String address = this.address.getText();

        BufferedWriter writer = new BufferedWriter(new FileWriter("Register.txt",true));

        writer.write(name + "|"+ hashPass + "|" + phone + "|"+ email+ "|" + address + "\n");
        writer.close();

        KeyPairMaker.create(hashName);
        try {
            System.out.println(Base64.getEncoder().encodeToString( KeyAccess.getPublicKey(hashName).getEncoded() ));
            System.out.println(Base64.getEncoder().encodeToString( KeyAccess.getPrivateKey(hashName).getEncoded() ));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
