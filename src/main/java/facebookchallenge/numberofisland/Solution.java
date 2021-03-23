package facebookchallenge.numberofisland;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    private static int[][] sides = {
            {0,-1},{-1,0},{0,1},{1,0}
    };

    public static int numIslands(String[][] islands) {
        // write your code here
        int n = islands.length;
        if (n == 0) {
            return 0;
        }

        Stack<int[]> stack = new Stack<>();

        int numCircles = 0;     //Number of islands

        boolean visited[][] = new boolean[n][islands[0].length];
        Arrays.fill(visited, false);

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < visited[i].length; ++j) {
                if (!visited[i][j]) {
                    visited[i][j] = true;
                    DFS(islands, visited, stack, i, j); //Recursive step to find all islands
                    numCircles = numCircles + 1;
                }
            }
        }

        return numCircles;
    }

    public static void DFS (String[][] islands, boolean[][] visited, Stack<int[]> stack, int i, int j) {
        int[][] adjacentPositions = getAdjacentPositions(i, j);
        for (int x = adjacentPositions.length - 1; x >= 0; --x) {
            int[] position = adjacentPositions[x];
            if (position[0] >= 0 && position[1] >= 0) {
                stack.add(position);
            }
        }
        if (stack.empty()) {
            return;
        }
        int[] current = stack.peek();
        if (islands[current[0]][current[1]].equals("1") && !visited[current[0]][current[1]] && i != current[0] && j != current[1]) {
            visited[current[0]][current[1]] = true;
            DFS(islands, visited, stack, current[0], current[1]);
        }
    }

    private static int[][] getAdjacentPositions(int i, int j) {
        int[] top = {sides[0][0] + i, sides[0][1] + j};
        int[] left = {sides[1][0] + i, sides[1][1] + j};
        int[] bottom = {sides[2][0] + i, sides[2][1] + j};
        int[] right = {sides[3][0] + i, sides[3][1] + j};

        int[][] adjacents = {top, left, bottom, right};
        return adjacents;
    }

    public static void main(String args[])
    {
        String[][] islands = {
                {"1","1","0","0","0"},
                {"1","1","0","0","0"},
                {"0","0","1","0","0"},
                {"0","0","0","1","1"}
        };
        System.out.println("Number of islands: " + numIslands(islands));
    }
}
