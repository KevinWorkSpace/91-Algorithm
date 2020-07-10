package Leetcode.day29;

class Solution3 {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                ans += leftMax - height[left];
                left ++;
            }
            else {
                rightMax = Math.max(height[right], rightMax);
                ans += rightMax - height[right];
                right --;
            }
        }
        return ans;
    }
}