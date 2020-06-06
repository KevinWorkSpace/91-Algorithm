package Leetcode.day4;

import java.util.Stack;

// 使用一个栈, 遇到数字, 字母, "["时存入栈, 遇到"]"时, 首先将前面的连续字母弹出, 合并成一个字符串, 再将前面的连续数字弹出, 合并成一个数字, 根据数字重复字符串, 并将结果压入栈中
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack();
        String fos = "";
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
//                stack.add(c);  不直接加入栈中, 而是设置一个变量来存数字, 最后一起入栈, 但提升不大
                fos += c;
            }
            else if (c == '[') {
                stack.add(fos);
                fos = "";
                stack.add(c + "");
            }
            else if (Character.isLetter(c)) {
                stack.add(c + "");
            }
            else if (c == ']') {
                stack = getResult(stack);
            }
        }
        String result = "";
        while (!stack.isEmpty()){
            String chara = stack.pop();
            result = chara + result;   //原来这里写成result += chara, 然后再字符串翻转多此一举...
        }
        return result;
    }

    public Stack<String> getResult(Stack<String> stack) {
        String str = "";
        String letter = stack.pop();
        while (!letter.equals("[")) {
            str = letter + str;
            letter = stack.pop();
        }
        String str2 = "";
        //把对单个字符的操作改为了操作整个字符串, 但性能提升不大
//        while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
//            String number = stack.pop();
//            str2 = number + str2;
//        }
        String number = stack.pop();
        int Num = Integer.parseInt(number);
        for (int j=0; j<Num; j++) {
//            for (int k=0; k<str.length(); k++) {
//                stack.add(str.charAt(k));
//            }
            str2 += str;
        }
        stack.add(str2);
        return stack;
    }
}
//速度较慢内存占用大, 仍需改进
