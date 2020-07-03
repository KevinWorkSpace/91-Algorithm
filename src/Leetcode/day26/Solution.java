package Leetcode.day26;

class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        int max = 0;
        for (int i=0; i<piles.length; i++) {
            if (piles[i] > max) max = piles[i];
        }
        int l = 1;
        int r = max;
        while (l <= r) {
            int mid = (l + r) / 2;
            int count = 0;
            for (int i=0; i<piles.length; i++) {
                count += piles[i] / mid;
                if (piles[i] % mid != 0) {
                    count ++;
                }
            }
            if (count == H) return mid;
            else if (count > H) l = mid + 1;
            else r = mid - 1;
        }
        return l;
    }
}
