import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Map {
    public City[] cities;
    private final int mod = 541;
    
    
    
    public Map(String file) {
    cities = new City[mod];
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = br.readLine()) != null) {
        String[] row = line.split(",");

        //cities[hash(row[0])] = new City(row[0]);
        //cities[hash(row[0])].add_connection(new City(row[1]), Integer.valueOf(row[2]));  

        lookup(row[0]);
        lookup(row[1]);
    }
    } catch (Exception e) {
    System.out.println(" file " + file + " not found or corrupt");
    }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    private City lookup(String cityName) {
        int i = hash(cityName);
        if (cities[i] != null && cities[i].cityName.equals(cityName)) {
            return cities[i];
        } else {
            while (cities[i] != null) {
                if(cities[i].cityName.equals(cityName)){
                    return cities[i];
                }
                i++;
            }

            City newCity = new City(cityName);
            return newCity;


        }

    }
}