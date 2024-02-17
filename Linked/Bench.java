import java.util.Random;
public class Bench {
    public static void main(String[] args){
        Random rnd = new Random();
        int[] tests = {64, 128, 256, 512, 1024, 2048, 4096};
        double k = 100;
        System.out.printf("# Appending an array of size n, time in ns\n");
	    System.out.printf("#%7s%25s%25s\n", "n", "Run-time fixed append", "Run-time varied append");
        for(int n : tests){
            long t1 = 0;
            System.out.printf("%8d", n);
            //Benchmark for fixed append
            for(int j = 0; j < k; j++){
                //Initialize linked list of fixed size 100
                LinkedList fixed = new LinkedList(1);
                for(int i = 0; i < 10000; i++){
                    fixed.append(new LinkedList(rnd.nextInt()));
                }
                //initialize Linked List of varying size
                LinkedList vary = new LinkedList(1);
                for(int i = 0; i < n; i++){
                    vary.append(new LinkedList(rnd.nextInt()));
                }
                long t0 = System.nanoTime();
                vary.append(fixed);
                t1 += System.nanoTime() - t0;
                //zero LinkedLists
                fixed = new LinkedList(1);
                vary = new LinkedList(1); 
            }
            System.out.printf("%20.0f", t1/((double)k));




            //Benchmark for varied append
            for(int j = 0; j < k; j++){
                LinkedList fixed2 = new LinkedList(1);
                for(int i = 0; i < 10000; i++){
                    fixed2.append(new LinkedList(rnd.nextInt()));
                }
                 LinkedList vary2 = new LinkedList(1);
                for(int i = 0; i < n; i++){
                    vary2.append(new LinkedList(rnd.nextInt()));
                }
                t1 = 0;
                long t0 = System.nanoTime();
                fixed2.append(vary2);
                t1 += System.nanoTime() - t0;
                //zero LinkedLists
                vary2 = new LinkedList(1);
                fixed2 = new LinkedList(1);
            }
            System.out.printf("%20.0f\n", t1/((double)k));

        }
    }
}