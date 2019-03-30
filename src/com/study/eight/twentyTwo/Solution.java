package com.study.eight.twentyTwo;

/**
 * 题目：不包含本位置值的累乘数组
 * 
 * 描述：给定一个整型数组arr，返回不包含本位置的累乘数组。
 * 
 * 例如：arr=[2,3,1,4]，返回[12,8,24,6]，即除自己外，其他位置上的累乘。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 有除法
	public int[] product1(int[] arr) {
		if (arr == null || arr.length < 2) {
			return null;
		}

		int[] res = new int[arr.length];
		int product = 1; // 累乘结果
		int num = 0; // 统计0的个数
		int index = -1; // 0元素出现的位置
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				num++;
				index = i;
			} else {
				product *= arr[i];
			}
		}

		if (num == 1) {
			res[index] = product;
		} else if (num == 0) {
			for (int i = 0; i < arr.length; i++) {
				res[i] = product / arr[i];
			}
		}

		return res;
	}

	// 不使用除法
	public int[] product2(int[] arr) {
		if (arr == null || arr.length < 2) {
			return null;
		}

		int lr[] = new int[arr.length];
		int rl[] = new int[arr.length];
		int res[] = new int[arr.length];
		int product = 1;
		for (int i = 0; i < arr.length; i++) { // 从左到右累乘
			product *= arr[i];
			lr[i] = product;
		}

		product = 1;
		for (int i = arr.length - 1; i > -1; i--) { // 从右到左累乘
			product *= arr[i];
			rl[i] = product;
		}

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				res[i] = rl[i + 1];
			} else if (i == arr.length - 1) {
				res[i] = lr[i - 1];
			} else {
				res[i] = rl[i + 1] * lr[i - 1];
			}
		}

		return res;
	}

	// 精简product2的代码
	public int[] product3(int[] arr) {
		if (arr == null || arr.length < 2) {
			return null;
		}

		int res[] = new int[arr.length];
		res[0] = arr[0];
		for (int i = 1; i < arr.length; i++) { // 从左到右累乘
			res[i] = res[i - 1] * arr[i];
		}

		int tmp = 1;
		for (int i = arr.length - 1; i > 0; i--) { // 从右到左累乘
			res[i] = res[i - 1] * tmp;
			tmp *= arr[i];
		}
		res[0] = tmp;

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.product2(new int[] { 2, 3, 1, 4 }));
	}
}
