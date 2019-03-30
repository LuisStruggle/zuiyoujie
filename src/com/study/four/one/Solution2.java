package com.study.four.one;

/**
 * 补充题目2：假设农场中成熟的母牛每年只会生1头小母牛，并且永远不会死。第一年农场有1只成熟的母牛，从第二年开始，母牛开始生小母牛。
 * 每只小母牛3年之后成熟又可以生小母牛。给定整数N，求出N年后牛的数量。
 * 
 * 举例：N=6，第一年1头成熟母牛记为a；第二年a生了新的小母牛，记为b，总牛数为2；第三年a生了新的小母牛，记为c，总牛数为3；第4年生了新的小母牛，
 * 记为d，总牛数为4.第五年b成熟了，a和b分别生了新的小母牛，总牛数为6；第六年c也成熟了，a、b和c分别生了新的小母牛，总牛数为9，返回9.
 * 
 * 要求：对以上所有的问题，请实现时间复杂度O(logN)的解法。
 * 
 * @author zhangyundu
 *
 */
public class Solution2 extends Solution {
	// c1=1,c2=2,c3=3,c4=c3+c1,c5=c4+c2,c6=c5+c3等等
	public int c1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n < 4) {
			return n;
		}
		return c1(n - 1) + c1(n - 3);
	}

	public int c2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n < 4) {
			return n;
		}
		int c1 = 1;
		int c2 = 2;
		int c3 = 3;
		int i = 4;
		int temp = c1;
		while (i <= n) {
			temp = c1;
			c1 = c2;
			c2 = c3;
			c3 += temp;
			i++;
		}
		return c3;
	}

	public int c3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n < 4) {
			return n;
		}
		int[][] base = { { 1, 1, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
		int[][] res = matrixPower(base, n - 3);
		return 3 * res[0][0] + 2 * res[1][0] + res[2][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution2 s = new Solution2();
		System.out.println(s.c2(7));
	}
}
