/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycreator;


import java.security.Key;
import java.util.concurrent.TimeUnit;

import bcd.SymmCrypto;

public class TestSymmCrypto {

	static String inputMessage = "symmetric message sample";
	
	static SymmCrypto crypto = new SymmCrypto();
	
	public static void main(String[] args) throws Exception{
	
		//Key secretKey = SecretCharsKeyGen.keygen();
		Key secretKey = RandomSecretKeyGen.keygen();

		System.out.println( ">>> Message: "+ inputMessage );
		String cipherText = crypto.encrypt(inputMessage, secretKey);
		
		System.out.println( ">>> CipherText: "+ cipherText );
		
		TimeUnit.SECONDS.sleep(2);
		//cipherText = "symmetric message sample 123";
		System.out.println();
		String content = crypto.decrypt(cipherText, secretKey);
		System.out.println( ">>> Content: "+ content );
		
	}

}
