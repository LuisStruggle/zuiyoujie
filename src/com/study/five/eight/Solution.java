package com.study.five.eight;

import java.util.Arrays;

/**
 * 题目：判断字符数组中是否所有的字符都只出现过一次
 * 
 * 描述：给定一个字符类型数组chas[]，判断chas中是否所有的字符都只出现过一次，请根据以下不同的两种要求实现两个函数。
 * 
 * 举例：chas=['a','b','c']，返回true：chas=['1','2','1']，返回false。
 * 
 * 要求： 1、实现时间复杂度为O（N）的方法。
 * 
 * 2、在保证额外空间复杂度为O（1）的前提下，请实现时间复杂度尽量低的方法。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 满足要求1
	public boolean isUnique1(char[] chas) {
		if (chas == null) {
			return false;
		}
		int[] arr = new int[256];
		for (char c : chas) {
			if (arr[c] == 0) {
				arr[c]++;
			} else {
				return false;
			}
		}
		return true;
	}

	// 满足要求2（按值排序，判断相邻的元素）
	public boolean isUnique2(char[] chas) {
		if (chas == null) {
			return false;
		}
		Arrays.sort(chas); // 该题中，应该用非递归的堆排序，技能满足空间复杂度为O（1），时间复杂度相对较小一些。
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == chas[i - 1]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isUnique1(new char[] { '1', '2', '3' }));
		System.out.println(s.isUnique2(new char[] { '1', '2', '4', '0', '3',
				'8' }));
	}

}
