/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.apache.commons.codec.binary.Hex;

import exercise.Passworder;
import bcd.Salt;

public class TestPassworder {

	public static void main(String[] args) throws Exception {

		// getall-passwords
		List<String> passwds = Passworder.getAll("passwordset.txt");
		// passwds.forEach(System.out :: println);

		//passwdHash( passwds, "MD5", "md5.txt" );
		//passwdHash( passwds, "SHA-256", "sha256.txt" );
		passwdHash( passwds, "SHA-512", "sha512.txt" );
		
	}
	
	static void passwdHash(List<String> passwds, String algorithm, String exportedFile) {

		List<String> lst = passwds.stream().map(pwd -> {
			// pwd|salt|hash
			String salt = Hex.encodeHexString(Salt.get(16));
			String hash = Passworder.hash(pwd, salt, algorithm);
			return String.join("|", pwd, salt, hash);
		}).collect(toCollection(ArrayList::new));
		// recordList.forEach( System.out :: println );

		// write to file
		lst.forEach(line -> {
			try {
				Files.write(Paths.get(exportedFile), (line + System.lineSeparator()).getBytes(), StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}