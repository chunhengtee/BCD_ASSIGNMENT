/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Tempblates
 * and open the template in the editor.
 */
package bcd;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;

/**
 * 
 * @author kimlee
 *
 * This class shows the fundamental of digital signature making.
 */
public class BasicDS {

	/**
	 * hashing + crypto
	 */
	
	private final String HASH_ALGORITHM = "SHA-256";
	private final String CRYPTO_ALGORITHM = "RSA";
	
	private Cipher cipher;
	
	/**
	 * START: DEMO
	 */
	private KeyPairGenerator keygen;
	private KeyPair keyPair;
	{
		try {
			keygen = KeyPairGenerator.getInstance(CRYPTO_ALGORITHM);
			keyPair = keygen.generateKeyPair();
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}
	//END: DEMO
	
	public BasicDS() 
	{
		try {
			cipher = Cipher.getInstance(CRYPTO_ALGORITHM);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * hash()
	 */
	public byte[] hash( String data ) {
		try {
			return MessageDigest.getInstance( HASH_ALGORITHM ).digest( data.getBytes() );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * encrypt()
	 */
	public String encrypt( byte[] hash ) {
		String signature = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPrivate());
			signature = Base64.getEncoder().encodeToString( cipher.doFinal(hash) );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return signature;
	}
	
	/**
	 * verify()
	 */
	public boolean verify( String data, String signature) {
		byte[] hash = hash( data );
		try {
			cipher.init(Cipher.DECRYPT_MODE, keyPair.getPublic());
			byte[] signatureBytes = cipher.doFinal( Base64.getDecoder().decode( signature ) );
			return Arrays.equals(hash, signatureBytes);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
}