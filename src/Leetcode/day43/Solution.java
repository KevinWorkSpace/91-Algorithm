package Leetcode.day43;

import java.util.ArrayList;
import java.util.List;

class Solution {

    TrieNode root = new TrieNode();

    public int[][] multiSearch(String big, String[] smalls) {
        for (int i=0; i<smalls.length; i++) {
            String str = smalls[i];
            TrieNode tmp = root;
            for (int j=0; j<str.length(); j++) {
                char c = str.charAt(j);
                if (tmp.children[c - 'a'] == null) {
                    tmp.children[c - 'a'] = new TrieNode();
                }
                tmp = tmp.children[c - 'a'];
            }
            tmp.isEnd = true;
            tmp.index = i;
        }
        List<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i=0; i<smalls.length; i++) {
            lists.add(new ArrayList<Integer>());
        }
        for (int i=0; i<big.length(); i++) {
            TrieNode tmp = root;
            for (int j=i; j<big.length(); j++) {
                char c = big.charAt(j);
                if (tmp.children[c - 'a'] == null) {
                    break;
                }
                tmp = tmp.children[c - 'a'];
                if (tmp.isEnd) {
                    lists.get(tmp.index).add(i);
                }
            }
        }
        int[][] res = new int[smalls.length][];
        for (int i=0; i<smalls.length; i++) {
            res[i] = new int[lists.get(i).size()];
            for (int j=0; j<lists.get(i).size(); j++) {
                res[i][j] = lists.get(i).get(j);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String str = "mississippi";
        Solution solution = new Solution();
        String[] strings = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        System.out.println(solution.multiSearch(str, strings));
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children = new TrieNode[26];
    int index;
}
