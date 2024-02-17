public class binarySearch {
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        while (true) {
            // jump to the middle
            int index = ((first + last) / 2);
            if (array[index] == key) {
                return true;
            }
            if (array[index] < key && index < last) {
            first = index + 1;
            continue;
            }
            if (array[index] > key && index > first) {
            last = index - 1;
            continue;
            }
            //Element is not present
            break;
        }
        return false;
        }

       // public static void main(String[] args){
         //   Scanner scan = new Scanner(System.in);
          //  Random rnd = new Random();
           // int k = 1000000;
           // long t_total = 0;
           // System.out.println("Enter size of array");
           // int n = scan.nextInt();
           // for(int i = 0; i < k; i++){
           //     int key = rnd.nextInt(n);
           //     int[] sorted_array = sorted_array(n);
        //    long t0 = System.nanoTime();
         //           binary_search(sorted_array, key);
          //      long t1 = (System.nanoTime() - t0);
           //         t_total += t1;
       // }
       // System.out.println("Binary Search Run-Time: " + (t_total/(double)k));
   // }
}
