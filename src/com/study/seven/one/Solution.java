package com.study.seven.one;

/**
 * 题目：不用额外的空间交换两个整数的值
 * 
 * 描述：如果不用任何额外变量交换两个整数的值？
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 异或运算，对应位不用为1。0与任何数异或为那个数本身。两个相同的数异或为0。
	public void exchange(int a, int b) {
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + "," + b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.exchange(7, 3);
	}

}
