package netflixchallenge.verifyusersession;

import java.util.*;

class Solution {
    public static boolean verifySession(int[] pushOp, int[] popOp) {

        int M = pushOp.length;
        int N = popOp.length;
        if (M != N)
            return false;

        Stack<Integer> stack = new Stack<Integer>();

        int i = 0;
        for (int pid: pushOp) {
            stack.push(pid);
            while (!stack.isEmpty() && stack.peek() == popOp[i]) {
                stack.pop();
                i++;
            }
        }

        if (stack.isEmpty())
            return true;
        return false;
    }

    public static void main( String args[] ) {
        // Driver code
        int[] pushOp = {1,2,3,4,5};
        int[] popOp = {5,4,3,2,1};

        if (verifySession(pushOp, popOp) == true)
            System.out.println( "Session Successfull!" );
        else
            System.out.println( "Session Faulty!" );
    }
}
