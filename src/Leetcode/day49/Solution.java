package Leetcode.day49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrace(new ArrayList<>(), candidates, target, 0);
        return lists;
    }

    public void backTrace(ArrayList<Integer> curr, int[] candidates, int target, int pos) {
        if (target == 0){
            lists.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i=pos; i<candidates.length; i++) {
            curr.add(candidates[i]);
            backTrace(curr, candidates, target - candidates[i], i);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] candidates = {2, 5, 3, 4, 7};
        int target = 7;
        List list = solution.combinationSum(candidates, target);
        System.out.println();
    }
}
