package searchengine.wordsearch2;

import java.util.*;

class Solution {
    public static String[]breaks(String s, String[] subs) {
        Set<String> subsSet = new HashSet<>(Arrays.asList(subs));
        List<String> res = helper(s, subsSet, new HashMap<String, LinkedList<String>>());
        return res.toArray(new String[res.size()]);
    }

    // helper function returns an array including all substrings derived from s.
    public static List<String> helper(String s, Set<String> subsSet, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : subsSet) {
            if (s.startsWith(word)) {
                List<String>sublist = helper(s.substring(word.length()), subsSet, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
    public static void main( String args[] ) {
        String s = "vegancookbook";
        String[] subs = {"an", "book", "car", "cat", "cook", "cookbook", "crash",
                "cream", "high", "highway", "i", "ice", "icecream", "low",
                "scream", "veg", "vegan", "way"};

        System.out.println(Arrays.toString(breaks(s, subs)));
        s = "highwaycarcrash";
        System.out.println(Arrays.toString(breaks(s, subs)));

        s = "magiclly";
        String[] newsubs = {"ag", "al", "icl", "mag", "magic", "ly", "lly"};
        System.out.println(Arrays.toString(breaks(s, newsubs)));
    }
}