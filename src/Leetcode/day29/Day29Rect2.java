package Leetcode.day29;

class Solution5 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0) return 0;
        if (heights.length == 1) return heights[0];
        int s = heights[0];
        for (int i=0; i<heights.length-1; i++) {
            s = Math.max(heights[i], s);
            int min = Math.min(heights[i], heights[i+1]);
            s = Math.max(min * 2, s);
            for (int j=i+2; j<heights.length; j++) {
                min = Math.min(min, heights[j]);
                s = Math.max(min * (j-i+1), s);
            }
        }
        s = Math.max(s, heights[heights.length-1]);
        return s;
    }

    public static void main(String[] args) {
        int[] heights = {0, 9};
        Solution5 solution = new Solution5();
        System.out.println(solution.largestRectangleArea(heights));
    }
}
