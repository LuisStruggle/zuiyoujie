package com.study.seven.four;

/**
 * 题目：整数的二进制表达式中有多少个1
 * 
 * 描述：给定一个32位整数n，可为0，可为正，也可以负，返回该整数二进制表达中1的个数。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int count1(int n) {
		int num = 0;
		while (n != 0) {
			num += n & 1;
			n >>>= 1;
		}
		return num;
	}

	// 上述方法在最复杂的情况下要经过32次循环，下面看一个循环次数只与1的个数有关的解法。
	public int count2(int n) {
		int res = 0;
		while (n != 0) {
			// n&=(n-1)实质是抹掉n的二进制最右边的1，每次循环抹掉一个
			n &= (n - 1);
			res++;
		}
		return res;
	}

	// 与count2方法复杂度一样的
	public int count3(int n) {// 解释见课本
		int res = 0;
		while (n != 0) {
			n -= n & (~n + 1);
			res++;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
