/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise;

/**
 *
 * @author User
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import bcd.Hasher;

public class Passworder {

	//Consider the passwordset.txt
	
	//Hashing algorithm: MD5, SHA256, SHA384, SHA512
	/** TASK: 1) Generate the hash of each password with a salt value from the passwordset.txt.
	 * 		  2) Write the hash to the new file called password-hashes.txt
	 * 			 For example, 
				 *  1980290|saltvalue|e688fa166c5edf9d5dfda37bf0f0548cec453b6059fd1fc86ff8d0813352bc35
					tornadof|saltvalue|e688fa166c5edf9d5dfda37bf0f0548cec453b6059fd1fc86ff8d0813352bc35
					vova87654|saltvalue|e688fa166c5edf9d5dfda37bf0f0548cec453b6059fd1fc86ff8d0813352bc35
					XpKvShrO|saltvalue|e688fa166c5edf9d5dfda37bf0f0548cec453b6059fd1fc86ff8d0813352bc35
	 */
	
	private static final String PATH = "./src/main/java/dataset/";
	
	
	//getAll()
	public static List<String> getAll( String fileName ) throws IOException {
//		String dir = System.getProperty("user.dir");
//		String path = dir + "\\"+ fileName;
		String path = PATH + fileName;
		File file = new File( path );
		if( file.exists() ) {
			return Files.readAllLines( Paths.get( path ) );
		}else {
			throw new FileNotFoundException("File not found!");
		}
	}

	//hash( String, String, String )
	public static String hash( String pwd, String salt, String algorithm ) {
		return Hasher.hash(pwd, salt, algorithm);
	}
	
	
}