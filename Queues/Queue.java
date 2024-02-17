public class Queue {
    Node front;
    Node back;

    public Queue() {
        this.front = null;
        this.back = null;
    }

    //adds item to queue    
    void add(BinaryTree.Node item){
        Node temp = new Node(item);

        //if queue is empty make temp node front of queue
        if(this.back == null){
            this.front = temp;
            this.back = temp;
            return;
        }
        
        //back is from Queue and tail is from Node.
        this.back.tail = temp;
        this.back = temp;
    }

    BinaryTree.Node remove(){
        
        if(this.front == null){
            return null;
        }
        //Move front reference to previous element
        Node temp = this.front;
        this.front = this.front.tail;

        if(this.front == null){
            this.back = null;
        }

        return temp.item;
    }

    boolean empty(){
        if(this.back == null){
            return true;
        }
        return false;


    }


}
