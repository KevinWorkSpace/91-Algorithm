package Leetcode.day24;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;
        int max = 1;
        for (int i=0; i<points.length; i++) {
            int[] p1 = points[i];
            int x1 = p1[0];
            int y1 = p1[1];
            HashMap<String, Integer> hashMap = new HashMap();
            int tmpMax = 1;
            int repeat = 0;
            for (int j = i + 1; j < points.length; j++) {
                int[] p2 = points[j];
                int x2 = p2[0];
                int y2 = p2[1];
                if (x1 == x2 && y1 == y2) {
                    repeat ++;
                    continue;
                }
                int dx = x1 - x2;
                int dy = y1 - y2;
                int gcd = gcd(dx, dy);
                if (gcd != 0) {
                    String k = (dy / gcd) + "/" + (dx / gcd);
                    if (!hashMap.containsKey(k)) {
                        hashMap.put(k, 2);
                    } else {
                        hashMap.put(k, hashMap.get(k) + 1);
                    }
                } else {
                    String k = dy + "/" + dx;
                    if (!hashMap.containsKey(k)) {
                        hashMap.put(k, 2);
                    } else {
                        hashMap.put(k, hashMap.get(k) + 1);
                    }
                }
            }
            for (Integer value : hashMap.values()) {
                if (value > tmpMax) tmpMax = value;
            }
            if (tmpMax + repeat > max) max = tmpMax + repeat;
        }
        return max;
    }

    public int gcd(int dx, int dy) {
        if (dx == 0) return dy;
        return gcd(dy % dx, dx);
    }

    public static void main(String[] args) {
        int[][] points = {{0,0},{1,1},{0,0}};
        Solution solution = new Solution();
        System.out.println(solution.maxPoints(points));
    }
}
