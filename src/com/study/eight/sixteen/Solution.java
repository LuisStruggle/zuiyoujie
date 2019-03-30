package com.study.eight.sixteen;

/**
 * 题目：子数组的最大累加和问题
 * 
 * 描述：给定给一个数组arr，返回子数组的最大累加和。
 * 
 * 例如，arr=[1,-2,3,5,-2,6,-1]，所有的子数组中，[3,5,-2,6]可以累加出最大的和12，所以返回12.
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int maxSum(int[] arr) {
		if (arr == null) {
			return 0;
		}

		int sum = Integer.MIN_VALUE;
		int tmp = 0;
		for (int i = 0; i < arr.length; i++) {
			tmp += arr[i];
			if (tmp > sum) {
				sum = tmp;
			}
			if (tmp < 0) {
				tmp = 0;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.maxSum(new int[] { 1, -2, 3, 5, -2, 6, -1 }));
	}

}
