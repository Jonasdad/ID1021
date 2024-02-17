import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class ZipInt{
    Node[] data;
    int max;
    
    public ZipInt(String file) {
    data = new Node[10000];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
            data[i++] = new Node(code, row[1], Integer.valueOf(row[2]));
        }
        max = i-1;
        } catch (Exception e) {
        System.out.println(" file " + file + " not found");
        }
    }

    public boolean linear_lookup(Integer code){
        for(int i = 0; i < 9675; i++){
            if(data[i].code.equals(code)){
                return true;
            }
        }
        return false;
    }

     public boolean binary_search(Integer key){
         int first = 0;
         int last = 9674;
         while (first <= last) {
             // jump to the middle
             int index = first + ((last - first) / 2);
             int move = data[index].code;
             //compareTo will return zero if data[index].code == key
             if (data[index].code.equals(key)){
                return true;
             }
             //compareTo will return a negative value if data[index].code < key
             //compareTo will return a positive value if data[index].code > key
             if(data[index].code < key) {
             first = index + 1;
                }

             else{
             last = index - 1;
                }
        }
        return false;
    }

    public static void main(String[] args){
        ZipInt test = new ZipInt("C:\\ID1021\\Hash\\postnummer.csv");
        System.out.println(test.data[0].code);
    }
}