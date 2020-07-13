package Leetcode.day34;

import java.util.Arrays;

class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if (nums.length <= 1) return 0;
        int[] nums2 = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            nums2[i] = nums[i];
        }
        Arrays.sort(nums2);
        int left = -1;
        int right = -1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] != nums2[i]) {
                left = i;
                break;
            }
        }
        for (int i=nums.length-1; i>=0; i--) {
            if (nums[i] != nums2[i]) {
                right = i;
                break;
            }
        }
        if (left == -1 && right == -1) return 0;
        return right - left + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Solution solution = new Solution();
        int ans = solution.findUnsortedSubarray(nums);
        System.out.println(ans);
    }
}