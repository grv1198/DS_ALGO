package com.grv.systemdesignlowlevel.lrucache;

public class TestLRUCache {

    public static void main(String[] args) {


        LRUCache lruCache = new LRUCache(6);

        lruCache.refer(new Integer(1));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(2));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(3));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(4));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(5));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(6));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(7));
        printCache(lruCache.getCache());
        lruCache.refer(new Integer(8));
        printCache(lruCache.getCache());

        lruCache.refer(new Integer(5));
        printCache(lruCache.getCache());

        /**
         * ===============================OUTPUT===========================
         *
         *
         *
         * 1.....
         *
         * 2.....1.....
         *
         * 3.....2.....1.....
         *
         * 4.....3.....2.....1.....
         *
         * 5.....4.....3.....2.....1.....
         *
         * 6.....5.....4.....3.....2.....1.....
         *
         * 7.....6.....5.....4.....3.....2.....
         *
         * 8.....7.....6.....5.....4.....3.....
         *
         * 5.....8.....7.....6.....4.....3.....
         *
         *
         * =====================Process finished with exit code 0=============================
         */

    }


    public static void printCache(DoublyLL node) {

        while (node != null) {
            System.out.print(node.getData() + ".....");
            node = node.getNext();
        }

        System.out.println();
        System.out.println();
    }
}
