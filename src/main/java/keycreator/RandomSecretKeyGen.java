/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycreator;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.KeyGenerator;

/**
 * @author kimlee
 *
 * This creates a random-secret-key for cryptography using SecureRandom
 */

public class RandomSecretKeyGen {

	//algorithm - AES
	private static final String ALGORITHM = "AES";

	private static KeyGenerator keygenerator;
	
	/**
	 * keygen()
	 */
	public static Key keygen() {
		try {
			keygenerator = KeyGenerator.getInstance(ALGORITHM);
			keygenerator.init( 128, new SecureRandom() );
			return keygenerator.generateKey();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}