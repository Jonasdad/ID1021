import java.util.Random;
import java.util.Scanner;
public class Search {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter size of search array: ");
        int n = scan.nextInt();
        int k = 1_000_000;
        int m = n+1;
        System.out.println(SearchArray(n, m, k));

    }

    private static long SearchArray(int n, int m, int k){
        int[] keys = new int[m];
        int[] array = new int[n];

        Random rnd = new Random();
        int sum = 0;
        long t_total = 0;
        for(int j = 0; j < k; j++){
            for(int fillA = 0; fillA < m; fillA++){
                keys[fillA] = rnd.nextInt(10*n);
            }
    
            for(int FillB = 0; FillB < n; FillB++){
                array[FillB] = rnd.nextInt(10*n);
            }
         long t0 = System.nanoTime();

        for (int ki = 0; ki < m; ki++) {
            int key = keys[ki];
            for (int i = 0; i < n; i++) {
                if (array[i] == key) {
                    sum++;
                    break;
                }
            }
        }
        t_total += (System.nanoTime() - t0);
            


     }
     return t_total/k;
}
}
