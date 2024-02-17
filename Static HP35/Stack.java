import java.util.Random;

public class Stack {
    final int StackSize = 100;
    int[] StaticStack = new int[StackSize];
    int StackPointer = 0;

    public void push(int integer){
        if(StackPointer <= (StackSize - 1)){
            this.StaticStack[StackPointer] = integer;
            StackPointer++;
        }
        else{
            System.out.println("Stack Overflow. Pointer value: " + StackPointer);
        }
    }

    public int pop(){
        StackPointer--;
        if(StackPointer >= 0){
            int popped = this.StaticStack[StackPointer];
            return popped;
        }
        else{
            StackPointer++;
            return StaticStack[StackPointer];
        }
    }
}
