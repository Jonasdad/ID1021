import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ZipTwo{
    Node[] data;
    Integer[] keys;
    int max;
    
    public ZipTwo(String file) {
    data = new Node[100000];
    keys = new Integer[10000];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
            data[code] = new Node(code, row[1], Integer.valueOf(row[2]));
            keys[i++] = code;
        }
        max = i-1;
        } catch (Exception e) {
        System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup_key_as_index(Integer code){
        try{
            if(data[code].equals(code)){
                return true;
            }
            return false;
        }
        catch(Exception e){
            System.out.println("No such zip-code in list");
            System.exit(0);
            return false;

        }
    }

    public void collisions(int mod) {
        int[] data = new int[mod];
        int[] cols = new int[10];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        System.out.println(mod);
        for (int i = 0; i < 10; i++) {
            System.out.print("\t" + cols[i]);
        }
        System.out.println();
    }

    public void hash(){
        for(int i = 0; i < max; i++){
            
        }
    }

    // public static void main(String[] args){
    //     ZipTwo test = new ZipTwo("C:\\ID1021\\Hash\\postnummer.csv");
    //     for(int i = 0; i < 9675; i++){
    //         System.out.print(test.keys[i]);
    //     }
    // }

}