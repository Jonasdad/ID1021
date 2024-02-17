public class ListofItems {
    Node front;
    Node current;
    public class Node{
        Integer value;
        Node right;

        public Node(Integer value){
            this.value = value;
            this.right = null;
        }
    }
    //adds an element in O(1)
    public void add1(Integer item){
        Node newNode = new Node(item);
        current = front;
        if(front == null){
            front = newNode;
        }
        else{
            newNode.right = front;
            front = newNode;
            current = front;
        }
    }
    //removes smallest item in O(n)
    public void removeN(){
        if(front == null){
            return;
        }
        Node smallest = front;
        Node previous = front;
        current = front;
        while(current.right != null){
            if(current.right.value < smallest.value){
                smallest = current.right;
                previous = current;
            }
            current = current.right;
        }
        if(smallest == front){
            front = front.right;
        }
        else{
            previous.right = previous.right.right;
        }
        }
    
    //adds an item in the list in ascending order O(N)
    public void addN(Integer item){
        Node newNode = new Node(item);
        current = front;
        //first node
        if(front == null){
            front = newNode;
            return;
        }
        //places node infront of first value as it is smaller than first
        if(item < front.value){
            newNode.right = front;
            front = newNode;
            return;
        }
        while(current.right != null){
            if(current.right.value > item && current.right.value >= item){ //evil bit hack
                newNode.right = current.right.right;
                current.right = newNode;
                return;
            }
            else{
                current = current.right;
            }
        }
        //if we reach this point, the node should be last
        if(current.right == null){
            current.right = newNode;
            return;
        }

    }
    //removes the first node in the list O(1)
    public void remove1(){
        Node removed = front;
        if(front == null){
            return;
        }
        front = front.right;
        current = front;
        return;
    }

    // public void printList(){
    //   current = front;
    // while(current.right != null){
    //   System.out.print(current.value + ", ");
    // current = current.right;
    //}
    //System.out.println();
    //}

}
