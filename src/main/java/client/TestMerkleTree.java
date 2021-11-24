/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import java.util.Arrays;

import bcd.MerkleTree;

public class TestMerkleTree {

	public static void main(String[] args) {
		
		String[] arr = new String[] { "ahmad", "peter", "mick", "john" } ;
		MerkleTree mt = MerkleTree.getInstance( Arrays.asList( arr ) );
		mt.build();
		
		String rootHash = mt.getRoot();
		
		System.out.println( "Root: "+ rootHash );

	}
	
	/**
	 * Date: 8/10/2021
	 * LAB EXERCISE: To implement merkle root to the Block.java
	 * 				Meantime, take care the count of the block (value of the index variable)
	 * 
	 */

}
