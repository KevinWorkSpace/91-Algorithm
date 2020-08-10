package Leetcode.day51;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();
    int[] color;

    public List<List<Integer>> permuteUnique(int[] nums) {
        color = new int[nums.length];
        Arrays.sort(nums);
        backTrace(nums, new ArrayList());
        return lists;
    }

    public void backTrace(int[] nums, ArrayList curr) {
        if (curr.size() == nums.length) {
            lists.add(new ArrayList<>(curr));
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && color[i-1] == 1) continue;
            if (color[i] == 0) {
                curr.add(nums[i]);
                color[i] = 1;
                backTrace(nums, curr);
                curr.remove(curr.size()-1);
                color[i] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution solution = new Solution();
        solution.permuteUnique(nums);
        System.out.println();
    }
}
