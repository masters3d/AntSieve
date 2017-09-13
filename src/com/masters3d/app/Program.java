package com.masters3d.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
	
	public static Scanner scanIn = new Scanner(System.in);
	
	public static void interactive(){
		int valueInt = -1;
		
		while (true){
			System.out.println("Please enter a positive integer: ");

			try {
				valueInt = scanIn.nextInt();
				Sieve sieve = new Sieve(valueInt);

				for(int each : sieve.getPrimes()){
					System.out.println(each);
				}
	        } catch (InputMismatchException ime) {
	        		valueInt = -1;
	            scanIn.nextLine();
	        }
			System.out.println();
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome to the Sieve of Erastosthenes.");
		System.out.println("  This program calculates all the prime numbers less than or equal to the integer given.");
		interactive();

	}

}
