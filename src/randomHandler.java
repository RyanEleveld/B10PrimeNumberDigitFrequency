import java.util.Iterator;
import java.util.Random;

/**
 * randomHandler contains methods to handle the generation of random numbers
 */

public class randomHandler {

    /**
     * Generates a random array of indices of generatePrime.prevPrime without repeats.
     *
     * @param size The size of the Array to be returned
     * @param seed Seed for Random Object
     * @return int[], an array of Size = size of random indices of generatePrime.prevPrime
     */

    public static int[] randomListNR(int size, int seed){
        //Initializes a bunch of stuff
        int[] returnArray= new int[size];
        Random generator = new Random(seed);
        Iterator<Integer> randomIterator = generator.ints(0,generatePrime.prevPrime.size()).distinct().iterator();

        //Fills intArray
        for(int i=0; i<size; i++){
            returnArray[i] = randomIterator.next();
        }

        return returnArray;
    }

    public static int[] randomListNR(int size){ return randomListNR(size, 1);}
}
