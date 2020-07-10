package Leetcode.day29;

class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int tmpMaxLeft = 0;
        for (int i=0; i<n; i++) {
            leftMax[i] = Math.max(tmpMaxLeft, height[i]);
            tmpMaxLeft = Math.max(tmpMaxLeft, height[i]);
        }
        int tmpMaxRight = 0;
        for (int i=n-1; i>=0; i--) {
            rightMax[i] = Math.max(tmpMaxRight, height[i]);
            tmpMaxRight = Math.max(tmpMaxRight, height[i]);
        }
        int ans = 0;
        for (int i=0; i<n; i++) {
            int min = Math.min(leftMax[i], rightMax[i]);
            ans += min - height[i];
        }
        return ans;
    }
}