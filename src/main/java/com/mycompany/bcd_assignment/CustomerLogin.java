package com.mycompany.bcd_assignment;

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
        String user;
        String pwd;
        user = userText.getText();
        pwd = new String(password.getPassword());
        if (customerRadioButton.isSelected()) {   //login for customer
            // read the register.txt
            try {
                File myObj = new File("Register.txt");
                Scanner s = new Scanner(myObj);

                while (s.hasNextLine()) {

                    String[] data = s.nextLine().split("\\|\\|");
                    if (user.equalsIgnoreCase(data[0]) && pwd.equalsIgnoreCase(data[1])) {
                        JOptionPane.showMessageDialog(this, "Login Successful");
                        //CustomerPage customerPage = new CustomerPage();
                        //customerPage.setVisible(true);
                        //new CustomerPage();
                        new AdminHomePage();
                        frame.setVisible(false);

                    } else {
                        JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                    }
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
