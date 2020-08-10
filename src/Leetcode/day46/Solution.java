package Leetcode.day46;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n);
        int tmp = 0;
        for (int i=0; i<connections.length; i++) {
            int[] line = connections[i];
            int x = line[0];
            int y = line[1];
            if (uf.find(x) == uf.find(y)) {
                tmp ++;
            }
            uf.union(x, y);
        }
        int count = uf.getCount();
        if (tmp >= count - 1) {
            return count - 1;
        }
        else return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] connections =  {{0,1},{0,2},{0,3},{1,2}};
        int n = 6;
        System.out.println(solution.makeConnected(n, connections));
    }
}

class UnionFind {
    private int[] parents;
    private int[] sizes;
    private int count;

    public UnionFind(int num) {
        parents = new int[num];
        sizes = new int[num];
        for (int i=0; i<num; i++) {
            parents[i] = i;
            sizes[i] = 1;
        }
        count = num;
    }

    public int find(int p) {
        while (parents[p] != p) {
            p = parents[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) return;
        if (sizes[pRoot] > sizes[qRoot]) {
            parents[qRoot] = pRoot;
            sizes[pRoot] += sizes[qRoot];
        }
        else {
            parents[pRoot] = qRoot;
            sizes[qRoot] += sizes[pRoot];
        }
        count --;
    }

    public int getCount() {
        return count;
    }
}
