package Leetcode.day52;

public class Solution2 {

    public int findTheLongestSubstring(String s) {
        int len = s.length();
        int[][] preSum = new int[len+1][5];
        for (int i=1; i<s.length()+1; i++) {
            char c = s.charAt(i-1);
            int idx = check(c);
            for (int j=0; j<5; j++) {
                if (j == idx) preSum[i][j] = preSum[i-1][j] + 1;
                else preSum[i][j] = preSum[i-1][j];
            }
        }
        for (int i=len; i>=1; i--) {
            for (int j=0; j<len+1; j++) {
                if (j + i > len) break;
                if (isValid(preSum[j], preSum[j+i])) {
                    return i;
                }
            }
        }
        return 0;
    }

    public int check(char c) {
        if (c == 'a') return 0;
        else if (c == 'e') return 1;
        else if (c == 'i') return 2;
        else if (c == 'o') return 3;
        else if (c == 'u') return 4;
        else return -1;
    }

    public boolean isValid(int[] c1, int[] c2) {
        for (int i=0; i<5; i++) {
            if ((c1[i] - c2[i]) % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        Solution2 solution2 = new Solution2();
        int a = solution2.findTheLongestSubstring(s);
        System.out.println(a);

        String s2 = "bcbcbc";
        String s3 = "leetcodeisgreat";
        String s4 = "eleetminicoworoep";
    }

}
