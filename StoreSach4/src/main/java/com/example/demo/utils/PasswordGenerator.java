//package com.example.demo.utils;
//
//import java.util.Random;
//
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//public class PasswordGenerator {
//
//	private static final int strength = 12;
//	
//	// BCryptPasswordEncoder method
//	public static String getHashString(String input) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
//		String hashedPassword = passwordEncoder.encode(input);
//		
//		return hashedPassword;
//	}
//	
//	// BCryptPasswordEncoder method
//	public static boolean checkHashStrings(String rawPassword, String encodedPassword) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(strength);
//		return passwordEncoder.matches(rawPassword, encodedPassword);
//	}
//	
//	//generator 6 characters 0-9 and a-z and A-Z for password
//	public static String generateRandomPassword() {
//		final String alphaBet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdeghijklmnopqrstuvwxyz";
//		
//		final int N = alphaBet.length();
//		
//		Random random = new Random();
//		StringBuffer buffer = new StringBuffer();
//		
//		for(int i = 0; i < 6; i++) {
//			buffer.append(alphaBet.charAt(random.nextInt(N)));
//		}
//		
//		return buffer.toString();
//	}
//	
//	public static void main(String[] args) {
//		System.out.println(new BCryptPasswordEncoder().encode("123456"));
//	}
//}
