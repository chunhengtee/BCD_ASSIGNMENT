package com.mycompany.bcd_assignment;

import bcd.Block;
import bcd.Blockchain;
import bcd.Hasher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class CustomerLogin extends JFrame implements ActionListener{
    private JLabel userNameLabel;
    private JLabel stillDonTHaveLabel;

    private JTextField userText;
    private JPasswordField password;

    private JButton loginButton;
    private JButton registerButton;
    private JRadioButton customerRadioButton;
    private JRadioButton adminRadioButton;

    private JPanel panel1;
    private JButton startButton;
    private JFrame frame;

    public CustomerLogin(){
        frame = new JFrame("Customer Login");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(350,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        loginButton.addActionListener(e -> {

            EventQueue.invokeLater(() -> {
                if (userText.getText().equals("") || password.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(this, "user name or password cannot be empty", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                } else {
                    try {
                        redirectToPage();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }
                }
            });

        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Block genesis = new Block( "0" );
                Blockchain.nextBlock(genesis);


            }
        });


        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Register register = new Register();
                register.setVisible(true);
                frame.setVisible(false);
            }
        });
    }
    public void redirectToPage() throws FileNotFoundException {
        String user = userText.getText();
        String pwd = new String(password.getPassword());
        String hashPwd = Hasher.hash(pwd,"SHA-256");
        if (customerRadioButton.isSelected()) {   //login for customer
            // read the register.txt
            try {
                File myObj = new File("Register.txt");
                Scanner s = new Scanner(myObj);

                boolean isFound = false;
                while (s.hasNextLine()) {

                    String[] data = s.nextLine().split("\\|");
                    if (user.equalsIgnoreCase(data[0]) && hashPwd.equalsIgnoreCase(data[1])) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        CustomerPage customerPage = new CustomerPage();
                        customerPage.setVisible(true);


                        frame.setVisible(false);
                        isFound=true;
                        break;

                    }
                }
                if(!isFound){
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }

                s.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();

            }


        }
        if (adminRadioButton.isSelected()) {   //login for admin

            if (user.equalsIgnoreCase("admin") && pwd.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                frame.setVisible(false);
                new AdminHomePage();

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        // else
        // user didn't choose radio button
        // please choose user type!

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }



}
