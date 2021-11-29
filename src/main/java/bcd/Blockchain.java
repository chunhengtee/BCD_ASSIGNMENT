/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;

import com.google.gson.GsonBuilder;

public class Blockchain {

	//master-binary-filename
	private static final String CHAIN_FILE 		= 	"master/chain.bin";

	//data-structure
	private static LinkedList<Block> DB 	= 	new LinkedList<>();
	
	//ledger-filename
	private static final String LEDGER_FILE		=	"ledger.txt";
	
	//nextBlock() : append the block to the chain
	public static void nextBlock( Block newBlock ) {
		DB.add(newBlock);
		persist(DB);
	}
	
	//persist() : write the chain to the master-file
	public static void persist(LinkedList<Block> db) {
		/**
		 * Helper classes for persisting the object (LinkedList) to the binary-file
		 * 	1) FileOutputStream; 2) ObjectOutputStream
		 */
		try(
			FileOutputStream fos = new FileOutputStream( CHAIN_FILE );
			ObjectOutputStream out = new ObjectOutputStream( fos );
			) {
			out.writeObject( db );
			System.out.println( ">>> Master file updated!" );
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	//get() : retrieve the chain from the master-file
	public static LinkedList<Block> get()
	{
		/**
		 * Helper classes for reading the object (LinkedList) from the binary-file
		 * 	1) FileInputStream; 2) ObjectInputStream
		 */
		try(
				FileInputStream fis = new FileInputStream( CHAIN_FILE );
				ObjectInputStream in = new ObjectInputStream( fis );
		) {
			return (LinkedList<Block>) in.readObject();
		} catch (IOException | ClassNotFoundException e  ) {
			e.printStackTrace();
			return null;
		}
	}
	
	//distribute() : printout the ledger records (demo)
	public static void distribute(LinkedList<Block> db) {
		/**
		 * convert the chain to the text form using Gson API
		 */
		String chain = new GsonBuilder().setPrettyPrinting().create().toJson( db );
		System.out.println( chain );
		try {
			Files.write(
					Paths.get( LEDGER_FILE ), 
					chain.getBytes(),
					StandardOpenOption.CREATE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}