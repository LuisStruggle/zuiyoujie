package com.study.eight.twelve;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：未排序数组中累加和小于或等于给定值的最长子数组长度
 * 
 * 描述：给定一个无序数组arr，其中元素可正、可负、可0，给定一个整数k。求arr所有的子数组中累加和小于或等于k的最长子数组长度。
 * 
 * @author zhangyundu
 *
 */
public class Solution {

	public int maxLength(int[] arr, int k) {
		int maxLength = 0;
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum <= k) {
					if (maxLength < (j - i + 1)) {
						maxLength = j - i + 1;
					}
				}
			}
		}
		return maxLength;
	}

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

			for (Integer key : map.keySet()) {
				if (sum - key <= k) {
					len = i - map.get(key);
					if (len > maxLength) {
						maxLength = len;
					}
				}
			}
		}
		return maxLength;
	}

	public int maxLength2(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	private int getLessIndex(int[] arr, int num) {// 二分查找
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.maxLength2(
				new int[] { 3, 4, 5, 6, 1, 0, 2, 1, 1 }, 6));
	}

}
