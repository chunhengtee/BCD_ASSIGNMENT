/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;

import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;

public class SymmCrypto {

	//algorithm - AES
	private static final String ALGORITHM = "AES";
	
	//Cipher
	private Cipher cipher;
	
	public SymmCrypto() {
		try {
			cipher = Cipher.getInstance(ALGORITHM);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * encrypt( String, Key )
	 */
    public String encrypt( String input, Key key ) throws Exception{
    	String cipherTxt = null;
    	//init
    	cipher.init(Cipher.ENCRYPT_MODE, key);
    	//encrypt
    	byte[] cipherBytes = cipher.doFinal( input.getBytes() );
    	//convert to String
    	cipherTxt = Base64.getEncoder().encodeToString(cipherBytes);
    	return cipherTxt;
    }
	
	/**
	 * decrypt( String, Key )
	 */	
    public String decrypt( String cipherTxt, Key key ) throws Exception{
    	//init
    	cipher.init(Cipher.DECRYPT_MODE, key);
    	//convert to byte[]
    	byte[] cipherBytes = Base64.getDecoder().decode( cipherTxt );
    	//decrypt
    	byte[] inputBytes = cipher.doFinal( cipherBytes );
    	//return String
    	return new String( inputBytes );
    }
	
}	