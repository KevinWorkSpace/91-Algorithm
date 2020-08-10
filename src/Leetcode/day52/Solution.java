package Leetcode.day52;

class Solution {

    public int findTheLongestSubstring(String s) {
        int max = 0;
        for (int x=0; x<s.length(); x++) {
            int a = 0, e = 0, i = 0, o = 0, u = 0;
            for (int j=x; j<s.length(); j++) {
                char c = s.charAt(j);
                if (c == 'a') a = change(a);
                else if (c == 'e') e = change(e);
                else if (c == 'i') i = change(i);
                else if (c == 'o') o = change(o);
                else if (c == 'u') u = change(u);
                if (a + e + i + o + u == 0) {
                    max = Math.max(max, j-x+1);
                }
            }
        }
        return max;
    }

    public int change(int a) {
        if (a == 0) a = 1;
        else a = 0;
        return a;
    }

    public static void main(String[] args) {
        String s = "a";
        Solution solution = new Solution();
        System.out.println(solution.findTheLongestSubstring(s));
    }
}