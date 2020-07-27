package Leetcode.day42;

class MapSum {

    private TrieNode root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new TrieNode();
    }

    public void insert(String key, int val) {
        TrieNode tmp = root;
        for (int i=0; i<key.length(); i++) {
            char c = key.charAt(i);
            if (tmp.childern[c - 'a'] == null) {
                tmp.childern[c - 'a'] = new TrieNode();
            }
            tmp = tmp.childern[c - 'a'];
        }
        tmp.val = val;
    }

    public int sum(String prefix) {
        TrieNode tmp = root;
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (tmp.childern[c - 'a'] == null) {
                return 0;
            }
            tmp = tmp.childern[c - 'a'];
        }
        return dfs(tmp);
    }

    public int dfs(TrieNode tmp) {
        int sum = 0;
        for (int i=0; i<tmp.childern.length; i++) {
            if (tmp.childern[i] != null) {
                sum += dfs(tmp.childern[i]);
            }
        }
        return sum + tmp.val;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] childern = new TrieNode[26];
    int val;
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
