package Leetcode.day29;

class Solution2 {
    public int trap(int[] height) {
        int ans = 0;
        for (int i=0; i<height.length; i++) {
            int leftMax = 0;
            for (int j=0; j<=i; j++) {
                leftMax = Math.max(height[j], leftMax);
            }
            int rightMax = 0;
            for (int j=height.length-1; j>=i; j--) {
                rightMax = Math.max(height[j], rightMax);
            }
            ans = ans + Math.min(leftMax, rightMax) - height[i];
        }
        return ans;
    }
}
