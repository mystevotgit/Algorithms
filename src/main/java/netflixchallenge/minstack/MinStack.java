package netflixchallenge.minstack;

import java.util.*;

public class MinStack {
    private int maxSize;
    private List<Integer> stack;
    private PriorityQueue<Integer> priorityQueue;

    //constructor
    public MinStack(int maxSize) {
        // Write -- Your -- Code
        this.maxSize = maxSize;
        this.stack = new ArrayList<>();
        this.priorityQueue = new PriorityQueue<>(maxSize, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
    }
    //removes and returns value from stack
    public Integer pop(){
        // Write -- Your -- Code
        int removed = stack.remove(stack.size()-1);
        Iterator it = priorityQueue.iterator();
        if (it.hasNext()) {
            priorityQueue.remove(removed);
        }
        return removed;
    }
    //pushes value into the stack
    public void push(Integer value){
        // Write -- Your -- Code
        if (priorityQueue.size() < maxSize) {
            stack.add(value);
            priorityQueue.add(value);
        }
        return;
    }
    //returns minimum value in O(1)
    public int min(){
        // Write -- Your -- Code
        System.out.println(priorityQueue.peek() + " is the min value\n");
        if (!priorityQueue.isEmpty()) {
            return priorityQueue.peek();
        }else {
            return stack.get(stack.size()-1);
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack(4);
        minStack.push(2);
        minStack.push(1);
        minStack.push(1);
        minStack.push(10);
        minStack.push(5);


        Iterator iterator = minStack.priorityQueue.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(minStack.stack.toString());

        System.out.println(minStack.pop() + " is the poped value\n");
        System.out.println(minStack.pop() + " is the poped value\n");

        Iterator it = minStack.priorityQueue.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println(minStack.stack.toString());

        minStack.min();
    }

//    public static boolean validateStackSequences(int[] pushed, int[] popped) {
//        // write your code here
//        Set<Integer> hashSet = new HashSet<>();
////        hashSet.addAll(Arrays.asList(popped));
//        if (pushed.length == popped.length && hashSet.size() == pushed.length){
//            return true;
//        }
//
//        return false;
//    }
}

