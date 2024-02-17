import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Zip{
    Node[] data;
    int max;
    
    public class Node {
        String code;
        String name;
        Integer pop;
        
        Node(String code, String name, Integer pop){
            this.code = code;
            this.name = name;
            this.pop = pop;   
        }
    }
    
public Zip(String file) {
    data = new Node[10000];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    int i = 0;
        while ((line = br.readLine()) != null) {
            String[] row = line.split(",");
            data[i++] = new Node(row[0], row[1], Integer.valueOf(row[2]));
        }
        max = i-1;
        } catch (Exception e) {
        System.out.println(" file " + file + " not found");
        }
    }

    public boolean linear_lookup(String code){
        for(int i = 0; i < 9675; i++){
            if(data[i].code.equals(code)){
                return true;
            }
        }
        return false;
    }

     public boolean binary_search(String key){
         int first = 0;
         int last = 9674;
         while (first <= last) {
             // jump to the middle
             int index = first + ((last - first) / 2);
             int move = data[index].code.compareTo(key);
             //compareTo will return zero if data[index].code == key
             if (move == 0) {
                System.out.println("True");
                return true;
             }
             //compareTo will return a negative value if data[index].code < key
             //compareTo will return a positive value if data[index].code > key
             if(move > 0) {
             first = index + 1;
                }

             else{
             last = index - 1;
                }
        }
        return false;
    }

        public static void main(String[] args){
            Zip test = new Zip("C:\\ID1021\\Hash\\postnummer.csv");
            System.out.println(test.data[0].code);
            System.out.println(test.data[0].code.compareTo("111 15"));
            System.out.println("Test for larger zip: "+ test.data[100].code +test.data[100].code.compareTo("999 16"));
            System.out.println("Test for smaller zip: " +test.data[100].code+test.data[100].code.compareTo("000 14"));
            System.out.println(test.data[9674].code);
        }
    }

