import java.util.Random;

public class FastDuplicate {
    public static int fastDuplicate(int[] a, int[] b){
        int i = 0;
        int j = 0;
        int number_of_duplicates = 0;
        while(i <= (a.length - 1)  && j <= (b.length - 1)){
            if(a[i] == b[j]){
                number_of_duplicates++;
                i++;
                continue;
            }
            if(a[i] > b[j]){
                j++;
                continue;
            }
            if(a[i] < b[j]){
                i++;
                continue;
            }
            
        }
        
        return number_of_duplicates;
    } 
    private static int[] sorted(int n) {
        Random rnd = new Random();	
        int[] array = new int[n];
        int nxt = rnd.nextInt(10);
    
        for (int i = 0; i < n ; i++) {
            array[i] = nxt;
            nxt += rnd.nextInt(10) + 1 ;
        }	
        return array;
        }
    
        public static void main(String[] args){
            int[] size = {100,200,400,800,1600,3200};
            System.out.printf("# searching through an array of length n, time in ns\n");
	        System.out.printf("#%7s%18s%18s\n", "n", "Fast Duplicate", "Binary Duplicate");
            for(int n : size){
                System.out.printf("%8d", n);
                int k = 10;
                long t_total = 0;
                long t_total2 = 0;
                int[] a = sorted(n);
                int[] b = sorted(n);
                for(int i = 0; i < k; i++){
                    long t0 = System.nanoTime();
                    Duplicate.binary_duplicate(n);
                t_total += (System.nanoTime() - t0);
                }
                System.out.printf("%8.0f\n", (t_total/((double)k)));


        //         for(int i = 0; i < k; i++){
        //             long t0 = System.nanoTime();
        //             Duplicate.binary_duplicate(a, b);
        //             t_total2 += (System.nanoTime() - t0);
        // }
        //         System.out.printf("%8.0f\n", (t_total2/(double)k));
        }
    }
}