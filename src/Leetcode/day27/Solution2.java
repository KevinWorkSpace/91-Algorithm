package Leetcode.day27;

class Solution2 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            if (nums[j] != nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }
        }
        return i+1;
    }
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        Solution solution = new Solution();
        int res = solution.removeDuplicates(nums);
        System.out.println(res);
    }
}
