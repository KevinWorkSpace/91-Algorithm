package Leetcode.day30;

class Solution2 {
    public int findClosest(String[] words, String word1, String word2) {
        int word1Index = -1;
        int word2Index = -1;
        int ans = Integer.MAX_VALUE;
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) {
                word1Index = i;
                if (word2Index != -1) ans = Math.min(ans, Math.abs(word1Index - word2Index));
            }
            else if (words[i].equals(word2)) {
                word2Index = i;
                if (word1Index != -1) ans = Math.min(ans, Math.abs(word1Index - word2Index));
            }
        }
        return ans;
    }
}
