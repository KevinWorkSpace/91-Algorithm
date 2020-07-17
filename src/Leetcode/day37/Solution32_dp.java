package Leetcode.day37;

import java.util.Arrays;

public class Solution32_dp {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int ans = 0;
        for (int i=0; i<dp.length; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            }
            else {
                if (i-1 >= 0) {
                    if (i - dp[i-1] - 1 >= 0 && s.charAt(i - dp[i-1] - 1) == '(') {
                        dp[i] = dp[i-1] + 2;
                        if (i - dp[i-1] - 2 >= 0) {
                            dp[i] += dp[i - dp[i-1] - 2];
                        }
                    }
                }
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution32_dp solution32_dp = new Solution32_dp();
        String s = "()()))))()()(";
        int ans = solution32_dp.longestValidParentheses(s);
        System.out.println(ans);
    }
}
