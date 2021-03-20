package netflixchallenge.grouptitles;

import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public static List<List<String>> groupTitles(String[] strs){
        if (strs.length == 0)
            return new ArrayList<List<String>>();

        Map<String, List<String>> res = new HashMap<String, List<String>>();
        for (String s : strs) {
            System.out.println(s);
            char[] tempArr = s.toCharArray();
            Arrays.sort(tempArr);
            String str = new String(tempArr);
            System.out.println(str);
            if (res.get(str) == null) {
                res.put(str, new ArrayList<>());
                res.get(str).add(s);
            }else{
                res.get(str).add(s);
            }
        }
        Set<String> keys = res.keySet();
        keys.stream().sorted();
        System.out.println(keys);

        List<List<String>> list =  res.values().stream().collect(Collectors.toList());

        System.out.println(list);

        return list;
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
