import java.util.LinkedList;
import java.util.List;

public class MyListQueue {
    private List<Integer> queue;
    private int size;

    public MyListQueue(int size){
        this.size = size;
        queue = new LinkedList<>();
    }
    public void enQueue(int element){
        queue.add(element);
        size++;
    }
    public int pop(){
        int element = queue.get(0);
        queue.remove(0);
        size--;
        return element;
    }
    public int peek(){
        return queue.get(0);
    }
}
