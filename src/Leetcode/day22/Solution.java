package Leetcode.day22;

class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] ns = new int[nums.length];
        int[] res = new int[2];
        for (int i=0; i<nums.length; i++) {
            int num = nums[i];
            if (ns[num-1] == 0) {
                ns[num-1] = 1;
            }
            else res[0] = num;
        }
        for (int i=0; i<ns.length; i++) {
            if (ns[i] == 0) {
                res[1] = i+1;
                break;
            }
        }
        return res;
    }
}
