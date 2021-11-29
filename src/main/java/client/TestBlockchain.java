/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import bcd.Block;
import bcd.Blockchain;
import bcd.Transaction;

public class TestBlockchain {

	public static void main(String[] args) {
		
		configure();
		
		tstBlockchain( new String[] { "ali", "peter", "mick", "johnny" }  );

	}

	static void tstBlockchain( String[] lst ) {
		
		Transaction t1 = new Transaction();
		t1.add( lst[0] );
		t1.add( lst[1] );
		t1.add( lst[2] );
		t1.add( lst[3] );
		Block blk = new Block( 
				Blockchain.get().getLast().getHeader().getCurrentHash() 
				);
		blk.setTranx(t1);
		Blockchain.nextBlock( blk );
		
		//Blockchain.distribute();
	}
	
	/**
	 * configure the system with a genesis block
	 */
	static void configure() {
		Block genesis = new Block( "0" );
		Blockchain.nextBlock(genesis);
	}
	
}