package com.masters3d.app;
import java.util.ArrayList;
    import java.util.List;

class Sieve {
    private int limit;
    public Sieve(int maxPrime) {
        limit = maxPrime;
    }

    List<Integer> getPrimes() {
        List<Integer> primes = new ArrayList<Integer>();

        if (limit < 2){
            return primes;
        }
        
        for(int i = 2; i <= limit; i+= 1){
            int number = i;
            int divisor = 2;
            List<Integer> primesWithin = new ArrayList<Integer>();

            whileLoop:
            while (number > 1){
                while(number % divisor == 0){
                   primesWithin.add(divisor);
                   number = number / divisor;
                
                   if (primesWithin.size() > 1){
                     break whileLoop;
                   }
                
                }
                divisor += 1;
            }
            if (primesWithin.size() == 1){
                primes.add(i);
            }
            continue;
        }
        
        return primes;
    }
}
