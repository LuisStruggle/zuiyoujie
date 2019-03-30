package com.study.eight.fourteen;

/**
 * 题目：自然数数组的排序
 * 
 * 描述：给定一个长度为N的整型数组arr，其中有N个互不相等的自然数1~N，请实现arr的排序，但是不要把下标0~（N-1）
 * 位置上的数通过直接赋值的方式替换成1~N。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public void sort(int[] arr) {
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			while (arr[i] != i + 1) {
				tmp = arr[i];
				arr[i] = arr[tmp - 1];
				arr[tmp - 1] = tmp;
			}
		}
		System.out.println(arr);
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.sort(new int[] { 2, 3, 6, 1, 4, 5 });
	}
}
