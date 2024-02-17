import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class hashmap {
    Integer[] keys;
    int mod = 19428;
    Node[] hashmap = new Node[mod];
    int max;

    public hashmap(String file) {
        keys = new Integer[9675];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i++] = code;
            }
            max = i-1;
            } catch (Exception e) {
            System.out.println(" file " + file + " not found");
            }
        }
    
        public void hash(){
            for(int i = 0; i <= max; i++){
                Integer index = keys[i] % mod; //Generate hash key
                if(hashmap[index] == null){ //Check if slot is filled
                    hashmap[index] = new Node(keys[i]); //stick it in
                }
                else{
                    Node temp = hashmap[index]; //if slot is filled create temp to iterate
                    while(temp.next != null){ //Move until we find available slot
                        temp = temp.next;
                    }
                    temp.next = new Node(keys[i]); //Place node
               }
            }
        }

        public boolean lookup(Integer key){
            //first zip code 11115
            Integer lookup_index = key % mod;
            if(hashmap[lookup_index] == null){

                return false;
            }
            if(hashmap[lookup_index].code.equals(key)){

                return true;
            }
            else{
                Node temp = hashmap[lookup_index];
                while(temp.code != key && temp.next != null){
                    if(temp.code.equals(key)){
                        return true;
                    }
                    temp = temp.next;
                }

                return false;
            }
        }
    }
