package Leetcode.day44;

class Solution {
    public int findCircleNum(int[][] M) {
        UnionFound uf = new UnionFound(M.length);
        for (int i=0; i<M.length; i++) {
            for (int j=i+1; j<M[0].length; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }
}

class UnionFound {

    private int[] parents;
    private int count;
    private int[] sizes;

    public UnionFound(int num) {
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
        else {
            if (sizes[pRoot] >= sizes[qRoot]) parents[qRoot] = pRoot;
            else parents[pRoot] = qRoot;
            count --;
        }
    }

    public int count() {
        return count;
    }
}