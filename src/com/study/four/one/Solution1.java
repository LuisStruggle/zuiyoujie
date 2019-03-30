package com.study.four.one;

/**
 * 补充题目1：给定整数N，代表台阶数，一次可以跨2个或者1个台阶，返回有多少种走法。
 * 
 * 举例：N=3，可以三次都跨1个台阶；也可以先跨2个台阶，在跨1个台阶；还可以先跨1个台阶，在跨2个台阶。所以有三种走法，返回3。
 * 
 * @author zhangyundu
 *
 */
public class Solution1 extends Solution {
	// 满足s1=1，s2=2，s3=s2+s1，s4=s3+s2等等，要么是从N-2级跨两步到N，要么是从N-1级跨一步到N
	public int s1(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		return s1(n - 1) + s1(n - 2);
	}

	public int s2(int n) {
		if (n < 1) {
			return 0;
		}
		if (n < 3) {
			return n;
		}
		int s1 = 1;
		int s2 = 2;
		int i = 3;
		int temp = s1;
		while (i <= n) {
			temp = s2;
			s2 += s1;
			s1 = temp;
			i++;
		}

		return s2;
	}

	public int s3(int n) {
		if (n < 1) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return n;
		}
		int[][] base = { { 1, 1 }, { 1, 0 } };
		int res[][] = matrixPower(base, n - 2);
		return 2 * res[0][0] + res[1][0];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		System.out.println(s.s1(8));
		System.out.println(s.s2(8));
	}

}
