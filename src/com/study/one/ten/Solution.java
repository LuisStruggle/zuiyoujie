package com.study.one.ten;

import java.util.LinkedList;

/**
 * 题目：最大值减去最小值小于或等于num的子数组数量
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 普通方法，遍历所有的子数组，查找满足要求的
	public int getNum(int[] arr, int num) {
		if (arr == null) {
			return 0;
		}
		int count = 0;
		int max, min;
		for (int i = 0; i < arr.length; i++) {
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int j = i; j < arr.length; j++) {
				if (max < arr[j]) {
					max = arr[j];
				}
				if (min > arr[j]) {
					min = arr[j];
				}
				if (max - min <= num) {
					count++;
				}
			}
		}
		return count;
	}

	// 时间复杂度为O（N）的方法
	public int getNum1(int[] arr, int num) {
		if (arr == null) {
			return 0;
		}
		LinkedList<Integer> qmin = new LinkedList<Integer>();
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int i = 0, j = 0, count = 0;
		while (i < arr.length) {
			while (j < arr.length) {// 约束[i,j]的区间，判断区间中是否满足。如果满足，则[i,j]区间中的都满足，如果不满足，则包含[i,j]区间的都不满足
				while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[j]) {
					qmin.pollLast();
				}
				qmin.addLast(j);
				while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[j]) {
					qmax.pollLast();
				}
				qmax.addLast(j);
				if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
					break;
				}
				j++;
			}
			// 在i到j范围内满足，然后，i++，进去遍历所有满足的，以及可能新的满足的空间。
			if (qmin.peekFirst() == i) {
				qmin.pollFirst();
			}
			if (qmax.peekFirst() == i) {
				qmax.pollFirst();
			}
			count += j - i;
			i++;
		}

		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getNum1(new int[] { 1, 2, 3, 4, 5 }, 1));
	}

}
