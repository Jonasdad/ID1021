import java.util.*;

public class Stack {
    int StackSize = 4;
    int[] DynamicStack = new int[StackSize];
    int StackPointer = 0;

    public void push(int integer){
        if(isFull()){
            System.out.println("Stack Full. Stack allocation doubled.");
            Expand(DynamicStack);
            this.DynamicStack[StackPointer] = integer;
            StackPointer++;
        }
        else{
            this.DynamicStack[StackPointer] = integer;
            StackPointer++;
        }
    }

    public int pop(){
        if(TooEmpty() == false){
            StackPointer--;
            if(StackPointer >= 0){
            int popped = this.DynamicStack[StackPointer];
            return popped;
            }
            else{
                StackPointer++;
                System.out.println("End of Computation");
                return 0;
            }
        }
        else{
            Decrease(DynamicStack);
            StackPointer--;
            if(StackPointer >= 0){
                int popped = this.DynamicStack[StackPointer];
                return popped;
            }
            else{
                return 0;
            }
        }
    }

    public boolean isFull(){
        if(StackPointer == (StackSize - 1)){
            return true;
        }
        return false;
    }

    public boolean TooEmpty(){
        if(StackPointer + 4 == StackSize){
            return true;
        }
        return false;
    }
    
    public void Expand(int[]DynamicStack){
        if(isFull()){
            int[] BiggerStack = new int[StackSize*2];
            for(int i = 0; i < DynamicStack.length; i++){
                BiggerStack[i] = this.DynamicStack[i];
            }
            StackSize *= 2;
            this.DynamicStack = BiggerStack;
        }
    }
    public void Decrease(int[] DynamicStack){

        int[] SmallerStack = new int[StackSize - 2];
        for(int i = 0; i < SmallerStack.length; i++){
            SmallerStack[i] = this.DynamicStack[i];
        }
        StackSize -= 2;
        this.DynamicStack = SmallerStack;
        System.out.println("Stack too empty, deallocating memory");
    }
    
 }


