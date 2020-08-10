package Leetcode.day45;

class Solution {
    public int minMalwareSpread(int[][] graph, int[] initial) {
        UnionFind uf = new UnionFind(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = i + 1; j < graph.length; j++) {
                if (graph[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        int[] counts = new int[graph.length];
        for (int i = 0; i < initial.length; i++) {
            int node = initial[i];
            int nodeRoot = uf.find(node);
            counts[nodeRoot]++;
        }
        int ans = -1;
        int maxSize = Integer.MIN_VALUE;
        for (int i = 0; i < initial.length; i++) {
            int node = initial[i];
            int nodeRoot = uf.find(node);
            if (counts[nodeRoot] == 1) {
                if (uf.size[nodeRoot] > maxSize) {
                    ans = node;
                    maxSize = uf.size[nodeRoot];
                } else if (uf.size[nodeRoot] == maxSize && node < ans) {
                    ans = node;
                }
            }
        }
        if (ans == -1) {
            ans = Integer.MAX_VALUE;
            for (int i = 0; i < initial.length; i++) {
                ans = Math.min(ans, initial[i]);
            }
        }
        return ans;
    }
}

class UnionFind {
    int[] parents;
    int[] size;
    int count;

    public UnionFind(int num) {
        parents = new int[num];
        size = new int[num];
        count = num;
        for (int i=0; i<num; i++) {
            parents[i] = i;
            size[i] = 1;
        }
    }

    public int find(int index) {
        int p = parents[index];
        while (p != parents[p]) {
            p = parents[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (size[pRoot] >= size[qRoot]) {
            parents[qRoot] = pRoot;
            size[pRoot] += size[qRoot];
        }
        else {
            parents[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }
        count --;
    }

    public int getCount() {
        return count;
    }
}