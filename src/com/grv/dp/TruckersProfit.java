package com.grv.dp;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * PROBLEM : A TRUCK OWNER TRANSPORTS CARGOS. BEFORE STARTING ,
 * HE HAS A LIST OF CARGOS WITH THEIR ID, WEIGHT AND PROFIT  ASSOCIATED.
 *
 * GIVEN A MAZWEIGHT CAPACITY FOR THE TRUCK, FIND THE CARGO ITEMS THAT HE SHOULD PICK FOR MAXIMIZING PROFIT
 *
 * SOLUTION : 0/1 KNAPSACK + PRINT ITEMS INCLUDED
 *
 */
public class TruckersProfit {

    //static List<Integer> result = new ArrayList<>();

    //bottom up dp approach .
    public static List<Integer> getProfit(int maxWt , int wt[], int val[], int n , int[] cargo) {

        List<Integer> result = new ArrayList<>();

        int[][] profit = new int[n+1][maxWt+1];

        for (int i = 0; i <= n; i++) {


            for (int j = 0; j <= maxWt; j++) {


                if (i ==0 || j ==0 ) {

                    profit[i][j] = 0; // no profit with 0 cargo  or zero weight

                } else if ( wt[i-1] > j) {

                    profit[i][j] = profit[i-1][j];
                } else {
                    // include
                    int include = val[i-1] + profit[i-1][j-wt[i-1]];

                    int exclude = profit[i-1][j];

                    if (include > exclude) {
                        profit[i][j] = include;
                        //result.add(i-1);
                    } else {
                        profit[i][j] = exclude;
                    }
                }
            }

        }

        result.add(profit[n][maxWt]);
        //return result;

        int res = profit[n][maxWt];
        int j = maxWt;
        // build list of cargo picked up for max profit
        for (int i = n ; i >0 && res > 0; i--) {

            if(profit[i-1][j] == res) {
             continue;
            }

            else {
                result.add(cargo[i-1]);
                res = res - val[i-1];
                j = j - wt[i-1];
            }
        }

        return result;
    }



    // Driver program to test above function
    public static void main(String args[])
    {
        int val[] = new int[]{500, 1800, 1500};
        int wt[] = new int[]{130, 280, 120};
        int []cargo = new int[]{38, 21, 13};
        int  W = 300;
        int n = val.length;
        System.out.println(getProfit(W, wt, val, n, cargo));
    }
}
