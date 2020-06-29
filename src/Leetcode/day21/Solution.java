package Leetcode.day21;

import java.util.HashMap;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashMap<Character, Integer>[] widthMap = new HashMap[9];
        HashMap<Character, Integer>[] heightMap = new HashMap[9];
        HashMap<Character, Integer>[] gridMap = new HashMap[9];
        for (int i=0; i<widthMap.length; i++) {
            widthMap[i] = new HashMap<>();
            heightMap[i] = new HashMap<>();
            gridMap[i] = new HashMap<>();
        }
        for (int i=0; i<9; i++) {
            HashMap mapH = heightMap[i];
            for (int j=0; j<9; j++) {
                HashMap mapW = widthMap[j];
                HashMap mapG = gridMap[3 * (i/3) + j/3];
                char current = board[i][j];
                if (current == '.') continue;
                if (mapH.containsKey(current) || mapW.containsKey(current) || mapG.containsKey(current)) {
                    return false;
                }
                else {
                    mapH.put(current, 1);
                    mapW.put(current, 1);
                    mapG.put(current, 1);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
            {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
            {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
            {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
            {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
            {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
            {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
            {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
            {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        Solution solution = new Solution();
        solution.isValidSudoku(board);
    }
}
