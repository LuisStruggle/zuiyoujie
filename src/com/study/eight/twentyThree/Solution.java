package com.study.eight.twentyThree;

/**
 * 题目：数组的partition调整
 * 
 * 描述：给定一个有序数组arr，调整arr使得这个数组的左半部分没有重复元素且升序，而不用保证右部分是否有序。
 * 
 * 例如，arr=[1,2,2,2,3,3,4,5,6,6,7,7,8,8,8,9]，调整之后arr=[1,2,3,4,5,6,7,8,9,...]。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 方法一：核心思想是以某个数结尾的都是排序好的
	public static void leftUnique(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		int u = 0;
		int i = 1;
		int tmp;
		while (i != arr.length) {
			if (arr[u] != arr[i]) {
				u++;
				if (u != i) { // 交换
					tmp = arr[u];
					arr[u] = arr[i];
					arr[i] = tmp;
				}
			}
			i++;
		}
		System.out.println(arr);
	}

	// 补充问题
	public static void sort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}

		int s = -1;
		int e = arr.length;
		int i = 0;
		int tmp;
		while (i < e) {
			if (arr[i] == 2) {
				e--;
				if (i != e) {
					tmp = arr[i];
					arr[i] = arr[e];
					arr[e] = tmp;
				}
			}

			if (arr[i] == 0) {
				s++;
				if (i != s) {
					tmp = arr[i];
					arr[i] = arr[s];
					arr[s] = tmp;
				}
			}

			i++;
		}
		System.out.println(arr);
	}

	public static void main(String[] args) {
		// leftUnique(new int[] { 1, 2, 2, 2, 3, 3, 4, 5, 6, 6, 7, 7, 8, 8, 8, 9
		// });

		sort(new int[] { 0, 1, 0, 2, 2, 1, 0 });
	}
}
