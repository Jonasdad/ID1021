public class QueueArray {
    Integer[] Queue;
    Integer QueueLength;
    Integer i = 0; //front
    Integer k = 0; //back = n - 1;
    //constructor
    public QueueArray(Integer QueueLength){
        this.Queue = new Integer[QueueLength];
        this.QueueLength = QueueLength;
        this.k = 0;
        this.i = 0;
    }
    
    public void add(int item){
            Queue[k] = item;
            k++;

            if(k == QueueLength){ //Have we wrapped?
                k = 0;
            }

            if(i == k){
                Integer[] Larger = new Integer[QueueLength*2];
                int temp = 0;
            //Wrap around
                for(int j = 0; j < QueueLength; j++){
            //Copy array start value into beginning of larger array
                    if(i + j <= QueueLength){    
                        Larger[j] = Queue[i+j];
                    }
            //Copy the rest wrapped values sequentially
                    else{
                        Larger[j] = Queue[temp];
                        temp++;
                    }
                k = i+j;//Let end be end of QueueLength 
                i = 0;//Set start pointer to beginning of new array
            }
                Queue = Larger; //Change reference
            }
            System.out.println(item + " was added to the queue");
        }
    //This works
    public void remove(){
        if(i == k){ //if we're at the end of queue
            return;
        }
        else{
            Queue[i] = null;
            i++;
            if(i == QueueLength - 1){
                i = 0;
            }
        }
    }

    //This works
    public boolean isEmpty(){
        if(i == k){
            return true;
        }
        return false;
        }
    }
