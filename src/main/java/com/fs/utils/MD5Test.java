package com.fs.utils;


import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author Mr-Yang
 *
 */
public class MD5Test {
	
	
	   public static void main(String[] args) {
			Md5Hash md5 = new Md5Hash("123","yht");
			System.out.println(md5.toString());
			
			
			String name="I LOVE YOU";
			System.out.println("name="+name);
		}
	   
	   

       


}
