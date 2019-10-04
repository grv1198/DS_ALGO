package com.grv.dp;

/**
 * https://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 */
public class MaxSquareSubMatrixWithAllOnes {



    public static int maxSubMatrix(int[][] arr) {

        int r = arr.length;
        int c = r > 0 ? arr[0].length : 0;

        int[][] dp = new int[r+1][c+1];

        int max = 0;
        for (int i = 1; i <= r; i++) {
            for (int j = 1; j <=c; j++) {

                if (arr[i-1][j-1] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) +1;

                    if (max < dp[i][j]) {
                        max = dp[i][j];
                    }
                }

            }
        }

        return max*max;
    }


    // driver :

    public static void main(String[] args) {


        int[][] arr = {{0,0,0,0,0},
                        {0,1,1,1,0},
                        {0,1,1,1,0},
                        {0,1,1,1,0}};

        System.out.print(maxSubMatrix(arr));
    }

}
