package com.mycompany.bcd_assignment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Register extends JFrame implements ActionListener {
    // component
    private JTextField name;
    private JTextField ps;
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



        //File file = new File("data.csv");
        //HashMap<String, String> loginInfo = new HashMap<>();

        //Encryptor encryptor = new Encryptor();

        // void loginHandler

        // private string getpassword

        // void createaccount

        // private void updateLoginUsernamesAnd Passwords

        // private void writeToFile()


        backToLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerLogin customerLogin = new CustomerLogin();
                customerLogin.setVisible(true);
                frame.setVisible(false);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //file
    }
}
