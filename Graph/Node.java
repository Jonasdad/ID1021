public class Node {
    String from;
    String to;
    Integer minutes;
    Node next;
    Node(String from, String to, Integer minutes){
        this.from = from;
        this.to = to;
        this.minutes = minutes;
        this.next = null;

    }
}
