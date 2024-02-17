public class sorted{


//search method to find element in unsorted array
public static boolean search_unsorted(int[] array, int key) {
    for (int index = 0; index < array.length ; index++) {
       if (array[index] == key) {
            return true;
            }
        }
        return false;

}
//Search method to find element in a sorted array
public static boolean search_sorted(int[] array, int key){
    for(int index = 0; index < array.length; index++){
        if(array[index] == key){
            return true;
        }
        if(index != (array.length - 1)){
            if(array[index + 1] > key){
                return false;
           }
           else{
                continue;
           }
        }
    }
    return false;
}

    // public static void main(String[] args){
    // Random rnd = new Random();
    // Scanner scan = new Scanner(System.in);
    // int k = 100000;
    // long t_total = 0;
    // long t_total2 = 0;

    // System.out.println("Enter size of array: ");
    // int n = scan.nextInt();
    // int array[] = new int[n];
    
    // int key = 0;
    // for(int j = 0; j < k; j++){
    //     for(int i = 0; i < array.length; i++){
    //         array[i] = rnd.nextInt(array.length-1);
    //     }
    //     key = rnd.nextInt(n);
    //     int[] sorted_array = sorted_array(n);
    //     long t0 = System.nanoTime();
    //         search_unsorted(array, key);
    //     long t1 = System.nanoTime();
    //         search_sorted(sorted_array, key);
    //     long t2 = System.nanoTime();
    //     t_total += (t1- t0);
    //     t_total2 += (t2-t1);    
    // }
    //     System.out.println("Unsorted Run time: "+ (t_total/((double)k)) + "ns");
    //     System.out.println("Sorted Run Time: " + (t_total2/((double)k))+ "ns");
    // }
}