package Leetcode.day39;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1371 {
    public int findTheLongestSubstring(String s) {
        int[] pos = new int[32];
        int status = 0;
        Arrays.fill(pos, -1);
        pos[0] = 0;
        int ans = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') status ^= 1 << 0;
            else if (c == 'e') status ^= 1 << 1;
            else if (c == 'i') status ^= 1 << 2;
            else if (c == 'o') status ^= 1 << 3;
            else if (c == 'u') status ^= 1 << 4;
            if (pos[status] != -1) {
                ans = Math.max(ans, i + 1 - pos[status]);
            }
            else {
                pos[status] = i + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "leetcodeisgreat";
        Solution1371 solution1371 = new Solution1371();
        System.out.println(solution1371.findTheLongestSubstring(s));
    }
}
