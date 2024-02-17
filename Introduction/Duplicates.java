import java.util.Random;
import java.util.Scanner;
public class Duplicates {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter size of search array: ");
        int n = scan.nextInt();
        System.out.println("First run: "+ Duplicate(n) +"ns");
        System.out.println("Seconds run:" + Duplicate(n)+"ns");
        System.out.println("Third run: "+ Duplicate(n)+"ns");
        
    }
    
    private static long Duplicate(int n){
        int[] keys = new int[n];
        int[] array = new int[n];
        int k = 10000;

        Random rnd = new Random();
        int number_of_duplicates = 0;
        long t_total = 0;
        for(int j = 0; j < k; j++){
            for(int fillA = 0; fillA < n; fillA++){
                keys[fillA] = rnd.nextInt(10*n);
            }
    
            for(int FillB = 0; FillB < n; FillB++){
                array[FillB] = rnd.nextInt(10*n);
            }
         long t0 = System.nanoTime();

        for (int ki = 0; ki < n; ki++) {
            for (int i = 0; i < n; i++) {
                if (array[i] == keys[ki]){
                    number_of_duplicates++;
                }
            }
        }
        t_total += (System.nanoTime() - t0);
            


     }
     return t_total/k;
}
}
