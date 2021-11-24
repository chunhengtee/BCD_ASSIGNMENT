/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import bcd.Block;
import bcd.Transaction;

public class TestBlock {

	public static void main(String[] args) {

		//very-first block
		Block genesis = new Block( "0" );
		//view the genesis block hash
		System.out.println( genesis );
		
		followingBlocks( genesis );
		
	}

	static void followingBlocks( Block genesis ) {
		
		//appended block
		String tranx1 = "alice|bob|credit|10.0";
		Transaction transaction1 = new Transaction();	
		transaction1.add( tranx1 );
		Block b1 = new Block( genesis.getHeader().getCurrentHash() );
		b1.setTranx( transaction1 );
		//view the block hash of b1
		System.out.println( b1 );
		
		//appended block
		String tranx2 = "alice|bob|credit|10.0";
		String tranx3 = "alice|bob|debit|5.0";
		String tranx4 = "alice|bob|debit|1.0";
		Transaction transaction2 = new Transaction();	
		transaction2.add( tranx2 );
		transaction2.add( tranx3 );
		transaction2.add( tranx4 );
		Block b2 = new Block( b1.getHeader().getCurrentHash() );
		b2.setTranx( transaction2 );
		//view the block hash of b2
		System.out.println( b2 );
		
	}
	
}