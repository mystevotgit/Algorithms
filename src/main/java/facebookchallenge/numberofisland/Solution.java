package facebookchallenge.numberofisland;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    private static int[][] sides = {
            {0,-1},{-1,0},{0,1},{1,0}
    };
    private static int numCircles = 0;     //Number of islands

    public static int numIslands(String[][] islands) {
        // write your code here
        int n = islands.length;
        if (n == 0) {
            return 0;
        }

        Stack<int[]> stack = new Stack<>();

        boolean visited[][] = new boolean[n][islands[0].length];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], false);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < visited[i].length; j++) {
                if (islands[i][j].equals("1") && !visited[i][j]) {
                    int[] pos = {i, j};
                    stack.add(pos);
                    numCircles += DFS(islands, visited, stack); //Recursive step to find all islands
                }
            }
        }

        return numCircles;
    }

    public static int DFS (String[][] islands, boolean[][] visited, Stack<int[]> stack) {
        if (stack.empty()) {
            return 1;
        }
        int[] current = stack.pop();
        System.out.println(current[0] + "     " +  current[1]);
        visited[current[0]][current[1]] = true;
        int[][] adjacentPositions = getAdjacentPositions(current[0], current[1]);
        for (int x = adjacentPositions.length - 1; x >= 0; x--) {
            int[] position = adjacentPositions[x];
            if (position[0] >= 0 && position[1] >= 0 && position[0] < visited.length && position[1] < visited[0].length) {
                if (islands[position[0]][position[1]].equals("1") && !visited[position[0]][position[1]]) {
                    stack.add(position);
                    System.out.println(position[0] + "  " + position[1]);
                }
            }
        }
        return DFS(islands, visited, stack);
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
