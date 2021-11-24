/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.security.Key;
import java.util.Base64;

import keycreator.RandomSecretKeyGen;
import keycreator.SecretCharsKeyGen;

public class TestSecretKey {

	/**
	 * check-out / view the secret key generated
	 */
	
	public static void main(String[] args) {

		//testing with the secret char key
		Key secretKey = SecretCharsKeyGen.keygen();
		
		//testing with the random secret key
		//Key secretKey = RandomSecretKeyGen.keygen();
		
		String keyString = Base64.getEncoder().encodeToString( secretKey.getEncoded() );
		System.out.println( keyString );

	}

}