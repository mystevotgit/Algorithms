package searchengine.reorganizingastring;

import java.util.*;

class Solution {
    public static String reorganize(String str) {
        // write your code here
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            int freq = map.getOrDefault(c, 0) + 1;
            if (freq > (str.length() + 1) / 2)
                return "";
            map.put(c, freq);
        }
        StringBuilder result = new StringBuilder();
        result.append(str);
        for (int i = 1; i < result.length(); ++i) {
            if (result.charAt(i-1) == result.charAt(i)) {
                for (int j = i+1; j < result.length(); ++j) {
                    if (result.charAt(i-1) != result.charAt(j)) {
                        char replacement = result.charAt(j);
                        result.delete(j, j+1);
                        result.insert(i, replacement);
                        break;
                    }
                }
            }
        }
        if (result.toString().equals(str)) {
            char removed = result.charAt(0);
            result.delete(0, 1);
            result.append(removed);
            return reorganize(result.toString());
        }
        return result.toString();
    }
}
