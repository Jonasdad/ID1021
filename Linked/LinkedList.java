public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item) {
        head = item;
        }

    public int head() {
        return this.head;
    }

    public LinkedList tail() {
        return this.tail;
    }

    public void printlist(){
        LinkedList nxt = this;
        System.out.println(nxt.head);
        while (nxt.tail != null){
            System.out.println(nxt.tail.head);
            nxt = nxt.tail;
        }
    }

    public void append(LinkedList b) {
        LinkedList nxt = this;
        while (nxt.tail != null) {
            nxt = nxt.tail;
        }
        nxt.tail = b;
    }
    
    public static void main(String[] args){

    }

}
