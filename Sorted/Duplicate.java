import java.util.Random;
public class Duplicate {
    public static int[] sorted(int n) {
        Random rnd = new Random();	
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);
    
        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }	
        return array;
        }
    public static void main(String[] args) {

        int u = 0;
        int[] bencharray = { 100, 200, 400, 800, 1600, 3200 };

        for (int n : bencharray) {
            long t_total = 0;
            int k = 1_00000;
            
            for (int j = 0; j < k; j++) {
                int[] array1 = sorted(n);
                int[] array2 = sorted(n);
                long t0 = System.nanoTime();
                for (int i = 0; i < array1.length; i++) {
                    if (binarySearch.binary_search(array2, array1[i])) {
                        u++;
                    }
                }
                t_total += (System.nanoTime() - t0);
            }
            System.out.println("average time for array of " + n + " length: " + (t_total / (double) k) + "\t amount of hits: " + ((double) u / (double) k));
        }

    }

}