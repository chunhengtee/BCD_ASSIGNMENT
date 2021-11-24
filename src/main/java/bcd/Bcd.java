/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcd;


import bcd.Hasher;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bcd {

	public static void main(String[] args) {
		ArrayList<String> unhash = new ArrayList<>();
		ArrayList<String> hashed = new ArrayList<>();
		try{
			File pwdFile = new File("C:\\Users\\User\\OneDrive\\Desktop\\BcdTest\\passwordset.txt");
			Scanner fileScanner = new Scanner(pwdFile);
			while (fileScanner.hasNextLine()){
				String data = fileScanner.nextLine();
				unhash.add(data);
				//System.out.println(data);
			}
			fileScanner.close();
			FileWriter Writer = new FileWriter("C:\\Users\\User\\OneDrive\\Desktop\\BcdTest\\password-hashes(MD5).txt");
			FileWriter Writer_SHA256 = new FileWriter("C:\\Users\\User\\OneDrive\\Desktop\\BcdTest\\password-hashes(SHA256).txt");
			FileWriter Writer_SHA384 = new FileWriter("C:\\Users\\User\\OneDrive\\Desktop\\BcdTest\\password-hashes(SHA384).txt");
			FileWriter Writer_SHA512 = new FileWriter("C:\\Users\\User\\OneDrive\\Desktop\\BcdTest\\password-hashes(SHA512).txt");


			for(String s: unhash){
				String hashPass = Hasher.hash(s,"MD5");
				Writer.write("Password: "+s+"\n");
				Writer.write("Hash: "+hashPass+"\n");
				Writer.write("\n\n");
			}
			Writer.close();
			for(String s: unhash){
				String hashPass= Hasher.hash(s,"SHA-256");
				Writer_SHA256.write("Password: "+s+"\n");
				Writer_SHA256.write("Hash: "+hashPass+"\n");
				Writer_SHA256.write("\n\n");
			}
			Writer_SHA256.close();
			for(String s: unhash) {
				String hashPass = Hasher.hash(s, "SHA-384");
				Writer_SHA384.write("Password: " + s + "\n");
				Writer_SHA384.write("Hash: " + hashPass + "\n");
				Writer_SHA384.write("\n\n");
			}
			Writer_SHA384.close();
			for(String s: unhash){
				String hashPass = Hasher.hash(s,"SHA-512");
				Writer_SHA512.write("Password: "+s+"\n");
				Writer_SHA512.write("Hash: "+hashPass+"\n");
				Writer_SHA512.write("\n\n");
			}
			Writer_SHA512.close();


		} catch (IOException e){
			e.printStackTrace();
		}

	}

	
}
