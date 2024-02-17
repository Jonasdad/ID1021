import java.util.*;
public class ArrayAppend {

    public static int[] append(int[] array1, int[] array2){
        int[] newArray = new int[array1.length + array2.length];
        int j = 0;
        int k = array1.length;
        for(int i = 0; i < array1.length; i++){
            newArray[i] = array1[i];
        }
        while(k < newArray.length){
            newArray[k] = array2[j];
            j++;
            k++;
        }
        return newArray;
    }

    public static void main(String[] args){
        int[] test = {64,128,256,512,1024,2048,4096};
        Random rnd = new Random();
        System.out.printf("#%8s%20s%20s\n", "n", "varied append", "fixed append");
        int[] fixed = new int[100];
        double k = 100000;
        long t1 = 0;
        long t2 = 0;
        for(int n : test){
            for(int i = 0; i < 100; i++){
                fixed[i] = rnd.nextInt(100);
            }
            for(int i = 0; i < k; i++){
                int[] vary = new int[n];
                for(int j = 0; j < n; j++){
                    vary[j] = rnd.nextInt(n);
                }
                
                long t0 = System.nanoTime();
                append(fixed, vary);
                t1 += System.nanoTime() - t0;
                t0 = System.nanoTime();
                append(vary, fixed);
                t2 += System.nanoTime() - t0;
            }
            System.out.printf("%8d", n);
            System.out.printf("%15.0f", t1/k);
            System.out.printf("%20.0f\n", t2/k);
        }
    }
}
