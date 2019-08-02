package com.grv.graph;

import java.util.Iterator;
import java.util.Stack;

public class AlientDictionary {


    /**
     * Input : array of Strings
     *
     * Problem : given array contains words as they would appear in alien dictionary in order.
     *
     * find the alphabet order .
     *
     * SOLUTION :  GRAPH + TOPOLOGICAL SORT .
     *
     * HOW ? GRAPH CONSTRUCTION IS THE MAIN LOGIC.
     *
     * PICK UP TWO ADJACENT WORDS. FIND FIRST SET OF MISMATCH LETTERS. ADD EDGE FROM FIRST TO SECOND.
     * CONTINUE MOVING UNTIL U HAVE VISITED ALL WORDS.
     *
     *Example : words[] = {"baa", "abcd", "abca", "cab", "cad"};
     * output : b, d, a , c
     */

    public static  void printAlienAlphabet(String[] words, int alpha) {

        Graph g= new Graph(alpha);

        int i = 0;

        while(i+1 < words.length) {

            int j = 0;
            String w1 = words[i];
            String w2 = words[i+1];

            while(j < Math.min(w1.length(), w2.length())) {

                if (w1.charAt(j) != w2.charAt(j)) {
                    g.addEdge(w1.charAt(j) - 'a', w2.charAt(j) - 'a');
                    break;
                }
                j++;
            }

            i++;
        }

        topologicalSort(g);
    }

    // MAIN method :
    public static void main(String[] args) {

        String words[] = {"baa", "abcd", "abca", "cab", "cad"};
        printAlienAlphabet(words, 4);

    }

    /**
     * Topological Sort.
     *
     * @param g Graph.
     */
    public static void topologicalSort(Graph g) {

        Stack<Integer> stack = new Stack<>();

        boolean visited[] = new boolean[g.getV()];

        for (int i = 0; i < g.getV(); i++) {

            if (!visited[i]) {
                topologicalSortUtil(i, g, visited, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print((char)('a'+stack.pop()) + ", ");
        }
    }

    public static void topologicalSortUtil(Integer i, Graph g, boolean[] visited, Stack<Integer> stack) {

       visited[i] = true;

        Iterator<Integer> it = g.getAdj()[i].iterator();

        while (it.hasNext()) {
            int current = it.next();

            if (!visited[current]) {
                topologicalSortUtil(current, g, visited, stack);
            }
        }
        stack.push(i);
    }
}
