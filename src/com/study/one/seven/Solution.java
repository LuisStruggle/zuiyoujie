package com.study.one.seven;

import java.util.LinkedList;

/**
 * 题目：生成窗口最大值数组
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int[] getMaxWindow(int[] arr, int w) {
		if (arr == null || w > arr.length || w < 1) {
			return null;
		}

		int[] res = new int[arr.length - w + 1];
		int maxValue = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (maxValue < arr[i]) {
				maxValue = arr[i];
			}
			if (i >= w) {
				if (arr[i - w] == maxValue) {
					maxValue = arr[i - w + 1];
					for (int j = i - w + 2; j <= i; j++) {
						if (maxValue < arr[i]) {
							maxValue = arr[i];
						}
					}
				}
			}
			if (i >= (w - 1)) {
				res[i + 1 - w] = maxValue;
			}
		}
		return res;
	}

	// 利用其它数据结构实现
	public int[] getMaxWindow1(int[] arr, int w) {
		if (arr == null || w > arr.length || w < 1) {
			return null;
		}
		LinkedList<Integer> qmax = new LinkedList<Integer>(); // 双端队列
		int[] res = new int[arr.length - w + 1];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) { // 末尾填充最大值的位置
				qmax.pollLast();
			}
			qmax.addLast(i);
			if (qmax.peekFirst() == i - w) {// 判断最大值是否在当前范围内，不再则移除。
				qmax.pollFirst();
			}
			if (i >= w - 1) {
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getMaxWindow1(
				new int[] { 4, 3, 5, 4, 3, 3, 6, 7 }, 3));
	}

}
