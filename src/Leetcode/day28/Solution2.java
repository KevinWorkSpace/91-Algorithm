package Leetcode.day28;

import java.util.Arrays;

class Solution2 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length - 1;
        int[] res = new int[2];
        while (l < r) {
            if (numbers[l] + numbers[r] == target) {
                res[0] = l + 1;
                res[1] = r + 1;
                return res;
            }
            else if (numbers[l] + numbers[r] > target) {
                r --;
            }
            else l ++;
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 4, 9, 56, 90};
        Solution2 solution = new Solution2();
        int[] res = solution.twoSum(numbers, 8);
        System.out.println(Arrays.toString(res));
    }
}
