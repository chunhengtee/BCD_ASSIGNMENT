package com.mycompany.bcd_assignment;

import bcd.Block;
import bcd.Blockchain;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

public class OrderList extends JFrame{
    private JButton confirmOrderButton;
    private JButton backButton;
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton previousButton;
    private JButton nextButton;
    private JFrame frame;
    private static LinkedList<Block> db= Blockchain.get();
    Block currentblock;
    static int current=1;

    public OrderList(){
        frame = new JFrame("OrderList");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(300,400));
        frame.setResizable(false);

        // panel
        frame.add(panel1);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        final  LinkedList<Block> DB 	= 	Blockchain.get();
        currentblock=db.get(current);
        System.out.println();
        textArea1.setText(currentblock.getTranx().toString());


        confirmOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AdminHomePage adminHomePage = new AdminHomePage();
                adminHomePage.setVisible(true);
                frame.setVisible(false);


            }
        });
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                current--;
                if(current==0)
                {
                    JOptionPane.showMessageDialog(previousButton,"No more Record!!!");
                    current++;
                }
                else
                {
                    textArea1.setText(currentblock.getTranx().toString());

                }

            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(current+1==db.size())
                {
                    JOptionPane.showMessageDialog(nextButton,"No more Record!!!");
                }
                else {
                    currentblock = db.get(current + 1);
                    textArea1.setText(currentblock.getTranx().toString());
                    current++;
                }

            }
        });
    }
    public void odrderTable(){}

}
