/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycreator;

import java.security.*;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.*;
import java.util.*;

import bcd.Configuration;

public class KeyPairMaker {
	
	private KeyPairGenerator keygen;
	private KeyPair keyPair;
	
	//constructor
	public KeyPairMaker() {
		try {
			keygen = KeyPairGenerator.getInstance( Configuration.PUBLICKEY_ALGORITHM );
			keygen.initialize( 1024 );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * create()
	 */
	public static void create() {
		try {
			//KeyPairMaker object
			KeyPairMaker maker = new KeyPairMaker();
			//generate keypair
			maker.keyPair = maker.keygen.generateKeyPair();
			//get publickey
			PublicKey pubkey = maker.keyPair.getPublic();
			//get privatekey
			PrivateKey prikey = maker.keyPair.getPrivate();
			
			//view 
			System.out.println( "Public key: "+ 
					Base64.getEncoder().encodeToString( pubkey.getEncoded() ) );
			System.out.println( "Private key: "+ 
					Base64.getEncoder().encodeToString( prikey.getEncoded() ) );
			
			//keystore
			put( pubkey.getEncoded(), Configuration.PUBLICKEY_FILE);
			put( prikey.getEncoded(), Configuration.PRIVATEKEY_FILE );
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * put()
	 */
	private static void put( byte[] keyBytes, String location ) {
		File f = new File( location );	
		f.getParentFile().mkdirs();
		try {
			Files.write(Paths.get(location), keyBytes, StandardOpenOption.CREATE);
			System.out.println( "Done..." );
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
