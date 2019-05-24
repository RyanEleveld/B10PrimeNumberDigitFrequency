import java.util.ArrayList;

/**
 * countPrime contains methods responsible for counting various digits in a prime argument.
 */

public class countPrime {

    /**
     * countDigits is a method written to count the digits in the sampled ArrayList primeList given an Array of random indices, idx
     *
     * @param idx int[] size specified in Main.main: Array containing the random indices to sample
     * @param primeList ArrayList&#60Integer&#62 : ArrayList containing the sampling space of primes
     * @return int[10]: Array where index DIGIT contains the frequency of DIGIT in sample of primeList
     */

    public static int[] countDigits(int[] idx, ArrayList<Integer> primeList){
        //Inits container variables
        String prime;
        int[] countArray = new int[10];

        //Iterates through indices in idx, selecting primes at index i
        for (int i: idx){
            prime = primeList.get(i).toString();

            //Iterates through digits d in PRIME, incrementing proper digit in countArray
            for (char d: prime.toCharArray()) {
                countArray[Character.digit(d,10)]++;
            }
        }
        return countArray;
    }
}
