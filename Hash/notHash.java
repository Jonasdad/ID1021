import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class notHash {
    Integer[] keys;
    int mod = 19428;
    int max;
    
    public notHash(String file) {
        keys = new Integer[9675];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        String line;
        int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                keys[i++] = code;
            }
            max = i;
            } catch (Exception e) {
            System.out.println(" file " + file + " not found");
            }
        }

        Integer[] hashmap = new Integer[50000];

        public void hash(){
            for(int i = 0; i < max; i++){
                Integer index = keys[i] % mod;  //Generate hash key
                if(hashmap[index] == null){     //Check if slot is filled
                    hashmap[index] = keys[i];   //stick it in
                    continue;}
                while(hashmap[index] != null){
                    index++;}
                hashmap[index] = keys[i];
            }
        }
        public Integer lookup(Integer key){
            Integer index = key % mod;
            Integer amount_of_steps = 0;
            if(hashmap[index].equals(key)){
                return amount_of_steps;
            }
            while(!hashmap[index].equals(key) && hashmap[index] != null){
                index++;
                amount_of_steps++;
            }
            if(!hashmap[index].equals(key)|| hashmap[index] == null){
                return amount_of_steps;
            }
            else{
                return amount_of_steps;
            }
        }

    
}
