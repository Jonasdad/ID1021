public class bench {

    public static void main(String[] args){
        Map test = new Map("C:\\ID1021\\Graph\\trains.csv");
        int k = 1;
        for(int i = 0; i < 541; i++){
            if(test.cities[i] != null){
                System.out.print("City nr " + k + " : " + test.cities[i].name + " connects to ");
                for(int j = 0; j < 1; j++){
                    if(test.cities[i].connects[j].destination != null){
                        System.out.println(test.cities[i].connects[j].destination.name+ ", ");
                    }
                }
                k++;
            }
        }
    }
}
