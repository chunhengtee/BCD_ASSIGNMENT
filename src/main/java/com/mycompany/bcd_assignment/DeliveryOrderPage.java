package com.mycompany.bcd_assignment;

import bcd.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

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

        String name = this.name.getText();
        String phoneNum = this.phoneNumber.getText();
        String address = this.address.getText();
        String item = this.item.getText();
        String sc  = this.comboBox1.getSelectedItem().toString();
        String paymentMethod = this.comboBox2.getSelectedItem().toString();


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

                Block genesis = new Block( "0" );
                Blockchain.nextBlock(genesis);

                String[] test = new String[] { name, sc, item, paymentMethod } ;

                String order = name+"|"+sc+"|"+item+"|"+paymentMethod;
                Transaction transaction1 = new Transaction();
                transaction1.add(order);
                Block b1 = new Block( genesis.getHeader().getCurrentHash() );
                b1.setTranx( transaction1 );
                System.out.println( b1 );

                String hashName = Hasher.hash(name,"SHA-256");
                //MySignature digitalSign = new MySignature(hashName);
                //tranx1.setDigital_signature(digitalSign.sign(item.toString()))
                //Transaction tranx = new Transaction();
                //tran.add(tranx1);
                MerkleTree mt = MerkleTree.getInstance(Arrays.asList(test));
                mt.build();

                Block.Header lastBlockHeader= Blockchain.get().getLast().getHeader();
                Block blk = new Block(lastBlockHeader.getIndex()+1, lastBlockHeader.getCurrentHash(), "1", name, transaction1, mt.getRoot());

                Blockchain.nextBlock(blk);
                Blockchain.distribute();


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
