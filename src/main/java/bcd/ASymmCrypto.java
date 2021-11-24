/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;
import java.security.*;
import java.util.Base64;

import javax.crypto.Cipher;

public class ASymmCrypto {

	//Q: Whats the API needed to support en/de-cryption?
	//A: Cipher
	private Cipher cipher;
	
	public ASymmCrypto() {
		try {
			cipher = Cipher.getInstance( Configuration.PUBLICKEY_ALGORITHM );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * encrypt(String, PublicKey)
	 */
	public String encrypt( String input, PublicKey key ) throws Exception{
		String cipherText = null;
		cipher.init(Cipher.ENCRYPT_MODE, key);
		//encrypt
		byte[] cipherBytes = cipher.doFinal( input.getBytes() );
		cipherText = Base64.getEncoder().encodeToString(cipherBytes);
		return cipherText;
	}
	
	
	/**
	 * decrypt(String, PrivateKey)
	 */
	public String decrypt( String cipherText, PrivateKey key ) throws Exception{
		cipher.init(Cipher.DECRYPT_MODE, key);
		cipher.update( Base64.getDecoder().decode( cipherText.getBytes() ) );
		byte[] dataBytes = cipher.doFinal();
		return new String(dataBytes);
	}
	
}