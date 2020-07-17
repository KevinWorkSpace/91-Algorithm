package Leetcode.day36;

import java.util.Arrays;

class Solution2 {
    public int uniquePaths(int m, int n) {
        int[] grids = new int[m];
        Arrays.fill(grids, 1);
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                grids[j] = grids[j-1] + grids[j];
            }
        }
        return grids[m-1];
    }
}
