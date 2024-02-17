public class City {
    String name;
    connections[] connects = new connections[5];
    public City(String name){
        this.name = name;
    }

    public void add_connection(City name, Integer minutes){
        int i = 0;
        while(connects[i] != null){
            i++;
        }
        connects[i] = new connections(name, minutes);
    }
}
