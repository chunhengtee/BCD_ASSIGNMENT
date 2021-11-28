/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package keycreator;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import bcd.Configuration;
import java.security.spec.PKCS8EncodedKeySpec;

public class KeyAccess {

	/**
	 * read the key
	 */
	
	public static PublicKey getPublicKey(String hashName) throws Exception{
		byte[] keyBytes = Files.readAllBytes( Paths.get( Configuration.PUBLICKEY_FILE+hashName ) );
		X509EncodedKeySpec spec = new X509EncodedKeySpec( keyBytes );
		return KeyFactory.getInstance( Configuration.PUBLICKEY_ALGORITHM ).generatePublic(spec);
	}
	
	public static PrivateKey getPrivateKey(String hashName) throws Exception{
		byte[] keyBytes = Files.readAllBytes(Paths.get( Configuration.PRIVATEKEY_FILE+hashName ));
		PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec( keyBytes );
		return KeyFactory.getInstance(Configuration.PUBLICKEY_ALGORITHM).generatePrivate(spec);
	}
	
}