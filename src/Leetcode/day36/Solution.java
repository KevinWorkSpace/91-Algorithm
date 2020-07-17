package Leetcode.day36;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] grids = new int[n][m];
        for (int i=0; i<n; i++) {
            grids[i][0] = 1;
        }
        for (int i=0; i<m; i++) {
            grids[0][i] = 1;
        }
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                grids[i][j] = grids[i-1][j] + grids[i][j-1];
            }
        }
        return grids[n-1][m-1];
    }
}