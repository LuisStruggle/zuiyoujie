package com.study.eight.eleven;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：未排序数组中累加和为给定值的最长子数组系列问题
 * 
 * 描述：给定一个 无序数组arr，其中元素可正、可负、可0，给定一个整数k。求arr所有的子数组中累加和为最长子数组长度。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 原题目(遍历每一个子数组，找出符合要求的 且 最长的数组)
	public int maxLength(int[] arr, int k) {
		int sum = 0;
		int maxLength = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum == k) {
					if ((j - i + 1) > maxLength) {
						maxLength = j - i + 1;
					}
				}
			}
		}
		return maxLength;
	}

	// 原题目(遍历每一个子数组，找出符合要求的 且 最长的数组)
	public int maxLength1(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int maxLength = 0;
		int sum = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

			if (map.containsKey(sum - k)) {
				len = i - map.get(sum - k);
				if (len > maxLength) {
					maxLength = len;
				}
			}

		}
		return maxLength;
	}

	// 补充题目：给定一个无序数组arr，其中元素可正、可负、可0.求arr所有的子数组中正数与负数个数相等的最长子数组长度。
	public int maxLength2(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int maxLength = 0;
		int sum = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				sum += -1;
			}
			if (arr[i] > 0) {
				sum += 1;
			}

			if (map.containsKey(sum - k)) {
				len = i - map.get(sum - k);
				if (len > maxLength) {
					maxLength = len;
				}
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

		}
		return maxLength;
	}

	// 补充题目：给定一个无序数组arr，其中元素只有1和0.求arr所有的子数组中0和1个数相等的最长子数组长度。
	public int maxLength3(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int maxLength = 0;
		int sum = 0;
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				sum += -1;
			}
			if (arr[i] == 1) {
				sum += 1;
			}

			if (map.containsKey(sum - k)) {
				len = i - map.get(sum - k);
				if (len > maxLength) {
					maxLength = len;
				}
			}

			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}

		}
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.maxLength(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 9));
		System.out.println(s.maxLength1(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 9));
		System.out.println(s.maxLength2(new int[] { -1, 0, 3, 4, 5, 6, 7 }, 0));
		System.out.println(s.maxLength3(new int[] { 0, 0, 1, 1, 0, 1, 1 }, 0));
	}

}
