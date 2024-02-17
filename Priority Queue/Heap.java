public class Heap {
        public Heap(){
            Node root;
        }
        Node root = null;
        Node current = root;

    public void add(Integer item){
        //We can only start counting the size once we have a tree :)
        if(current != null){
            this.current.size++;
            System.out.println("Current size: " + current.size);
        }
        //Tree initialization
        if(root == null){
            root = new Node(item);
            current = root;
            System.out.println("Root: " + item);
            return;
        }
        //swap
        if(item < current.value){
            Integer temp = item;
            item = current.value;
            current.value = temp;
            System.out.println(item + " was swapped with " + current.value);
        }
        //Adds node to the left if possible
        if(current.left == null){
            int test = current.value;
            current.left = new Node(item);
            current = root;
            System.out.println(item + " inserted on the left of " +test);
            return;
        }
        //Adds node to the right if possible
        if(current.right == null){
            int test = current.value;
            current.right = new Node(item);
            current = root;
            System.out.println(item + " inserted on the right of " + test);
            return;
        }
        //Moves down which ever branch that has the least amount of nodes
        //if branches are fill and moves along that direction
        if(current.right.size < current.left.size){
            current = current.right;    
            add(item);
        }
        else{
            current = current.left;
            add(item);
        }
        System.out.println("Final Root:" + root.value);
    }

    public Integer remove(){
        if(root == null){
            return null;
        }
    }
}
