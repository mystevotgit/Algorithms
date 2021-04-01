package searchengine.exclusivetimeoffunction;

import java.util.Stack;

class Solution {
    public static int[] exclusiveTime(int n, String[] logs) {
        // write your code here
        Stack<Integer> stack = new Stack<Integer>();
        int[] servTimes = new int[n];
        String[] func = logs[0].split(":");
        stack.push(Integer.parseInt(func[0]));
        int time = Integer.parseInt(func[2]);
        for (int i = 0; i < logs.length; i++){
            func = logs[i].split(":");
            if(func[1].indexOf("start") != -1){
                if(stack != null)
                    servTimes[stack.peek()] += Integer.parseInt(func[2]) - time;
                stack.push(Integer.parseInt(func[0]));
                time = Integer.parseInt(func[2]);
            }

            else{
                servTimes[stack.peek()] += Integer.parseInt(func[2]) - time + 1;
                stack.pop();
                time = Integer.parseInt(func[2]) + 1;
            }

        }

        return servTimes;
    }
}
