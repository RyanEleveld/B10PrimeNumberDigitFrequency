import java.io.BufferedWriter;
import java.util.ArrayList;

/**
 * generatePrime contains methods to generate an ArrayList prevPrime of prime numbers
 */

public class generatePrime {
    //Initialize prevPrime ArrayList to store found primes
    public static ArrayList<Integer> prevPrime = new ArrayList<>();

    /**
     * Checks to see if elements of prevPrime are factors
     * @param pPrime integer possible prime to be checked
     * @param fileWriter BufferedWriter used to handle writing output to txt file
     * @throws java.io.IOException on fileWriter failure
     */

    public static void checkPrevPrime(int pPrime, BufferedWriter fileWriter) throws Exception{
        boolean retVal=false;

        //Iterates through integers (i) in prevPrime and checks if pPrime (mod i) is zero (a factor)
        for(int i: prevPrime){
            //if factor, set return value and break loop
            if(pPrime % i == 0){
                retVal = true;
                break;
            }
        }
        //If the number is Prime, add to list and write to file
        if(!retVal){
            prevPrime.add(prevPrime.size(),pPrime);
            fileWriter.write(pPrime + ", ");
        }
    }
}