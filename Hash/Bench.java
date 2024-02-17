public class Bench{

    public static void main(String[] args){
        Zip test = new Zip("C:\\ID1021\\Hash\\postnummer.csv");
        ZipInt test2 = new ZipInt("C:\\ID1021\\Hash\\postnummer.csv");
        //ZipInt intTest2 = new ZipInt("C:\\ID1021\\Hash\\postnummer.csv");
        
        System.out.println(test2.data.length);
        double k = 10000;
        Integer key = 11115;
        Integer key2 = 99499;
        long t0 = System.nanoTime();
        for(int i = 0; i < k; i++){
            test2.linear_lookup(key);
        }
        long t1 = System.nanoTime();
        if(test2.linear_lookup(key) == true){
            System.out.println(key + " linearly found in: " + (t1-t0)/k + " nanoseconds");
        }
        else{
            System.out.println(key + " not in list. Search completed in: " + (t1-t0)/k + " nanoseconds");
        }
        t0 = System.nanoTime();
        for(int i = 0; i < k; i++){
            test2.linear_lookup(key2);
        }
        t1 = System.nanoTime();
        if(test2.linear_lookup(key2)){
            System.out.println(key2 + " linearly found in: " + (t1-t0)/k + " nanoseconds");
        }
        else{
            System.out.println(key2 + " not in list. Search completed in: " + (t1-t0)/k + " nanoseconds");
        }
        t0 = System.nanoTime();
        for(int i = 0; i < k; i++){
            test2.binary_search(key);
        }
        t1 = System.nanoTime();
        if(test2.binary_search(key)){
            System.out.println(key + " was found in: " + (t1-t0)/k + " nanoseconds using Binary Search");
        }
        else{
            System.out.println(key + " not in list. Search completed in: " + (t1-t0)/k + " nanoseconds");
        }

        t0 = System.nanoTime();
        for(int i = 0; i < k; i++){
            test2.binary_search(key2);
        }
        t1 = System.nanoTime();
        if(test2.binary_search(key2)){
            System.out.println(key2 + " found in: " + (t1-t0)/k + " nanoseconds using Binary Search");
        }
        else{
            System.out.println(key2 + " not in list. Search completed in: " + (t1-t0)/k + " nanoseconds");
        }



    }

}