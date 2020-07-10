package Leetcode.day30;

import java.util.ArrayList;

public class Solution3 {
    public int findClosest(String[] words, String word1, String word2) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i=0; i<words.length; i++) {
            if (words[i].equals(word1)) list1.add(i);
            else if (words[i].equals(word2)) list2.add(i);
        }
        int i = 0;
        int j = 0;
        int ans = Integer.MAX_VALUE;
        while (i<list1.size() && j<list2.size()) {
            if (list1.get(i) < list2.get(j)) {
                ans = Math.min(ans, list2.get(j) - list1.get(i));
                i++;
            }
            else {
                ans = Math.min(ans, list1.get(i) - list2.get(j));
                j++;
            }
        }
        return ans;
    }
}
