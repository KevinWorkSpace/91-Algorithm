package Leetcode.day20;

import java.util.HashMap;

class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int sum = 0;
        for (int i=0; i<points.length; i++) {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            int[] point1 = points[i];
            int x1 = point1[0];
            int y1 = point1[1];
            for (int j=0; j<points.length; j++) {
                if (j != i) {
                    int[] point2 = points[j];
                    int x2 = point2[0];
                    int y2 = point2[1];
                    int dis = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2);
                    if (hashMap.get(dis) == null) {
                        hashMap.put(dis, 1);
                    }
                    else hashMap.put(dis, hashMap.get(dis) + 1);
                }
            }
            for (Integer value : hashMap.values()) {
                sum += value * (value-1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,0},{2,0}};
        Solution solution = new Solution();
        System.out.println(solution.numberOfBoomerangs(points));
    }
}
