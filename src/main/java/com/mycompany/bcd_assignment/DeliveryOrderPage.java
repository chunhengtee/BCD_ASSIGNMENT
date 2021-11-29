package com.mycompany.bcd_assignment;

import bcd.*;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

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
    private JTextField textField1;
    private JFrame frame;

    //static LinkedList<Block> allblock=new LinkedList<Block>();
    static Blockchain bc= new Blockchain();
    SymmCrypto crypto=new SymmCrypto();

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


        final LinkedList<Block> DB = new LinkedList<Block>();

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
                String name1 = textField1.getText();
                String phoneNum = phoneNumber.getText();
                String Address = address.getText();
                String Item = item.getText();
                String sc  = comboBox1.getSelectedItem().toString();
                String paymentMethod = comboBox2.getSelectedItem().toString();

                CustomerPage customerPage = new CustomerPage();
                customerPage.setVisible(true);
                frame.setVisible(false);




                String[] test = new String[] { name1,phoneNum,Address, sc, Item, paymentMethod } ;

                String order = name1+"|"+phoneNum+"|"+Address+"|"+sc+"|"+Item+"|"+paymentMethod+"|"+"Pending";
                MerkleTree mt = MerkleTree.getInstance(Arrays.asList(test));
                mt.build();

                Transaction transaction1 = new Transaction();
                transaction1.add(order);


                final  LinkedList<Block> DB 	= 	Blockchain.get();
                String chain = new GsonBuilder().setPrettyPrinting().create().toJson( DB );
                System.out.println( chain );

                //Block.Header lastBlockHeader= Blockchain.get().getLast().getHeader();
                Block blk = new Block(DB.size(), Blockchain.get().getLast().getHeader().getCurrentHash(), Item, name1, transaction1, mt.getRoot());

                blk.setTranx( transaction1 );


                blk.getHeader().setPreviousHash(DB.getLast().getHeader().getCurrentHash());

                DB.add(blk);
                //Blockchain.nextBlock( blk );
                //System.out.println( blk );

                String hashName = Hasher.hash(name1,"SHA-256");
                //MySignature digitalSign = new MySignature(hashName);
                //tranx1.setDigital_signature(digitalSign.sign(item.toString()))
                //Transaction tranx = new Transaction();
                //tran.add(tranx1);




                Blockchain.persist(DB);
                Blockchain.distribute(DB);
                //System.out.println(name1);


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
