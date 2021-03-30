package searchengine.wordsearch;

import java.util.Arrays;
import java.util.HashMap;

class Node {
    public HashMap<Character, Node> children;
    public boolean isWord;

    public Node(){
        this.children = new HashMap<Character, Node>();
        this.isWord = false;
    }
}

class WordDictionary {
    private Node root;
    public WordDictionary(){
        this.root = new Node();
    }

    public void insertWord(String word){
        Node node = this.root;
        for (Character c:  word.toCharArray()){
            if (!node.children.containsKey(c))
                node.children.put(c, new Node());
            node = node.children.get(c);
        }
        node.isWord = true;
    }

    public boolean searchWord(String word){
        Node node = this.root;
        for (Character c:  word.toCharArray()){
            if (!node.children.containsKey(c))
                return false;
            node = node.children.get(c);
        }
        return node.isWord;
    }
}
class Solution {
    public static void main( String args[] ) {
        System.out.println( "Hello World!" );
        String[] keys = {"the", "a", "there", "answer", "any",
                "by", "bye", "their", "abc"};
        System.out.println("Keys to insert: ");
        System.out.println(Arrays.toString(keys));

        WordDictionary d = new WordDictionary();

        for(int i=0; i < keys.length; i++)
            d.insertWord(keys[i]);

        System.out.println("Searching 'there' in the dictionary results: " + d.searchWord("there"));
    }
}
