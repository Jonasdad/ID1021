import java.util.*;
public class Item {
    private ItemType type;
    private int value = 0;

    public int getValue(){
        return this.value;
    }
    public ItemType getType(){
        return this.type;
    }
    public void setValue(int value){
        this.value = value;
    }
    public void setType(ItemType type){
        this.type = type;
    }
    }