import java.util.Random;
public class Calculator {
    Item[] expr;
    int ip;
    Stack stack;

public Calculator(Item[] expr) {
    this.expr = expr;
    this.ip = 0;
    this.stack = new Stack();
}
public int run() {
    while ( ip < expr.length ) {
    step();
    }
    return stack.pop();
    }

public void step() {
        Item nxt = expr[ip];
        switch(nxt.getType()) {
            case ADD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x + y);
                ip++;
                System.out.println("Result: "+ (x+y));
            break;
            }
            case SUB :{
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x-y);
                ip++;
                System.out.println(x-y);
            break;
            }
            case MUL : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x*y);
                ip++;
                System.out.println(x*y);
            break;
            }
            case DIV : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x/y);
                ip++;
                System.out.println(x/y);
            break;
            }
            case VALUE : {
                stack.push(expr[ip].getValue());
                System.out.println(expr[ip].getValue() + " was pushed to stack");
                ip++;
                run();
            }
            case MOD : {
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x%y);
            }
            case SMUL : {
                int x = stack.pop();
                int temp = 0;
                int smul = x * 2;
                smul = smul % 10;
                temp = smul / 10;
                stack.push(smul + temp); 
                
            }
        }
    }
    public void showStack(int[] StaticStack){
        for(int i = 0; i < StaticStack.length; i++){
            System.out.println(i + "st : Element: " + StaticStack[i]);
        }
    }
    public void stack_test(){
        int k = 1000;
        Random rnd = new Random();
        for(int j = 0; j < k; j++){
        for(int i = 0; i < 6400; i++){
            stack.push(rnd.nextInt());
            }
        for(int i = 0; i < 6400; i++){
            stack.pop();
         }
        }
    }
}