package Leetcode.day37;

import java.util.HashMap;

class Solution2 {

    static HashMap<Character, Character> map = new HashMap<>();

    static {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return true;
        char first = s.charAt(0);
        int count = 0;
        if (!map.containsKey(first)) return false;
        else {
            char c = map.get(first);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == first) count ++;
                else if (s.charAt(i) == c) count --;
                if (count == 0) {
                    return isValid(s.substring(1, i)) && isValid(s.substring(i+1, s.length()));
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "(]";
        Solution2 solution = new Solution2();
        System.out.println(solution.isValid(str));
    }
}
