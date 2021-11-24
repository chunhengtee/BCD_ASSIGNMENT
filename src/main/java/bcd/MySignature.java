/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import java.util.Base64;

public class MySignature {

	/**
	 * Signature API from java.security package
	 */
	private Signature signature;
	
	private final String CRYPTO_ALGORITHM = "RSA";
	
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
	
	public MySignature() {
		try {
			signature = Signature.getInstance( "SHA256WithRSA" );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * sign()
	 */
	public String sign( String data ) {
		try {
			signature.initSign( keyPair.getPrivate() );
			signature.update( data.getBytes() );
			return Base64.getEncoder().encodeToString( signature.sign() );
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	/**
	 * verify()
	 */
	public boolean verify( String data, String signatureString ) {
		try {
			signature.initVerify(keyPair.getPublic());
			signature.update( data.getBytes() );
			return signature.verify( Base64.getDecoder().decode(signatureString) );
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	
}