/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycreator;


import java.util.concurrent.TimeUnit;

import bcd.ASymmCrypto;

public class TestASymmCrypto {

	public static void main(String[] args) throws Exception{

		ASymmCrypto crypto = new ASymmCrypto();
		
		String data = "teabreak! encrypt it...";
		System.out.println( "Data: "+ data );
		
		String encrypted = crypto.encrypt(data, KeyAccess.getPublicKey());
		System.out.println( "Encrypted: "+encrypted );
		
		System.out.println();
		TimeUnit.SECONDS.sleep(3);
		
		String decrypted = crypto.decrypt(encrypted, KeyAccess.getPrivateKey());
		System.out.println( "Recovered: "+decrypted );

	}

}