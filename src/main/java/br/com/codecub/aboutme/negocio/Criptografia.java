package br.com.codecub.aboutme.negocio;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografia {

	public static String md5(String password) {
		
		MessageDigest algorithm;
		byte messageDigest[] = null;
	
		try {
			algorithm = MessageDigest.getInstance("MD5");
			messageDigest = algorithm.digest(password.getBytes("UTF-8"));
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02x", 0xFF & b));
		}
		
		String encrypted = hexString.toString();
		
		return encrypted;
		
	}
	
}
