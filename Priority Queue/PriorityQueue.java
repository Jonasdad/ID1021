public class PriorityQueue {
    Node front;
    Node back;
    public class Node {
        public int key;
        public Node head, tail;

        public Node(int key) {
            this.key = key;
            this.head = this.tail = null;
            }
        }
    public PriorityQueue() {
        this.front = null;
        this.back = null;
    }

    //adds item to queue of complexity O(1)   
    public void addOne(int item){
        Node temp = this.front;

        //if queue is empty make temp node front of queue
        if(this.back == null){
            this.front = temp;
            this.back = temp;
            return;
        }
        //put higher values at the back of the queue. Back is from Queue and tail is from Node.
        if(temp.key <= item){
            this.back.tail = temp;
            this.back = temp;
        }
        //Put lower values in the front of the queue.
        //update new head in node and front in queue.
        else{
            this.front.head = temp;
            this.front = temp;
        }
    }
    //Remove of complexity O(n)
    public int removeOne(int item){
        Node temp = this.front;
        while(temp.key != item ){
            if(temp.tail != null){
                System.out.println("No such element");
                return 0;
            }
            temp = temp.tail;

        }
        temp.tail = temp.head;
        temp = null;
        return temp.key;

    }
    public void addTwo(int item){

    }
    //remove of complexity O(1)
    public int removeTwo(){
        if(this.front == null){
            return 0;
        }
        //Move front reference to previous element
        Node temp = this.front;
        this.front = this.front.tail;

        if(this.front == null){
            this.back = null;
        }

        return temp.key;
    }
        public static void print(PriorityQueue test){
        Node temp = this.front;
        while(this.back != null){
            System.out.println(temp.key);
            temp.tail = temp;
        }

    }
}
