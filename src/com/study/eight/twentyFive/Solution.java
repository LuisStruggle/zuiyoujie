package com.study.eight.twentyFive;

import java.util.Arrays;

/**
 * 题目：数组中未出现的最小正整数
 * 
 * 描述：给定一个无序整型数组arr，找到数组中未出现的最小正整数。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 简单方法，先排序，后比较
	public int missNum(int[] arr) {
		Arrays.sort(arr);
		int num = 1;
		for (int i : arr) {
			if (i <= 0) {
				continue;
			}

			if (i == num) {
				num++;
			} else {
				break;
			}
		}

		return num;
	}

	// 时间复杂度O（n）的方法
	public int missNum1(int[] arr) {
		int num = 0;
		// 正向遍历
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num + 1) {
				num++;
			}
		}

		// 反向遍历
		for (int i = arr.length - 1; i > -1; i--) {
			if (arr[i] == num + 1) {
				num++;
			}
		}

		return num + 1;
	}

	// 最优解
	public int missNum2(int[] arr) {
		int l = 0; // left
		int r = arr.length; // right
		while (l < r) {
			if (arr[l] == l + 1) { // 所有满足的值，l向r移动
				l++;
			} else if (arr[l] <= l || arr[l] > r || arr[arr[l] - 1] == arr[l]) { // 替换所有的不满足的值，r向l移动
				arr[l] = arr[--r];
			} else {
				swap(arr, l, arr[l] - 1); // 当前两者陷入不确定是，寻找一个新的值
			}
		}
		return l + 1;
	}

	private void swap(int[] arr, int l, int i) {
		// TODO Auto-generated method stub
		int tmp = arr[l];
		arr[l] = arr[i];
		arr[i] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.missNum2(new int[] { -3, 0, -2, 14, 15 }));
	}

}
