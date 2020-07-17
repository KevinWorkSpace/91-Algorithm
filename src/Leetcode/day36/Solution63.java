package Leetcode.day36;

import java.util.Arrays;

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] grids = new int[m][n];
        boolean f1 = true;
        for (int i=0; i<m; i++) {
            if (f1) {
                if (obstacleGrid[i][0] == 0) {
                    grids[i][0] = 1;
                }
                else {
                    grids[i][0] = 0;
                    f1 = false;
                }
            }
            else grids[i][0] = 0;
        }
        boolean f2 = true;
        for (int j=0; j<n; j++) {
            if (f2) {
                if (obstacleGrid[0][j] == 0) {
                    grids[0][j] = 1;
                }
                else {
                    grids[0][j] = 0;
                    f2 = false;
                }
            }
            else grids[0][j] = 0;
        }

        for (int i=1; i<m; i++) {
            for (int j=1; j<n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    grids[i][j] = grids[i][j-1] + grids[i-1][j];
                }
                else grids[i][j] = 0;
            }
        }
        return grids[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] grids = {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        Solution63 s = new Solution63();
        int ans = s.uniquePathsWithObstacles(grids);
        System.out.println(ans);
    }
}
