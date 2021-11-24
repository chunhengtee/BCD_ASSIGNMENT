/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;

import java.util.ArrayList;
import java.util.List;

/***
 * 
 * @author kimlee
 *
 * @implNote
 * To generate merkle root based on the given transaction-list.
 *
 */

public class MerkleTree {
	
	private List<String> tranxLst;
	private String root = "0";

	public String getRoot() {
		return root;
	}
	
	/**
	 * @implNote
	 * Set the transaction list to the MerkleTree object.
	 * 
	 * @param tranxLst
	 */
	private MerkleTree(List<String> tranxLst) {
		super();
		this.tranxLst = tranxLst;
	}
	/**
	 * Design pattern: Singleton
	 */
	private static MerkleTree instance;
	public static MerkleTree getInstance( List<String> tranxLst ) {
		if( instance == null ) {
			return new MerkleTree(tranxLst);
		}
		return instance;
	}

	/**
	 * @implNote
	 * Build merkle tree 
	 * 
	 * @implSpec 
	 * + build() : void
	 */
	public void build() {
		
		List<String> tempLst = new ArrayList<>();
		
		for (String tranx : this.tranxLst) {
			tempLst.add(tranx);
		}
		
		List<String> hashes = genTranxHashLst( tempLst );
		while(  hashes.size() != 1 ) {
			hashes = genTranxHashLst( hashes );
		}
		this.root = hashes.get(0);
	}
	
	/**
	 * @implNote
	 * Generate hashes of transactions 
	 * 
	 * @implSpec 
	 * - genTranxHashLst(List<String>) : List<String>
	 */
	private List<String> genTranxHashLst(List<String> tranxLst) {
		List<String> hashLst = new ArrayList<>();
		int i = 0;
		while( i < tranxLst.size() ) {
			
			String left = tranxLst.get(i);
			i++;
			
			String right = "";
			if( i != tranxLst.size() ) right = tranxLst.get(i);
			
			String hash = Hasher.hash(left.concat(right) , "SHA-256");
			hashLst.add(hash);
			i++;
		}
		return hashLst;
	}
	
	

}