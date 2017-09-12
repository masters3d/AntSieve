package com.masters3d.app;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {

	public static void runTests(){
		System.out.println("Running automatic tests");
		List<Integer> primesOf10 = new ArrayList<Integer>();
		primesOf10.add(2);
		primesOf10.add(3);
		primesOf10.add(5);
		primesOf10.add(7);
		List<Integer> primesOf10Result = (new Sieve(10)).getPrimes();
		
		if(!primesOf10.equals(primesOf10Result)){
			throw new RuntimeException("Sieve(10) did not return the correct result");
		}
		System.out.println("Testing passed for Sieve(10)");
		for(int each : primesOf10){
			System.out.print( each + ", ");
		}
		System.out.println();
		
		List<Integer> primesOf100 = (new Sieve(100)).getPrimes();
		if (97 != primesOf100.get(primesOf100.size() - 1))
		{
			throw new RuntimeException("Sieve(10) did not return the correct result");

		}
		System.out.println("Testing passed for Sieve(100)");
		for(int each : primesOf100){
			System.out.print( each + ", ");
		}
		System.out.println();
		System.out.println("All Tests passed");
			
	}
	
	static public Scanner scanIn = new Scanner(System.in);
	
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
		if (args.length > 1)
		{
			runTests();
		} else 
		{
			interactive();
		}
		

	}

}
