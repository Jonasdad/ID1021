import java.util.Random;

public class Bench2 {
    /********* BENCHMARK ADD AND REMOVE *********/
    public static void main(String[] args){




        int[] sizes = {16,32,64,128,256,512,1024,2048,4096,8192,16384,32768};
        
    System.out.printf("# add and remove from a list of length n, time in ns\n\n");
    System.out.printf("# %7s\t%8s\t%8s\n", "n", "list1", "list2");

    for(int n : sizes) {

        int tries = 100;
        int loops = n;
        double min = Double.POSITIVE_INFINITY;
        double dmin = Double.POSITIVE_INFINITY;
        
        System.out.printf("%8d\t", n);
        
        // create two lists of different types
        ListofItems list_1 = new ListofItems();
        ListofItems list_2 = new ListofItems();
        
        for(int i = 0; i < tries; i++) {
            
            // generate random node value
            int[] sequence = new int[loops];
            
            Random rnd = new Random();
            for(int k = 0; k < loops; k++) {
                
                sequence[k] = rnd.nextInt(5 * n);					// value between 0 (inclusive) and n (exclusive)
            }
            

            /*** LIST 1 ***/

            // start time
            double t0 = System.nanoTime();
            for(int j = 0; j < loops; j++) {

                list_1.add1(sequence[j]);
                //list_1.remove();
            }
            for(int j = 0; j < loops; j++) {

                list_1.removeN();
            }
            // stop time
            double t1 = System.nanoTime();
            double t = (t1 - t0);
            if (t < min)
            min = t;


            /*** LIST 2 ***/

            // start time
            double dt0 = System.nanoTime();
            for(int j = 0; j < loops; j++) {

                list_2.addN(sequence[j]);
            }
            for(int j = 0; j < loops; j++) {
                
                list_2.remove1();
            }
            // stop time
            double dt1 = System.nanoTime();
            double dt = (dt1 - dt0);
            if (dt < dmin)
                dmin = dt;
        }
        System.out.printf("%8.0f\t", (min / loops));
        System.out.printf("%8.0f\n", (dmin / loops));
    }
}

}