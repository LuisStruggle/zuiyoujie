package com.study.eight.eighteen;

/**
 * 题目：在数组中找到一个局部最小的位置
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int getLessIndex(int[] arr) {
		if (arr == null) {
			return -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				if (i + 1 < arr.length) {
					if (arr[i] < arr[i + 1]) {
						return i;
					}
				} else {
					return i;
				}
			} else {
				if (i + 1 < arr.length) {
					if (arr[i - 1] > arr[i] && arr[i] < arr[i + 1]) {
						return i;
					}
				} else {
					if (arr[i] < arr[i - 1]) {
						return i;
					}
				}
			}
		}

		return -1;
	}

	// 二分查找法实现，可实现时间复杂度为O（logN）
	public int getLessIndex1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1; // 不存在
		}
		if (arr.length == 1 || arr[0] < arr[1]) {
			return 0;
		}
		if (arr[arr.length - 1] < arr[arr.length - 2]) {
			return arr.length - 1;
		}
		int left = 1;
		int right = arr.length - 2;
		int mid = 0;
		while (left < right) {
			mid = (left + right) / 2;
			if (arr[mid] > arr[mid - 1]) {
				right = mid - 1;
			} else if (arr[mid] > arr[mid - 1]) {
				left = mid + 1;
			} else {
				return mid;
			}
		}

		return left;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getLessIndex(new int[] {}));
	}

}
