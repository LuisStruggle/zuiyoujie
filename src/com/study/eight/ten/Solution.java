package com.study.eight.ten;

/**
 * 题目：未排序正数数组中累加和为给定值的最长子数组长度
 * 描述：给定一个数组arr，该数组无序，但每个值均为正数，再给定一个正数k。求arr的所有子数组中所有元素相加和为k的最长子数组长度。
 * 
 * 例如：arr=[1,2,1,1,1],k=3。
 * 
 * 累加和为3的最长子数组为[1,1,1]，所以结果返回3。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 遍历所有子数组，满足和为k，长度最长
	public int getMaxLength(int[] arr, int k) {
		int sum = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == k) {
					len = Math.max(len, j - i + 1);
				} else if (sum > k) {
					break;
				}
			}
		}
		return len;
	}

	public int getMaxLength1(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0) {
			return 0;
		}

		int sum = 0;
		int len = 0;
		int left = 0;
		int right = 0;

		while (right < arr.length) {
			if (sum == k) {
				len = Math.max(len, right - left);
				sum -= arr[left];
				left++;
			}
			if (sum < k) {
				sum += arr[right];
				right++;
			}
			if (sum > k) {
				sum -= arr[left];
				left++;
			}

		}

		if (sum == k) {
			len = Math.max(len, right - left);
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getMaxLength1(new int[] { 1, 2, 1, 1, 1 }, 6));
	}

}
