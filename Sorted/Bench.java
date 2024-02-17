import java.util.Random;


class Bench {

    private static void linear(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    sorted.search_sorted(array, indx[i]);
	}
    }
    

    private static void binary(int[] array, int[] indx) {
	for (int i = 0; i < indx.length ; i++) {
	    binarySearch.binary_search(array, indx[i]);
	}
    }

       
    public static int[] sorted(int n) {
	Random rnd = new Random();	
	int[] array = new int[n];
	int nxt = rnd.nextInt(10);

	for (int i = 0; i < n ; i++) {
	    array[i] = nxt;
	    nxt += rnd.nextInt(10) + 1 ;
	}	
	return array;
    }


    private static int[] keys(int loop, int n) {
	Random rnd = new Random();	
	int[] indx = new int[loop];
	for (int i = 0; i < loop ; i++) {
	    indx[i] = rnd.nextInt(n*5);
	}	
	return indx;
    }

    public static void main(String[] arg) {
	int[] sizes = { 100, 200, 400, 800, 1600, 3200, 6400, 12800, 25600, 51200, 102400, 204800};

	System.out.printf("# searching through an array of length n, time in ns\n");
	System.out.printf("#%7s%20s%20s\n", "n", "binary duplicate", "fast duplicate");
	for ( int n : sizes) {

	    int loop = 1000;
	    
	    int[] array = sorted(n);
        int[] array2 = sorted(n);
	    int[] indx = keys(loop, n);

	    System.out.printf("%8d", n);

	    int k = 100000;
	    
	    double min = Double.POSITIVE_INFINITY;
        // double average_duplicate = 0;
        // for (int i = 0; i < k; i++) {
        //     long t0 = System.nanoTime();
        //     Duplicate.binary_duplicate(array, array2);
        //     long t1 = System.nanoTime();
        //     double t = (t1 - t0);
        //     if (t < min)
        //         min = t;
        //     }
        //     average_duplicate = Duplicate.binary_duplicate(array, array2);
        //     System.out.printf("%8.0f", (average_duplicate));
        //     System.out.printf("%8.0f\n", (min/loop));

	    // for (int i = 0; i < k; i++) {
		//     long t0 = System.nanoTime();
		//     Duplicate.binary_duplicate(array, indx);
		//     long t1 = System.nanoTime();
		//     double t = (t1 - t0);
		//     if (t < min)
		//         min = t;
	    // }

	    // System.out.printf("%8.0f", (min/loop));	    

	    min = Double.POSITIVE_INFINITY;
	    
	    for (int i = 0; i < k; i++) {
		    long t0 = System.nanoTime();
		    binary(array, indx);
		    long t1 = System.nanoTime();
		    double t = (t1 - t0);
		    if (t < min)
		        min = t;
	    }

	    System.out.printf("%8.0f\n" , (min/loop));	    	    
	}
    }
}