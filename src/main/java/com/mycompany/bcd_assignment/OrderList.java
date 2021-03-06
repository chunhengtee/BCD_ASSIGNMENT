package com.mycompany.bcd_assignment;

import bcd.*;
import com.google.gson.GsonBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
    final LinkedList<Block> DB = new LinkedList<Block>();

    public OrderList(){
        frame = new JFrame("OrderList");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(600,400));
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
                String admin = "Admin";
                String line = currentblock.getTranx().toString();
                String line1 = line.substring(line.lastIndexOf("[") + 1);

                String [] arr = line1.split("\\|");
                String name = arr[0];
                String paymentMethod = arr[3];
                String Item = arr[4];
                String sc = arr[5];

                String[] test = new String[] { admin,name,sc, Item, paymentMethod } ;

                String order = admin+"|"+name+"|"+sc+"|"+Item+"|"+paymentMethod+"|"+"Confirmed";
                MerkleTree mt = MerkleTree.getInstance(Arrays.asList(test));
                mt.build();

                Transaction transaction1 = new Transaction();
                transaction1.add(order);


                final  LinkedList<Block> DB 	= 	Blockchain.get();
                String chain = new GsonBuilder().setPrettyPrinting().create().toJson( DB );
                System.out.println( chain );

                //Block.Header lastBlockHeader= Blockchain.get().getLast().getHeader();
                Block blk = new Block(DB.size(), Blockchain.get().getLast().getHeader().getCurrentHash(), Item, admin, transaction1, mt.getRoot());

                blk.setTranx( transaction1 );


                blk.getHeader().setPreviousHash(DB.getLast().getHeader().getCurrentHash());

                DB.add(blk);
                //Blockchain.nextBlock( blk );
                //System.out.println( blk );

                Blockchain.persist(DB);
                Blockchain.distribute(DB);




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
                    currentblock = db.get(current );
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

}
