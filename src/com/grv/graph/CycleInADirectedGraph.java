package com.grv.graph;

import java.util.Iterator;


public class CycleInADirectedGraph {



    public  static boolean isCyclicUtil(Integer v, boolean[] visited, boolean[] recStackVisited, Graph g) {

        if (recStackVisited[v]) {
            //  same vertex visited twice in current dfs, cycle exists
            return true;
        }

        if (!visited[v]) {// if dfs has not been done for this vertex

            recStackVisited[v] = true;
            visited[v] = true;

            Iterator<Integer> it= g.adj[v].iterator();

            while(it.hasNext()){

                Integer c = it.next();
                if (isCyclicUtil(c, visited, recStackVisited, g)) {
                    return true;
                }
            }

        }

        recStackVisited[v] = false;
        return false;

    }


    public  static boolean isCyclic(Graph g){

        boolean visited[] = new boolean[g.getV()];
        boolean recStackVisited[] = new boolean[g.getV()];

        for (int i = 0; i < g.getV(); i++)
            if (isCyclicUtil(i, visited, recStackVisited, g))
                return true;

        return false;

    }
}
