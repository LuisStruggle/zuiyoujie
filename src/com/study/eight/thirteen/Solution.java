package com.study.eight.thirteen;

/**
 * 题目：计算数组的小和
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 时间复杂度是O(n的平方)
	public int getSmallSum(int[] arr) {
		int sum = 0;
		int tmp = 0;
		for (int i = 1; i < arr.length; i++) {
			tmp = 0;
			for (int j = 0; j < i; j++) {
				if (arr[j] <= arr[i]) {
					tmp += arr[j];
				}
			}
			sum += tmp;
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getSmallSum(new int[] { 1, 3, 5, 2, 4, 6 }));
	}

}
