/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycreator;

import java.security.Key;
import java.util.Arrays;

import javax.crypto.spec.SecretKeySpec;

/**
 * @author kimlee
 *
 * This creates a secret-key for cryptography using predefined chars
 */

public class SecretCharsKeyGen {

	//algorithm - AES
	private static final String ALGORITHM = "AES";
	
	//predefined-chars
	//private final static String SECRET_CHARS = "thisisasymmetriccryptosystemdemo";
	private final static String SECRET_CHARS = "cryptosystemdemo=thisisasymmetriccryptosystemdemo.my.apu.bcd.keycreator";
	/**
	 * keygen()
	 */
	public static Key keygen() {
		return new SecretKeySpec(
				Arrays.copyOf( SECRET_CHARS.getBytes(), 64 ), ALGORITHM
				);
	}
}
