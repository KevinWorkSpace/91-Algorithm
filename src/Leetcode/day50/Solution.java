package Leetcode.day50;

import java.util.*;

class Solution {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrace(0, candidates, new ArrayList(), target);
        return lists;
    }

    public void backTrace(int first, int[] candidates, ArrayList curr, int target) {
        if (target == 0) {
            lists.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0) return;
        for (int i=first; i<candidates.length; i++) {
            if (i > first && candidates[i] == candidates[i-1]) continue;
            curr.add(candidates[i]);
            backTrace(i+1, candidates, curr, target - candidates[i]);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        Solution solution = new Solution();
        solution.combinationSum2(candidates, target);
    }
}