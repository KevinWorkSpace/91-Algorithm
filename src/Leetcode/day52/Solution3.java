package Leetcode.day52;

import java.util.HashMap;
import java.util.Map;

public class Solution3 {

    public int findTheLongestSubstring(String s) {
        int state = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') state ^= 1;
            else if (c == 'e') state ^= 2;
            else if (c == 'i') state ^= 4;
            else if (c == 'o') state ^= 8;
            else if (c == 'u') state ^= 16;
            if (map.containsKey(state)) {
                max = Math.max(max, i - map.get(state));
            }
            else map.put(state, i);
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "eleetminicoworoep";
        Solution3 solution3 = new Solution3();
        int a = solution3.findTheLongestSubstring(s);
        System.out.println(a);

        String s2 = "bcbcbc";
        String s3 = "leetcodeisgreat";
        String s4 = "eleetminicoworoep";
    }
}
