package Leetcode.day37;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '{':
                case '(':
                case '[':
                    stack.add(c);
                    break;
                case '}':
                    if (stack.isEmpty()) return false;
                    char c1 = stack.pop();
                    if (c1 != '{') return false;
                    break;
                case ')':
                    if (stack.isEmpty()) return false;
                    char c2 = stack.pop();
                    if (c2 != '(') return false;
                    break;
                case ']':
                    if (stack.isEmpty()) return false;
                    char c3 = stack.pop();
                    if (c3 != '[') return false;
                    break;
            }
        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
