package Leetcode.day35;

import java.util.ArrayList;
import java.util.List;

class Solution {
    int k = 0;
    List<List<Integer>> lists = new ArrayList<>();

    public void backTrace(int first, ArrayList<Integer> curr, int[] nums) {
        if (k < curr.size()) return;
        if (k == curr.size()) lists.add(new ArrayList<>(curr));

        for (int i=first; i<nums.length; i++) {
            curr.add(nums[i]);
            backTrace(i+1, curr, nums);
            curr.remove(curr.get(curr.size()-1));
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        for (k=0; k<=nums.length; k++) {
            backTrace(0, new ArrayList(), nums);
        }
        return lists;
    }
}
