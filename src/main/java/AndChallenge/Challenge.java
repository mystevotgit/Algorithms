package AndChallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Challenge {
    public static int countHighlyProfitableMonths(List<Integer> stockPrices, int k) {
        int count = 0;
        for (int i = 0; i < stockPrices.size(); i++) {
            if (i + 2 < stockPrices.size()) {
                boolean check = true;
                for (int j = i; j < i + k - 1; j++) {
                    if (!(stockPrices.get(j) < stockPrices.get(j + 1))) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(countHighlyProfitableMonths(Arrays.asList(1, 2, 3, 3, 4, 5), 3));
//        System.out.println(moves(Arrays.asList(5, 8, 5, 11, 4, 6)));
//        System.out.println(minimizedCost(Arrays.asList(1, 1), Arrays.asList(1, 3), Arrays.asList(1, 1)));
//        System.out.println(getSubsequenceCount("ABC", "ABCBABC"));
//        System.out.println(pointsBelong(3, 1, 7, 1, 5, 5, 1, 1, 4, 3));
//        System.out.println(pointsBelong(3, 1, 7, 1, 5, 5, 3, 1, 0, 3));
        System.out.println(solution("ONLABLABLOON")); // BALLOON

    }

//    class Solution {
    static int solution(String S) {
        // write your code in Java SE 8
        Map<String, Double> map = new HashMap<>();
        map.put("B", 0.0);
        map.put("A", 0.0);
        map.put("L", 0.0);
        map.put("O", 0.0);
        map.put("N", 0.0);
        for (int i = 0; i < S.length(); i++) {
            switch(S.charAt(i)) {
                case 'B':
                    map.put("B", map.get("B") + 1);
                    break;
                case 'A':
                    map.put("A", map.get("A") + 1);
                    break;
                case 'L':
                    map.put("L", map.get("L") + 0.5);
                    break;
                case 'O':
                    map.put("O", map.get("O") + 0.5);
                    break;
                case 'N':
                    map.put("N", map.get("N") + 1);
                    break;
            }
        }
        System.out.println(map);
        System.out.println(map.values());
        final double[] min = {10000000000.0};
        map.values().forEach(val -> {
            min[0] = Math.min(val, min[0]);
        });
        return (int) min[0];
    }
//    }

    public static int pointsBelong(int x1, int y1, int x2, int y2, int x3, int y3, int xp, int yp, int xq, int yq) {

        double base = x2 - x1;
        double side1 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y3 - y2, 2));
        double side2 = Math.sqrt(Math.pow(x3 - x1, 2) + Math.pow(y3 - y1, 2));
        if (!(base + side1 > side2 && side1 + side2 > base && base + side2 > side1)) {
            return 0;
        }

        if (isInTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && !isInTriangle(x1, y1, x2, y2, x3, y3, xq, yq)) {
            return 1;
        }
        if (!isInTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && isInTriangle(x1, y1, x2, y2, x3, y3, xq, yq)) {
            return 2;
        }
        if (isInTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && isInTriangle(x1, y1, x2, y2, x3, y3, xq, yq)) {
            return 3;
        }
        if (!isInTriangle(x1, y1, x2, y2, x3, y3, xp, yp) && !isInTriangle(x1, y1, x2, y2, x3, y3, xq, yq)) {
            return 4;
        }
        return 0;
    }


    public static double getArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        return Math.abs((x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2.0);
    }

    public static boolean isInTriangle(int x1, int y1, int x2, int y2, int x3, int y3, int x, int y) {
        double area = getArea(x1, y1, x2, y2, x3, y3);

        double area1 = getArea(x, y, x2, y2, x3, y3);

        double area2 = getArea(x1, y1, x, y, x3, y3);

        double area3 = getArea(x1, y1, x2, y2, x, y);

        return (area == area1 + area2 + area3);
    }

    public static long getSubsequenceCount(String s1, String s2) {
        System.out.println("init");
        return count(s2, s1, s2.length(), s1.length());
    }

    public static int count(String longString, String subString, int longStringCount, int subStringCount) {
        // Base case 1: if only one character is left
        if (longStringCount == 1 && subStringCount == 1) {
            return (longString.charAt(0) == subString.charAt(0)) ? 1 : 0;
        }

        // Base case 2: if the input string `X` reaches its end
        if (longStringCount == 0) {
            return 0;
        }

        // Base case 3: if pattern `Y` reaches its end, we have found
        // subsequence
        if (subStringCount == 0) {
            return 1;
        }

        // Optimization: the solution is not possible if the number of characters
        // in the string is less than the number of characters in the pattern
        if (subStringCount > longStringCount) {
            return 0;
        }

        /*
          If the last character of both string and pattern matches,
            1. Exclude the last character from both string and pattern
            2. Exclude only the last character from the string.

          Otherwise, if the last character of the string and pattern do not match,
          recur by excluding only the last character in the string
        */

        return ((longString.charAt(longStringCount - 1) == subString.charAt(subStringCount - 1)) ? count(longString, subString, longStringCount - 1, subStringCount - 1) : 0)
                + count(longString, subString, longStringCount - 1, subStringCount);
    }


    public static int moves(List<Integer> arr) {
        int even = 0;
        int odd = 0;
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        return swap(arr, even, odd);
    }

    public static int swap(List<Integer> list, int even, int odd) {
        int count = 0;
        if (even <= odd) {
            for (int i = 0; i < even; i++) {
                if (list.get(i) % 2 == 0) {
                    count++;
                }
            }
            return even - count;
        }
        for (int i = list.size() - 1; i > list.size() - odd; i--) {
            if (list.get(i) % 2 == 0) {
                count++;
            }
        }
        return odd - count;
    }

//    public static int check (List<Integer> list) {
//        int count = 0;
//        int val = list.get(0);
//        for (int i = 1; i < list.size(); i++) {
//            if (Math.abs(val - list.get(i)) == 1 && list.get(0) % 2 == 0) {
//                count++;
//            }
//        }
//        return count;
//    }

    public static int minimizedCost(List<Integer> numPeople, List<Integer> x, List<Integer> y) {
        List<Integer> xx = new ArrayList<>();
        List<Integer> yy = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < numPeople.size(); i++) {
            int count = numPeople.get(i);
            while (count > 0) {
                xx.add(x.get(i));
            }
        }
        return cost(1, 1, 1, 1);
    }

    public static int cost(int x, int y, int a, int b) {
        return (Math.abs(x - a) + Math.abs(y - b));
    }
}
