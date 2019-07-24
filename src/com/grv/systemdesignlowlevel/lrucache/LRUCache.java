package com.grv.systemdesignlowlevel.lrucache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    /**
     * For simplicity the key is integer and value in cache is also an integer.
     * In real time this is a string to string/object mapping.
     */
    private Map<Integer, DoublyLL> refMap;

    private  DoublyLL cache;

    private int cacheSize;

    private int currentSize;

    private DoublyLL head;

    private DoublyLL last;

    // INITIALIZE THE INTENDED CACHE SIZE
    public LRUCache(int cacheSize) {
        this.cacheSize = cacheSize;
        refMap = new HashMap<>();
    }

    public Map<Integer, DoublyLL> getRefMap() {
        return refMap;
    }

    public void setRefMap(Map<Integer, DoublyLL> refMap) {
        this.refMap = refMap;
    }

    public DoublyLL getCache() {
        return cache;
    }

    public void setCache(DoublyLL cache) {
        this.cache = cache;
    }

    public int getCacheSize() {
        return cacheSize;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCurrentSize(int currentSize) {
        this.currentSize = currentSize;
    }

    public DoublyLL getHead() {
        return head;
    }

    public void setHead(DoublyLL head) {
        this.head = head;
    }

    public DoublyLL getLast() {
        return last;
    }

    public void setLast(DoublyLL last) {
        this.last = last;
    }

    // O(1)
    public void refer(Integer x) {

        if (currentSize == 0) {
            head = new DoublyLL(x);
            last = head;
            cache = head;
            refMap.put(x, head);
            currentSize++;
            return;
        }

        if (!refMap.containsKey(x) && currentSize == cacheSize) {
            // cache full
            // remove last
            refMap.remove(last.getData());
            this.remove(last);
            last = last.getPrev();
            last.setNext(null);
        } else if (refMap.containsKey(x)) {
            this.remove(refMap.get(x));
        }

        DoublyLL node = new DoublyLL(x);

        node.setNext(head);
        head.setPrev(node);
        head = node;
        refMap.put(x, head);
        cache = head;
        currentSize++;
    }

    // O(1)
    public void remove(DoublyLL element) {

        DoublyLL prev = element.getPrev();

        if (prev!= null) {
            prev.setNext(element.getNext());
            currentSize--;

        } else {
            cache = null;
            currentSize = 0;
        }
    }

    // O(1)
    public Integer fetch(Integer x) {
        return refMap.containsKey(x) ? refMap.get(x).getData() : null;
    }

}
