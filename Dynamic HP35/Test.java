import java.util.Random;
public class Test {
    public static void main(String args[]){
        Item ADD = new Item();
        Item SUB = new Item();
        Item MUL = new Item();
        Item DIV = new Item();
        Item VALUE1 = new Item();
        Item VALUE2 = new Item();

        ADD.setType(ItemType.ADD);
        SUB.setType(ItemType.SUB);
        MUL.setType(ItemType.MUL);
        DIV.setType(ItemType.DIV);

        VALUE1.setType(ItemType.VALUE);
        VALUE2.setType(ItemType.VALUE);

        VALUE1.setValue(3);
        VALUE2.setValue(4);

        final Item[] expr = {VALUE1, VALUE2, ADD, VALUE1, VALUE2, ADD, VALUE1, VALUE2, ADD, VALUE1, VALUE2, ADD, VALUE1, VALUE2, ADD, ADD, ADD, ADD, ADD};
        Calculator test = new Calculator(expr);
        //test.run();
        long t0 = System.nanoTime();
        test.stack_test();
        System.out.println("Dynamic Stack Runtime " + ((System.nanoTime() - t0)/((double)1000000000)) + "s");
        
    }
}
