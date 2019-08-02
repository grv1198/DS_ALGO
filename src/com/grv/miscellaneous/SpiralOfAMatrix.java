package com.grv.miscellaneous;

public class SpiralOfAMatrix {
	

    /**
     *
     *
     *  input matrix :
     *
     *  1   2   3   4
     *  5   6   7   8
     *  9   10  11  12
     *  13  14  15  16
     *
     *  Expected output :
     *
     *  1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
     */

    public static void printSpiral(int m, int n, int[][] a) {


        int k = 0; // starting row
        int l = 0; // starting column

        while (k < m && l < n) {


            // loop 1 :
            for (int i = l; i < n; i++) {

                System.out.print(a[k][i] + "  ");

            }
            k++;

            // loop 2:
            for (int i = k; i < m ; i++) {

                System.out.print(a[i][n-1] + "  ");
            }
            n--;


            // loop 3 :

            if (k < m ) { // if k is still less than m

                for (int i = n-1; i >= l; i--) {
                    System.out.print(a[m-1][i] + "  ");
                }
                m--;
            }

            // loop 4 :
            if (l < n) { // if l is still less than n
                for (int i = m-1; i >= k; i--) {
                    System.out.print(a[i][l] + "  ");
                }
                l++;

            }

        }

    }
}
