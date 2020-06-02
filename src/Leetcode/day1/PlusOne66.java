package Leetcode.day1;

class PlusOne66 {
    public static int[] plusOne(int[] digits) {
        int jin = 1;
        for (int i= digits.length-1; i>=0; i--) {
            digits[i] = digits[i] + jin;
            if(digits[i] == 10) {
                digits[i] = 0;
                jin = 1;
            }
            else {
                jin = 0;
            }
            if (i == 0 & digits[i] == 0) {
                int[] newDigits = new int[digits.length + 1];
                for (int j=0; j<digits.length; j++) {
                    newDigits[j+1] = digits[j];
                }
                newDigits[0] = 1;
                return newDigits;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] digits = new int[]{1, 2, 3};
        digits = plusOne(digits);
        for (int i=0; i<digits.length; i++) {
            System.out.print(digits[i] + " ");
        }
    }
}