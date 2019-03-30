package com.study.seven.two;

/**
 * 题目：不用任何比较判断找出两个数中较大的数
 * 
 * 描述：给定两个32位整数a和b，返回a和b中较大的。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 得到a-b的值的符号，就可以知道是返回a还是返回b。
	public int getMax(int a, int b) {
		int c = a - b;
		int scA = ((c >> 31) & 1) ^ 1;
		int scB = (scA ^ 1);
		return scA * a + scB * b;
	}

	// 该方法能有效解决a-b的值溢出的问题（解释看课本）
	public int getMax1(int a, int b) {
		int c = a - b;
		int sa = ((a >> 31) & 1) ^ 1;
		int sb = ((b >> 31) & 1) ^ 1;
		int sc = ((c >> 31) & 1) ^ 1;
		int difSab = sa ^ sb;
		int sameSab = difSab ^ 1;
		int returnA = difSab * sa + sameSab * sc;
		int returnB = returnA ^ 1;
		return a * returnA + b * returnB;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getMax(3, 5));
		System.out.println(3 >> 31);
		System.out.println(-3 >> 31);
		System.out.println(0 >> 31);
		System.out.println(s.getMax1(13, 5));
	}

}
