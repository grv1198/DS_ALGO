package com.grv.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {
	
	
	
	public void printBFS(int v, Graph g) {

		// mark all vertices as non visted

		boolean visited[] = new boolean[g.getV()];
		LinkedList<Integer> q= new LinkedList<Integer>();
		
		
		visited[v]=true;
		q.add(v);
		
		

		while (!q.isEmpty()) {

			v = q.poll();
			System.out.print(v+"==>");
			
			Iterator<Integer> it = g.adj[v].iterator();
			while(it.hasNext()){
				 int n = it.next();
	                if (!visited[n])
	                {
	                    visited[n] = true;
	                    q.add(n);
	                }
				
				
			}
		}
	}

}
