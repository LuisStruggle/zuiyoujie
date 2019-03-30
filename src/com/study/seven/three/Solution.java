package com.study.seven.three;

/**
 * 题目：只用位运算不用算术运算实现整数的加减乘除运算
 * 
 * 描述：给定两个32位整数a和b，可正、可负、可0.不能使用算术运算符，分别实现a和b的加减乘除运算。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 解释见课本
	public int add(int a, int b) {
		int sum = a;
		while (b != 0) {
			sum = a ^ b;
			b = (a & b) << 1;
			a = sum;
		}
		return sum;
	}

	// 得到a+（-b），得到一个数的相反数，就是该数的二进制数表达取反加一（补码）的结果。
	public int minus(int a, int b) {
		b = add(~b, 1);

		return add(a, b);
	}

	public int multi(int a, int b) {
		int res = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				res = add(res, a);
			}
			a <<= 1; // 把a左移一位（相当于乘以2）
			b >>>= 1; // 把b右移一位，忽略最高位符号位，都补0
		}
		return res;
	}

	public int div(int a, int b) {
		// 除法适用于整数，因此数a或b为负数，要转为对应的相反数
		int x = isNeg(a) ? add(~a, 1) : a;
		int y = isNeg(b) ? add(~b, 1) : b;
		int res = 0;
		for (int i = 31; i > -1; i = minus(i, 1)) {
			if ((x >> i) >= y) {
				res |= (1 << i);
				x = minus(x, y << i);
			}
		}
		return isNeg(a) ^ isNeg(b) ? add(~res, 1) : res;
	}

	public boolean isNeg(int n) {
		return n < 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.add(3, 10));
		System.out.println(s.minus(3, 5));
		System.out.println(s.multi(3, 5));
		System.out.println(s.div(6, 2));
	}

}
