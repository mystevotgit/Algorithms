package netflixchallenge.recentlywatched;

import java.util.*;
class LinkedListNode {
    public int key;
    public int data;
    public LinkedListNode next;
    public LinkedListNode arbitrary_pointer;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int key, int data) {
        this.key = key;
        this.data = data;
        this.next = null;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(int data, LinkedListNode next, LinkedListNode arbitrary_pointer) {
        this.data = data;
        this.next = next;
        this.arbitrary_pointer = arbitrary_pointer;
    }
}
