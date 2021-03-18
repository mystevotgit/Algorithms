package netflixchallenge.grouptitles;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static List<List<String>> groupTitles(String[] strs){
        if (strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> res = new HashMap<String, List<String>>();

        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()){
                int index = c - 'a';
                count[index]++;
            }

            StringBuilder delimStr = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                delimStr.append('#');
                delimStr.append(count[i]);
            }

            String key = delimStr.toString();
            if (!res.containsKey(key))
                res.put(key, new ArrayList<String>());

            res.get(key).add(s);
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            result.add(new ArrayList<>());
        }
        for (int j = 0; j < 3; j++) {
            List<List<String>> list =  res.values().stream().collect(Collectors.toList());
            if (list.get(j).size() == 3) {
                result.set(0, list.get(j));
            }
            if (list.get(j).size() == 2) {
                result.set(2, list.get(j));
            }
            if (list.get(j).size() == 1) {
                result.set(1, list.get(j));
            }
        }
        System.out.println(result);

        return result;
    }

    public static void main(String[] args) {
        // Driver code
        String titles[] = {"duel","dule","speed","spede","deul","cars"};

        List<List<String>> gt = groupTitles(titles);
        String query = "spede";

        // Searching for all titles
        for (List<String> g : gt){
            if (g.contains(query))
                System.out.println(g);
        }
    }
}
