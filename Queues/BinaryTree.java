
import java.util.Iterator;

public class BinaryTree implements Iterable<Integer> {
    public class Node {
        public Integer key;
        public Integer value;
        public Node left, right;

        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.left = this.right = null;
        }

        public void print() {
            if (left != null)
                left.print();
            System.out.println(" key: " + key + "\tvalue: " + value);
            if (right != null)
                right.print();
        }

    }

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    Node root;

    public BinaryTree() {
        root = null;
    }

    public class TreeIterator implements Iterator<Integer> {
        private Node next;
        private Queue queue;

        public TreeIterator() {
            queue = new Queue();
            next = root;
            queue.add(next);
        }

        @Override
        public boolean hasNext() {
            if (queue.empty() == true) {
                return false;
            }
            return true;
        }

        @Override
        public Integer next() {
            next = queue.remove();
            
            // are we done yet?
            
            if(next.left != null){
                queue.add(next.left);
            }
            
            if(next.right != null){
                queue.add(next.right);
            }
            
            Integer returnvalue = next.value; // save current node value
            return returnvalue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    void add(Integer key, Integer value) {
        Node next = this.root;

        if (this.root == null) {
            this.root = new Node(key, value);
            return;
        } else {
            while (true) {
                if (next.key > key) {
                    if (next.left == null) {
                        next.left = new Node(key, value);
                        return;
                    }
                    next = next.left;
                }
                if (next.key < key) {
                    if (next.right == null) {
                        next.right = new Node(key, value);
                        return;
                    }
                    next = next.right;
                }
                if (next.key == key) {
                    next.value = value;
                    return;
                }
            }
        }
    }

    Integer lookup(Integer key) {
        Node next = this.root;

        if (this.root == null) {
            return null;
        } else {
            while (true) {
                if (next.key > key) {
                    if (next.left == null) {
                        return null;
                    }
                    next = next.left;
                }
                if (next.key < key) {
                    if (next.right == null) {
                        return null;
                    }
                    next = next.right;
                }
                if (next.key == key) {
                    return next.value;
                }
            }
        }
    }

}
