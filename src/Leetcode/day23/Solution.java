package Leetcode.day23;

import java.util.ArrayList;

class Solution {

    private boolean f = false;

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Node[] nodes = new Node[n];
        for (int i=0; i<n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i=0; i<graph.length; i++) {
            int[] edge = graph[i];
            int s = edge[0];
            int e = edge[1];
            nodes[s].children.add(nodes[e]);
        }
        Node startNode = nodes[start];
        Node targetNode = nodes[target];
        startNode.flag = 1;
        find(startNode, targetNode);
        return f;
    }

    public void find(Node start, Node target) {
        if (f) return;
        for (int i=0; i<start.children.size(); i++) {
            Node child = start.children.get(i);
            if (child.flag == 1) continue;
            if (child == target) {
                f = true;
                return;
            }
            else {
                child.flag = 1;
                find(child, target);
            }
        }
    }

//    public static void main(String[] args) {
//        int n = 25;
//        int[][] graph = {{0, 1}, {0, 3}, {0, 10}, {0, 18}, {1, 2}, {1, 7}, {1, 11}, {1, 12}, {2, 4}, {2, 5}, {2, 13}, {2, 16}, {3, 6}, {3, 8}, {4, 9}, {5, 17}, {7, 20}, {7, 22}, {8, 10}, {10, 19}, {11, 15}, {13, 14}, {14, 21}, {15, 23}, {19, 24}, {20, 22}};
//        int start = 0;
//        int target = 12;
//        Solution solution = new Solution();
//        solution.findWhetherExistsPath(n, graph, start, target);
//    }
}

class Node {
    int value;
    int flag = 0;
    ArrayList<Node> children = new ArrayList<>();
    public Node(int value) {
        this.value = value;
    }
}
