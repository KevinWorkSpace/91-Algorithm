package Leetcode.day29;

class Solution4 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int s = heights[0];
        for (int i=0; i<heights.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j=i; j<heights.length; j++) {
                min = Math.min(min, heights[j]);
                s = Math.max(min * (j-i+1), s);
            }
        }
        return s;
    }
}
