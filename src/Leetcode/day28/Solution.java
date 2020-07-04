package Leetcode.day28;

import java.util.Arrays;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) return null;
        int[] res = new int[2];
        for (int i=0; i<numbers.length; i++) {
            int num = numbers[i];
            res[0] = i+1;
            int l = i;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (numbers[mid] == target - num && mid != i) {
                    res[1] = mid+1;
                    return res;
                }
                else if (numbers[mid] > target - num) {
                    r = mid - 1;
                }
                else l = mid + 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        Solution solution = new Solution();
        int[] res = solution.twoSum(numbers, 8);
        System.out.println(Arrays.toString(res));
    }
}
