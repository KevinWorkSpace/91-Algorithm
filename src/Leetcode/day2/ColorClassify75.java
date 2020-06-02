package Leetcode.day2;

class ColorClassify75 {
    //由选择排序修改为三指针方法, 时间复杂度O(n^2) -> O(n), 空间复杂度O(n)
    public static void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        int current = 0;
        while (l<=r && current<=r) {  //一开始用了一层循环加双指针, 但是会忽略进行多次交换的情况, 后改为三指针
            if (nums[current] == 0) {
                int temp = nums[current];
                nums[current] = nums[l];
                nums[l] = temp;
                l++;
                current++;   //current位置前面一定有序, 所以不用停留, 直接到下一个位置
            }
            else if (nums[current] == 2){
                int temp = nums[current];
                nums[current] = nums[r];
                nums[r] = temp;
                r--;   //current位置前面不一定有序, 需要停留, 进行下一次判断
            }
            else current++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 0};
        sortColors(nums);
        for (int i=0; i<nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
