package netflixchallenge.recentlywatched;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.ListIterator;

public class LRUCache {
    int capacity;
    HashMap<Integer, LinkedListNode> cache;
    LinkedList<LinkedListNode> cacheVals;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<Integer, LinkedListNode>(capacity);
        cacheVals = new LinkedList<LinkedListNode>();
    }

    LinkedListNode Get(int key) {
        if(!cache.containsKey(key)){
            return null;
        }
        else {
            int value = cache.get(key).data;
            cacheVals.remove(cache.get(key));
            LinkedListNode node = new LinkedListNode(key, value);
            cacheVals.addLast(node);
            return node;
        }
    }

    void Set(int key, int value) {
        if (!cache.containsKey(key)){
            evictIfNeeded();
            LinkedListNode newNode = new LinkedListNode(key, value);
            cacheVals.addLast(newNode);
            cache.put(key, newNode);
        }
        else {
            cacheVals.remove(cache.get(key));
            LinkedListNode newNode = new LinkedListNode(key, value);
            cacheVals.addLast(newNode);
            cache.put(key, newNode);
        }
    }

    void evictIfNeeded(){
        if(cacheVals.size() >= capacity) {
            LinkedListNode node = cacheVals.remove();
            cache.remove(node.key);
        }
    }

    void print() {
        ListIterator<LinkedListNode> iterator = cacheVals.listIterator(0);
        while(iterator.hasNext()){
            LinkedListNode node = iterator.next();
            System.out.print("(" + node.key + "," + node.data + ")");
        }
        System.out.println("");
    }
}
