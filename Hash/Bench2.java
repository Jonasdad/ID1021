public class Bench2{
    public static void main(String[] args){
        hashmap test = new hashmap("C:\\ID1021\\Hash\\postnummer.csv");
        notHash test2 = new notHash("C:\\ID1021\\Hash\\postnummer.csv");
        ZipTwo test3 = new ZipTwo("C:\\ID1021\\Hash\\postnummer.csv");
        //test.hash();
        //test2.hash();
        int k = 100;
        long t2 = System.nanoTime();
        System.out.println("Searching for all keys in HashMap");
        for(int i = 0; i < test.keys.length; i++){
          //  test.lookup(test.keys[i]);
        }
        long t3 = System.nanoTime() - t2;
        System.out.println("Average Search time: " + t3/9675+"\n");
        
        int sum = 0;
        System.out.println("Searching for all keys in NotHash");
        long t0 = System.nanoTime();
        for(int i = 0; i < test2.keys.length; i++){
        //    sum += test2.lookup(test2.keys[i]);
        }
        long t1 = System.nanoTime() - t0;
        System.out.println("Run-time wierd hashmap for serching all elements: " + (t1/9675));
        System.out.println("Total number of steps: " + sum);   
        System.out.println("Average step: " + sum/9675);

        t0 = System.nanoTime();
        for(int i = 0; i < k; i++){
            test3.lookup_key_as_index(11115);
        }
        t1 = System.nanoTime() - t0;
        System.out.println("Lookup key as index: " + t1/k);
    }
}