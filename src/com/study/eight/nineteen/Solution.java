package com.study.eight.nineteen;

/**
 * 题目：数组中子数组的最大累乘积
 * 
 * 描述：给定一个double类型的数组arr，其中的元素可正、可负、可0，返回子数组累乘的最大乘积。
 * 
 * 例如，arr=[-2.5,4,0,3,0.5,8,-1]，子数组[3,0.5,8]累乘可以获得最大的乘积12，所以返回12.
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 普通方法
	public double maxProduct(double[] arr) {
		if (arr == null) {
			return 0;
		}
		double res = 1;
		double product = 0;
		for (int i = 0; i < arr.length; i++) {
			res = 1;
			for (int j = i; j < arr.length; j++) {
				res *= arr[j];
				if (res > product) {
					product = res;
				}
			}
		}
		return product;
	}

	// 思路：见课本，比较详细
	public double maxProduct1(double[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		double max = 1;
		double min = 1;
		double product = 1;
		double val1;
		double val2;
		for (int i = 0; i < arr.length; i++) {
			val1 = arr[i] * max;
			val2 = arr[i] * min;
			max = Math.max(Math.max(val1, val2), arr[i]);
			min = Math.min(Math.min(val1, val2), arr[i]);
			product = Math.max(product, max);
		}

		return product;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.maxProduct1(new double[] { -2.5, 4, 0, 3, 0.5, 8,
				-1 }));
	}

}
