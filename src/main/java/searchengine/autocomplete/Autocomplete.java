package searchengine.autocomplete;

import java.util.*;

class Node implements Comparable<Node>{
    public HashMap<Character, Node> children;
    public boolean isEnd;
    public String data;
    int rank;
    public List<Node> hot;

    public Node(){
        this.children = new HashMap<Character, Node>();
        this.isEnd = false;
        this.rank = 0;
        hot = new ArrayList<>();
    }

    public int compareTo(Node n){
        if(this.rank == n.rank)
            return this.data.compareTo(n.data);
        return n.rank - this.rank;
    }

    public void update(Node n){
        if(!this.hot.contains(n)){
            this.hot.add(n);
        }
        Collections.sort(hot);
        if (hot.size() > 3) {
            hot.remove(hot.size() - 1);
        }
    }
}

class AutocompleteSystem{

    private Node root;
    private Node current;
    private String keyword;


    public AutocompleteSystem(String[] sentences, int[] times){
        this.root = new Node();
        this.current = root;
        this.keyword = "";

        for (int i = 0; i < sentences.length; i++){
            this.addRecord(sentences[i], times[i]);
        }
    }

    public void addRecord(String sentence, int t){
        Node node = this.root;
        List<Node> visited = new ArrayList<>();
        for (Character c:  sentence.toCharArray()){
            if (!node.children.containsKey(c))
                node.children.put(c, new Node());
            node = node.children.get(c);
            visited.add(node);
        }
        node.isEnd = true;
        node.data = sentence;
        node.rank += t;

        for (Node i: visited){
            i.update(node);
        }
    }

    public String[] autoComplete(char c){
        List<String> res = new ArrayList<>();
        if (c == '#') {
            addRecord(keyword, 1);
            keyword = "";
            current = root;
            return new String[]{};
        }

        this.keyword += c;
        if (current != null) {
            if (!current.children.containsKey(c))
                return new String[]{};
            else
                current = current.children.get(c);
        }
        else
            return new String[]{};

        for (Node node : current.hot) {
            res.add(node.data);
        }
        return res.toArray(new String[res.size()]);
    }
}
class Solution {
    public static void main( String args[] ) {
        String[] sentences = {"beautiful", "best quotes", "best friend", "best birthday wishes", "instagram", "internet"};
        int[] times = {30, 14, 21, 10, 10, 15};
        AutocompleteSystem auto = new AutocompleteSystem(sentences, times);
        System.out.println(Arrays.toString(auto.autoComplete('b')));
        System.out.println(Arrays.toString(auto.autoComplete('e')));
        System.out.println(Arrays.toString(auto.autoComplete('s')));
        System.out.println(Arrays.toString(auto.autoComplete('t')));
        System.out.println(Arrays.toString(auto.autoComplete('#')));
    }
}