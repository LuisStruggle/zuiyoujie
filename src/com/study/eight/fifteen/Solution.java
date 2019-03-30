package com.study.eight.fifteen;

/**
 * 题目：奇数下标都是奇数或者偶数下标都是偶数
 * 
 * 描述：给定一个长度不小于2的数组arr，实现一个函数调整arr，要么让所有的偶数下标都是偶数，要么让所有的奇数下标都是奇数。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public void modify(int[] arr) {
		int tmp = 0;
		int i = 0, j = arr.length - 1;
		while (i < j) {
			if (i % 2 == 0) {// 要求是偶数时
				if (arr[i] % 2 == 0) {
					i++;
					j = arr.length - 1;
				} else if (arr[j] % 2 == 0) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;

					i++;
					j = arr.length - 1;
				} else {
					j--;
				}
			} else {// 要求是奇数时
				if (arr[i] % 2 != 0) {
					i++;
					j = arr.length - 1;
				} else if (arr[j] % 2 != 0) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;

					i++;
					j = arr.length - 1;
				} else {
					j--;
				}
			}
		}
		System.out.println(arr);
	}

	public void modify1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		int even = 0;
		int odd = 1;
		int end = arr.length - 1;
		while (even < -end && odd <= end) {
			if ((arr[end] & 1) == 0) {
				swap(arr, end, even);
				even += 2;
			} else {
				swap(arr, end, odd);
				odd += 2;
			}
		}

	}

	private void swap(int[] arr, int index1, int index2) {
		// TODO Auto-generated method stub
		int tmp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.modify(new int[] { 1, 8, 3, 2, 4, 6 });
	}
}
