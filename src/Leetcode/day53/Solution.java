package Leetcode.day53;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int respace(String[] dictionary, String sentence) {
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));
        int n = sentence.length();
        int[] dp = new int[n+1];
        for (int i=1; i<=n; i++) {
            dp[i] = dp[i-1] + 1;
            for (int j=0; j<i; j++) {
                if (set.contains(sentence.substring(j,i))) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[n];
    }
}