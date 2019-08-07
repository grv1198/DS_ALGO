package com.grv.dp;

public class LongestPallindromicSubstring {

    // O(n2) time, o(1) space.
    public String longestPalindrome(String s) {


        int start = 0;
        int len = s.length();
        if (len == 0|| len == 1) return s;

        int low;
        int high;
        int maxPLength = 0;

        for (int i = 1; i < len; i++) {


            low = i-1;
            high = i;


            while ( low >=0 && high < len && s.charAt(low) == s.charAt(high)) {



                if (high - low +1 > maxPLength) {
                    start = low;
                    maxPLength = high -low +1;
                }

                low --;
                high ++;
            }


            low = i-1;
            high = i+1;


            while ( low >=0 && high < len && s.charAt(low) == s.charAt(high)) {

                if (high - low +1 > maxPLength) {
                    start = low;
                    maxPLength = high -low +1;
                }

                low --;
                high ++;
            }
        }

        if (maxPLength == 0) {
            return s.substring(start, start+1);
        }
        return s.substring(start, start+maxPLength);
    }

}
