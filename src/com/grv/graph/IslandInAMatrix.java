package com.grv.graph;

public class IslandInAMatrix {

    static int ROW = 0;
    static  int COL = 0;

     public static void main(String []args) {

         int[][] m = {  { 1, 1, 0, 0, 0 },
                        { 0, 1, 0, 0, 1 },
                        { 1, 0, 0, 1, 1 },
                        { 0, 0, 0, 0, 0 },
                        { 1, 0, 1, 0, 1 } };

         System.out.println("Number of islands in the given matrix : ");
         System.out.println(countIslands(m, 5, 5));
     }

     public static void dfs(int[][] m, int r, int c, boolean[][] visited) {

         visited[r][c] = true;

         // recur for 8 neighbours

         if (r >= 0 && r < ROW && c-1>=0 && c-1 < COL && m[r][c-1] == 1 && !visited[r][c-1])
             dfs(m, r, c-1, visited);
         if (r-1 >= 0 && r-1 < ROW && c-1>=0 && c-1 < COL && m[r-1][c-1] == 1 && !visited[r-1][c-1])
             dfs(m, r-1, c-1, visited);
         if (r-1 >= 0 && r-1 < ROW && c >=0 && c < COL && m[r-1][c] == 1 && !visited[r-1][c])
             dfs(m, r-1, c, visited);
         if (r-1 >= 0 && r-1 < ROW && c+1>=0 && c+1 < COL && m[r-1][c+1] == 1 && !visited[r-1][c+1])
             dfs(m, r-1, c+1, visited);
         if (r >= 0 && r < ROW && c+1>=0 && c+1 < COL && m[r][c+1] == 1 && !visited[r][c+1])
             dfs(m, r, c+1, visited);
         if (r+1 >= 0 && r+1 < ROW && c+1>=0 && c+1 < COL && m[r+1][c+1] == 1 && !visited[r+1][c+1])
             dfs(m, r+1, c+1, visited);
         if (r+1 >= 0 && r+1 < ROW && c>=0 && c < COL && m[r+1][c] == 1 && !visited[r+1][c])
             dfs(m, r+1, c, visited);
         if (r+1 >= 0 && r+1 < ROW && c-1>=0 && c-1 < COL && m[r+1][c-1] == 1 && !visited[r+1][c-1])
             dfs(m, r+1, c-1, visited);
     }


     public static int countIslands(int[][] m, int r, int c){

         int count =0;
        ROW = r;
        COL = c;

         boolean[][] visited = new boolean[r][c];
         for (int i = 0; i< r; i++){
             for (int j = 0; j < c; j++) {


                 if (m[i][j] == 1 && !visited[i][j]) {
                     dfs(m, i, j, visited);
                     count++;
                 }
             }
         }

         return count;
     }
}
