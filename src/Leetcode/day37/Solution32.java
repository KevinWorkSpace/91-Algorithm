package Leetcode.day37;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

class Solution32 {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        stack.add(-1);
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.add(i);
            }
            else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.add(i);
                }
                else {
                    int tmp = i - stack.peek();
                    ans = Math.max(tmp, ans);
                }
            }
        }
        return ans;
    }
}
