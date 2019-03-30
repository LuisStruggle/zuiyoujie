package com.study.nine.two;

/**
 * 题目：一行代码求两个数的最大公约数
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int gcd(int m, int n) {// 更相减损法
		return m == n ? m : gcd(n, Math.abs(m - n));
	}

	public int gcd1(int m, int n) {// 辗转相除法
		return n == 0 ? m : gcd(n, m % n);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.gcd1(6, 4));
	}

}
