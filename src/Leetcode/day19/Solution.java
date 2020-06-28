package Leetcode.day19;

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i=0; i<nums.length; i++) {
            hashMap.put(nums[i], i);
        }
        for (int i=0; i<nums.length; i++) {
            int num1 = nums[i];
            if (hashMap.get(target-num1) != null && hashMap.get(target-num1) != i) {
                res[0] = i;
                res[1] = hashMap.get(target-num1);
                return res;
            }
        }
        return null;
    }
}
