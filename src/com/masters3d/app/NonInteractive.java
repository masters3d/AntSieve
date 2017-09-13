package com.masters3d.app;

import java.util.ArrayList;
import java.util.List;

public class NonInteractive {

	public static void main(String[] args) {
		System.out.println("Running automatic tests");
		List<Integer> primesOf10 = new ArrayList<Integer>();
		primesOf10.add(2);
		primesOf10.add(3);
		primesOf10.add(5);
		//primesOf10.add(7);
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

}
