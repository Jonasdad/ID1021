import java.util.Random;
import java.util.Scanner;
public class RandomAccess {

    public static void main(String[] args) {

        int sum = 0;
        //int given[] = {1,2,3,4,5,6,7,8,9,0};
        //for(int i = 0; i < 10; i++){
            //long n0 = System.nanoTime();
            //sum += given[i];
            //long n1 = System.nanoTime();
          //  System.out.println("Resolution: " + (n1-n0) + "nanoseconds");
        //

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a integer number: ");
        int n = scan.nextInt();
        System.out.println("Random Access: " + access(n));
    }

    private static double access(int n) {
        //copy n 
        int l = n;
        int k = 1000000;
        //Create random(); object
        Random rnd = new Random();
        int[] indx = new int[l];

        // fill indx array with a random number
        for (int i = 0; i < l; i++) {
            indx[i] = rnd.nextInt(n);
            //System.out.println("Random number: " + indx[i]);
        }

        int array[] = new int[l];
        // fill array with dummy values
        for (int i = 0; i < n; i++) {
            array[i] = 1;
        }
        int sum = 0;
        long t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < l; i++) {
                // access the array with the index given by indx[i]
                // sum up the result
                sum += array[i];
            }
        }
        long t1 = System.nanoTime();
        long t_access = (System.nanoTime() - t0);
        double t_random = (((double)(t1 - t0)) / (((double)k*(double)l))); 
        sum = 0;
        t0 = System.nanoTime();
        for (int j = 0; j < k; j++) {
            for(int i = 0; i < l; i++){
            // do the same iteration but only do a dummy add operation
            sum++;
            }
        }
        long t_dummy = (System.nanoTime() - t0);
        return ((double)(t_access - t_dummy)/((double)k*(double)(l)));
    }
}