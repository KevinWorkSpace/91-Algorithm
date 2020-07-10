package Leetcode.day30;

class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            String cur = words[i];
            if (cur.equals(word1)) {
                int left = 0;
                int right = 0;
                for (int j=i-1; j>=0; j--) {
                    if (words[j].equals(word2)) {
                        left = j;
                        break;
                    }
                }
                for (int j=i+1; j<words.length; j++) {
                    if (words[j].equals(word2)) {
                        right = j;
                        break;
                    }
                }
                if (left == 0 && right != 0) {
                    ans = Math.min(ans, right-i);
                }
                else if (left != 0 && right == 0) {
                    ans = Math.min(ans, i-left);
                }
                else if (left != 0 && right != 0) {
                    int tmpDis = Math.min(i-left, right-i);
                    ans = Math.min(ans, tmpDis);
                }
            }
        }
        return ans;
    }
}