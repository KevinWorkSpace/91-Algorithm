package Leetcode.day39;

import java.util.HashMap;

class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int prenum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        for (int i=1; i<=nums.length; i++) {
            prenum += nums[i-1];
            if (map.containsKey(prenum - k)) {
                ans += map.get(prenum - k);
            }
            map.put(prenum, map.getOrDefault(prenum, 0) + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        Solution560 solution560 = new Solution560();
        solution560.subarraySum(nums, k);
    }
}
