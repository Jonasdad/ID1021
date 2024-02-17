public class stack {
    stack = new LinkedList(item, stack);
    pop:
    if(stack == null){
        throw new exception("pop from empty stack");
    }
    int ret = stack.head;
    stack = stack.tail;
    return ret
    }
}
