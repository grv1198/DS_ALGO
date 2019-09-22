package com.grv.graph;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * PROBLEM STATEMENT :
 *
 * A bot starts from 0,0 and can move in directions right left up or bottom only if the next cell is flat( that is value = 1
 * if the next cell value is 0 it cant go in there.
 * the obstacle is in the cell where value =9
 *
 *
 * find the min distance the bot needs to cover to get to and clear the obstacle
 *
 * Example : [[1, 0, 0]
 *            [1, 0, 0]
 *            [1, 9, 1]]
 *
 *            op = 3
 *
 *            if no path is possible print -1.
 *
 */
public class BotCleaningObstacles {


    static boolean found = false;
    static int rows = 0;
    static int columns = 0;
    static  int minPathSum = Integer.MAX_VALUE;

    public static void main(String[] args) {

        List<List<Integer>> plot = new ArrayList<>();

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();

        l1.add(0, 1);
        l1.add(1, 1);
        l1.add(2, 1);

        l2.add(0, 1);
        l2.add(1, 1);
        l2.add(2, 1);

        l3.add(0, 1);
        l3.add(1, 9);
        l3.add(2, 1);

        plot.add(0,l1);
        plot.add(1,l2);
        plot.add(2,l3);

        System.out.print(removeObstacle(3, 3, plot));
    }


    // METHOD SIGNATURE BEGINS
    static int removeObstacle(int numRows, int numColumns, List<List<Integer>> plot)
    {

        // numrows == plot.size() && numColums == plot.get(i).size : expected a square plot argument or argument mismatch

        // WRITE YOUR CODE HERE
        found = false;
        rows = numRows;
        columns = numColumns;
        boolean visited[][] = new boolean[numRows][numColumns];

        removeObstacleUtil(0,0, plot, visited, 0);

        if(found == true) {
            return minPathSum;
        } else {
            return -1;
        }

    }
    // METHOD SIGNATURE ENDS


    static void removeObstacleUtil(int i, int j, List<List<Integer>> plot, boolean visited[][],  int pathsum) {

        if (plot.get(i).get(j) == 9) {
            // no need to traverse further.
            if (pathsum < minPathSum) {
                found = true;
                minPathSum = pathsum;
            }
            return;
        }


        visited[i][j] = true;
        pathsum++;

        // recur in all possible next cells.

        // i+1, j.
        if (i+1 < rows && plot.get(i+1).get(j) != 0 && !visited[i+1][j]){
            removeObstacleUtil(i+1, j, plot, visited, pathsum);
        }

        // i-1, j.
        if (i > 0 && plot.get(i-1).get(j) != 0 && !visited[i-1][j]){
            removeObstacleUtil(i-1, j, plot, visited, pathsum);
        }

        // i, j+1.
        if (j+1 < columns && plot.get(i).get(j+1) != 0 && !visited[i][j+1]){
            removeObstacleUtil(i, j+1, plot, visited, pathsum);
        }

        // i, j-1.
        if (j > 0 && plot.get(i).get(j-1) != 0 && !visited[i][j-1]){
            removeObstacleUtil(i, j-1, plot, visited, pathsum);
        }
    }

}
