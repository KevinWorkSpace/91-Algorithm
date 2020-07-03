package Leetcode.day27;

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int nextDiff = 0;
        int trav = 0;
        int size = 1;
        while (nextDiff < nums.length-1) {
            while (nextDiff < nums.length && nums[nextDiff] == nums[trav]) {
                nextDiff ++;
            }
            if (nextDiff == nums.length) {
                return size;
            }
            size ++;
            nums[trav+1] = nums[nextDiff];
            trav++;
        }
        return size;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        Solution solution = new Solution();
        int res = solution.removeDuplicates(nums);
        System.out.println(res);
    }
}
