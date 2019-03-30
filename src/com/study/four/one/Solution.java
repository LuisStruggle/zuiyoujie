package com.study.four.one;

/**
 * 题目：给定整数N，返回菲波那切数列的第N项。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 实现菲波那切数列O(2的N次方)
	public int fibonacci(int n) {
		if (n < 1) {
			return 0;
		}
		if (n > 2) {
			return fibonacci(n - 1) + fibonacci(n - 2);
		} else {
			return 1;
		}
	}

	// O(N)的方法
	public int fibonacci1(int n) {
		if (n < 1) {
			return 0;
		}
		int i = 3;
		int f1 = 1;
		int f2 = 1;
		int temp = f1;
		while (i <= n) {
			temp = f1;
			f1 = f2;
			f2 += temp;
			i++;
		}
		return f2;
	}

	// O(logN)的方法
	public int fibonacci2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int res[][] = matrixPower(base, n - 2);
		return res[0][0] + res[1][0];
	}

	// 两个二维矩阵的乘法
	public int[][] muliMatrix(int[][] m1, int[][] m2) {
		int res[][] = new int[m1.length][m2[0].length]; // m1的行，m2的列
		for (int i = 0; i < m1.length; i++) {
			for (int j = 0; j < m2[0].length; j++) {
				for (int k = 0; k < m2.length; k++) {
					res[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return res;
	}

	// 矩阵的幂运算
	public int[][] matrixPower(int[][] m, int p) {
		int[][] res = new int[m.length][m[0].length];
		// 先把res设为单位矩阵，相当于整数中的1
		for (int i = 0; i < res.length; i++) {
			res[i][i] = 1;
		}

		int[][] tmp = m; // 累乘矩阵
		for (; p != 0; p >>= 1) {// 折半累乘
			if ((p & 1) != 0) {
				res = muliMatrix(res, tmp);
			}
			tmp = muliMatrix(tmp, tmp);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.fibonacci2(5));

		int p = 8;
		System.out.println(p >>= 1); // 右移一位，并赋值给p。相当于除以2，并赋值给p。
	}

}
