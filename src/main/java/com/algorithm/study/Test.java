package com.algorithm.study;

public class Test {

    public static void main(String[] args) {
        int[] nums1 = {1, -2, -5, -4, -3, 3, 3, 5};
        int[] nums2 = {2, 2};
        System.out.println("【" + new Test().reverseLeftWords("abcdefg", 2) + "】");
//        System.out.println(Arrays.toString(new Test().fourSumCount(nums1, 9)));
    }

    // s = "abcdefg", k = 2
    public String reverseLeftWords(String s, int n) {

        char[] chars = s.toCharArray();
        int len = chars.length;
        swap(chars, 0, len - 1);
        swap(chars, 0, len - n - 1);
        swap(chars, len - n, len - 1);

        return String.valueOf(chars);
    }

    private void swap(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l++] = chars[r];
            chars[r--] = temp;
        }
    }
}
