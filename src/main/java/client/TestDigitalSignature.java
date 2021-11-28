/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;


import bcd.BasicDS;
import bcd.MySignature;

public class TestDigitalSignature {


	public static void main(String[] args) {
		String data = "demo digital signature!";
		tst2( data );
	}

	static void tst2( String data ) {
		
		//MySignature bds = new MySignature();
		System.out.println( "Data: "+ data );
		
		//String signature = bds.sign(data);
		//System.out.println( "Signature: "+ signature );
		
		System.out.println();
		
		//boolean isValid = bds.verify(data, signature);
		//System.out.println( ( isValid ) ? "Correct data!" : "Incorrect data!" );
		
	}
	
	static void tst1( String data ) {
		
		BasicDS bds = new BasicDS();
		System.out.println( "Data: "+ data );
		
		String signature = bds.encrypt( bds.hash(data) );
		System.out.println( "Signature: "+ signature );
		
		System.out.println();
		
		boolean isValid = bds.verify(data, signature);
		System.out.println( ( isValid ) ? "Correct data!" : "Incorrect data!" );
		
	}
	
}