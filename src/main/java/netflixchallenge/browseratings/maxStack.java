package netflixchallenge.browseratings;

public class maxStack {
    int maxSize;
    Stack<Integer> mainStack;
    Stack<Integer> maxStack;
    //constructor
    public maxStack(int maxSize) {
        //We will use two stacks mainStack to hold original values
        //and maxStack to hold maximum values. Top of maxStack will always
        //be the maximum value from mainStack
        this.maxSize = maxSize;
        mainStack = new Stack<>(maxSize);
        maxStack = new Stack<>(maxSize);
    }
    //removes and returns value from stack
    public int pop(){
        //1. Pop element from maxStack to make it sync with mainStack,
        //2. Pop element from mainStack and return that value
        maxStack.pop();
        return mainStack.pop();
    }
    //pushes value into the stack
    public void push(Integer value){
        //1. Push value in mainStack and check value with the top value of maxStack
        //2. If value is greater than top, then push top in maxStack
        //else push value in maxStack
        mainStack.push(value);
        if(!maxStack.isEmpty() && maxStack.top() > value)
            maxStack.push(maxStack.top());
        else
            maxStack.push(value);
    }
    //returns maximum value in O(1)
    public int maxRating(){
        return maxStack.top();
    }
}
