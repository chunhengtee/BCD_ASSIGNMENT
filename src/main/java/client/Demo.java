/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.util.LinkedList;
import java.util.List;

import bcd.Hasher;

public class Demo {

	public static void main(String[] args) {
		//md5();
		sha256();
	}
	
	static void sha256() {
		String passwd = "imfinethankyou";
		
		String hash = Hasher.hash(passwd, "SHA-256");
		
		System.out.println( "passwd: " + passwd );
		System.out.println( "hash[sha256]: "+ hash );
	
		//OUTPUT
//		passwd: imfinethankyou
//		hash[sha256]: b263bb5ffb669b449c9723ad6f9ae7df3841cd483526e6b1660d1c54be658ce6
		
	}
	
	static void md5() {
		String passwd = "imfinethankyou";
		
		String hash = Hasher.hash(passwd, "MD5");
		
		System.out.println( "passwd: " + passwd );
		System.out.println( "hash[md5]: "+ hash );
	
	}
	
	//Tutorial2
	static void demo1() {

		// String
		String s1 = "hi";
		System.out.println("str = " + s1);
		System.out.println("hashcode = " + s1.hashCode());// 3329

		String s2 = "world";
		System.out.println("str = " + s2);
		System.out.println("hashcode = " + s2.hashCode());

		System.out.println();
		
		
		// LinkedList
		List<String> lst = new LinkedList<>();
		System.out.println("hashcode [EMPTY LIST]: " + lst.hashCode());

		lst.add(s1);
		lst.add(s2);
		System.out.println("hashcode [NOT EMPTY LIST]: " + lst.hashCode()); // 113422962

		lst.remove(1);
		System.out.println("hashcode [MODIFIED LIST]: " + lst.hashCode()); // 113422962

	}

}