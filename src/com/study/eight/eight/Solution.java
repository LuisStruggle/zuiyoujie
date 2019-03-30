package com.study.eight.eight;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：最长的可整合子数组的长度
 * 描述：先给出可整合数组的定义。如果一个数组在排序之后，每相邻两个数差的绝对值都为1，则该数组为可整合数组。例如，[5,3,4
 * ,6,2]排序之后为[2,3,4,5,6]，符合每相邻两个数差的绝对值都为1，所以这个数组为可整合数组。
 * 
 * 给定一个整型数组arr，请返回其中最大可整合子数组的长度。例如，[5,5,3,2,6,4,3]的最大可整合子数组[5,3,2,6,4]，所以返回5。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 从最长的子数组开始遍历，依次递减子数组的长度，直到找到符合要求的可整合子数组，停止遍历。
	public int getLIL(int[] arr) {
		int len = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				// 获取子数组
				int[] newArr = Arrays.copyOfRange(arr, i, j + 1);
				// 排序子数组
				Arrays.sort(newArr);
				// 标志位
				boolean flag = true;
				for (int k = 1; k < newArr.length; k++) {
					if (newArr[k - 1] != newArr[k] - 1) {
						flag = false;
						break;
					}
				}

				// 选取最长子数组
				if (flag) {
					len = Math.max(len, j - i + 1);
				}
			}
		}
		return len;
	}

	// 优化算法1（一个数组中如果没有重复元素，并且如果最大值减去最小值，再加上1的结果等于元素个数（max-min+1==元素个数），那么这个数组就是可整合数组）
	public int getLIL1(int[] arr) {
		int len = 0;
		int max = 0;
		int min = 0;
		Set<Integer> set = new HashSet<Integer>(); // 用来去除重复元素
		for (int i = 0; i < arr.length; i++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(arr[j])) {
					break;
				}
				set.add(arr[j]);
				max = Math.max(max, arr[j]);
				min = Math.min(min, arr[j]);

				if (max - min == j - i) {
					len = Math.max(len, j - i + 1);
				}
			}
			set.clear();
		}
		return len;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getLIL1(new int[] { 5, 5, 3, 2, 6, 4, 3 }));
	}

}
