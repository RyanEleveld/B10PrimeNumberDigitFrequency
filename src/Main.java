import java.io.BufferedWriter;
import java.io.FileWriter;
//n=10,000,000 RUNTIME <20 min
//n=100,000,000 RUNTIME START 11:22PM


public class Main{
    //Java main Method
    public static void main(String [] args) {
        int _MAXPRIME=100000000; //DEFAULT: 100000000
        int _MAXSAMPLES=10000; //DEFAULT: 10000;
        //Catches IOException e
        try{
            //initializes BufferedWriter outputWriter to provide hard trail
            BufferedWriter outputWriter = new BufferedWriter(new FileWriter("//Users//ryaneleveld//Desktop//PrimeList.txt"));

            //Adds two!
            generatePrime.checkPrevPrime(2,outputWriter);

            //Checks all odd numbers less than _MAXPRIME for primeness
            for(int i=3;i<_MAXPRIME;i=i+2){
                    generatePrime.checkPrevPrime(i, outputWriter);
                    if((i+1) % 1000 == 0){
                        System.out.println((float) i*100/_MAXPRIME);}
                }
            outputWriter.close();
            }
        catch(Exception e){System.out.println(e.getMessage());}

        //Prints # of primes to terminal
        System.out.println(generatePrime.prevPrime.size());

        try {
            BufferedWriter statsWriter = new BufferedWriter(new FileWriter("//Users//ryaneleveld//Desktop//PrimeCounts//PrimeStats.txt"));
            double[] avgDigits = new double[_MAXSAMPLES];

            //Draws _MAXSAMPLES of size 100
            for (int j = 1; j <= _MAXSAMPLES; j++) {
                //Write Data Header
                statsWriter.write("Sample: " + j);
                statsWriter.newLine();
                statsWriter.flush();

                //Generates random array of indices
                int[] randomIdx = randomHandler.randomListNR(100, j);

                //Samples prevPrime @ randomIdx and returns frequency of B10 digits
                int[] digitFrequency = countPrime.countDigits(randomIdx, generatePrime.prevPrime);
                
                double sumDigits=0;
                double numDigits=0;

                try {
                    //Initializes BufferedWriter countersWriter to provide hard trail
                    BufferedWriter countersWriter = new BufferedWriter(new FileWriter("//Users//ryaneleveld//Desktop//PrimeCounts//PrimeCount" + j + ".txt"));

                    //Writes count data to file
                    for (int i = 0; i < 10; i++) {
                        statsWriter.write(i + ": " + digitFrequency[i]);
                        statsWriter.newLine();
                        statsWriter.flush();
                        countersWriter.write(i + ": " + digitFrequency[i]);
                        countersWriter.newLine();
                        sumDigits = sumDigits + i * digitFrequency[i];
                        numDigits = numDigits + digitFrequency[i];
                        
                    }
                    //Write Mean Digit #
                    avgDigits[j-1] = sumDigits/numDigits;

                    statsWriter.write("AvgDigit: " + avgDigits[j-1]);
                    statsWriter.newLine();
                    statsWriter.newLine();
                    statsWriter.flush();

                    //Close individual record file
                    countersWriter.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                
                

        /*for (int i: randomIdx){
            System.out.print(i + ",");
        }
        System.out.println();
        int counter = 0;

        for(int i: digitFrequency){
            System.out.println(counter + ": " + i);
            counter++;
        }*/
            }
            double sampleMean = 0;
            for (double i: avgDigits){sampleMean=sampleMean + i/avgDigits.length;}
            double sampleVar = 0;
            for (double i: avgDigits){sampleVar = sampleVar + Math.pow(i-sampleMean,2)/avgDigits.length;}

            statsWriter.write("Sample Mean: " + sampleMean);
            statsWriter.newLine();
            statsWriter.write("Sample StDev: " + Math.pow(sampleVar,0.5));
            statsWriter.newLine();
            statsWriter.close();
        }
        catch (Exception e){e.printStackTrace();}
    }
}
