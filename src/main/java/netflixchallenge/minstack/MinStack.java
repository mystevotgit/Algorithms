package netflixchallenge.minstack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MinStack {
    private int maxSize;
    private PriorityQueue<Integer> stack;

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        this.stack = new PriorityQueue<>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? 1 : -1;
            }
        });
    }
    //removes and returns value from stack
    public Integer pop(){
        // Write -- Your -- Code
        return stack.poll();
    }
    //pushes value into the stack
    public void push(Integer value){
        // Write -- Your -- Code
        stack.add(value);
        return;
    }
    //returns minimum value in O(1)
    public int min(){
        // Write -- Your -- Code
        return stack.peek();
    }
}
