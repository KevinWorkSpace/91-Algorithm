package Leetcode.day41;

import Leetcode.day17.TreeNode;

import java.util.ArrayList;
import java.util.List;

class Trie {

    TrieNode root = null;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tmp = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (tmp.trieNodes[c - 'a'] == null) {
                tmp.trieNodes[c - 'a'] = new TrieNode();
            }
            tmp = tmp.trieNodes[c - 'a'];
        }
        tmp.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tmp = root;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i);
            if (tmp.trieNodes[c - 'a'] == null) {
                return false;
            }
            else tmp = tmp.trieNodes[c - 'a'];
        }
        if (tmp.isEnd) return true;
        else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tmp = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tmp.trieNodes[c - 'a'] == null) {
                return false;
            }
            else tmp = tmp.trieNodes[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        String word = "hhh";
        obj.insert(word);
        boolean param_2 = obj.search("hh");
        boolean param_3 = obj.startsWith("hhh");
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] trieNodes = new TrieNode[26];

    public TrieNode() {
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
