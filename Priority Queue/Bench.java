import java.util.Random;
public class Bench{
        public static void main(String[] args){
        ListofItems unsorted = new ListofItems();
        ListofItems sorted = new ListofItems();
        Random rnd = new Random();
        long t1 = 0;
        long t2 = 0;
        double k = 100000;
        int[] list = {100,200,300,400,500,600,700,800,900,1000};
        int num_elements = 0;


        System.out.printf("%15s","Unsorted test - Remove in O(n) and add items in O(1)\n");
        System.out.printf("Number of elements%30s%30s\n", "Average add time (unsorted) ", "Average remove time (unsorted)");
        for(int n : list){
            System.out.printf("%8s ", n);
            num_elements = n;
            int random = rnd.nextInt(n*5);


            long t0 = System.nanoTime();
            for(int i = 0; i < n; i++){
                unsorted.add1(random);
            }
            t1 += System.nanoTime() - t0;

            long t3 = System.nanoTime();
            for(int i = 0; i < n; i++){
                unsorted.removeN();
            }
            t2 += System.nanoTime() - t3;
            System.out.printf("%20.0f", (t0/k));
            System.out.printf("%30.0f\n", (t2/k));
        }


        System.out.printf("%45s","Sorted test - Remove in O(1) and add items in O(n)\n");
        System.out.printf("Number of elements%30s%30s\n", "Average add time (Sorted) ", "Average remove time (Sorted)");
        for(int n : list){
            System.out.printf("%8s ", n);
            num_elements = n;
            int random = rnd.nextInt(n);
            for(int i = 0; i < k; i++){

                long t0 = System.nanoTime();
                sorted.addN(random);
                t1 += System.nanoTime() - t0;
                long t3 = System.nanoTime();
                sorted.remove1();
                t2 += System.nanoTime() - t3;
            }
            System.out.printf("%20.0f", t1/k);
            System.out.printf("%30.0f\n", t2/k);
        }

        }
    }