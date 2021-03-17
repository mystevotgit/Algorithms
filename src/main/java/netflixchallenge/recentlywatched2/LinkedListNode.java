package netflixchallenge.recentlywatched2;

class LinkedListNode {
    public int key;
    public int val;
    public int freq;
    public LinkedListNode next;
    public LinkedListNode prev;


    public LinkedListNode(int key, int val, int freq) {
        this.key = key;
        this.val = val;
        this.freq = freq;
        this.next = null;
        this.prev = null;
    }

}
