import java.util.Random;
public class test {
    public static void main(String[] args){
        
        Random rnd = new Random();
        int n = rnd.nextInt(10);
        LinkedList test = new LinkedList(n, null);
        for(int i = 0; i < 5; i++){
            LinkedList kuk = new LinkedList(n, test);
            test.append(kuk);
        }
        test.printlist();
    }
}
