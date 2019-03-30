package com.study.five.five;

/**
 * 题目：将整数字符串转成整数值
 * 
 * 描述：给定一个字符串str，如果str符合日常书写的整数形式，并且属于32位整数的范围，返回str所代表的整数值，否则返回0.
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int convert(String str) {
		int res = 0;
		if (str == null || str.equals("")) {
			return res;
		}

		boolean flag = isValid(str.toCharArray());
		if (flag) {
			int minValue = Integer.MIN_VALUE;
			int maxValue = Integer.MAX_VALUE;
			if (str.startsWith("-")) {
				for (int i = 1; i < str.length(); i++) {
					if (minValue - res * 10 <= ('0' - str.charAt(i))) {
						res = res * 10 + '0' - str.charAt(i);
					} else {
						res = 0;
						break;
					}
				}
			} else {
				for (int i = 0; i < str.length(); i++) {
					if (maxValue - res * 10 >= (str.charAt(i) - '0')) {
						res = res * 10 + (str.charAt(i) - '0');
					} else {
						res = 0;
						break;
					}
				}
			}
		}
		return res;
	}

	public boolean isValid(char[] chas) {
		char firstC = chas[0];
		int num = firstC - '0';
		if ((firstC != '-') && (num < 0 || num > 9)) {
			return false;
		}
		if (firstC == '-') {
			if (chas.length == 1) {
				return false;
			} else if (chas[1] == '0') {
				return false;
			}
		}
		if (firstC == '0') {
			if (chas.length > 1) {
				return false;
			}
		}

		for (int i = 1; i < chas.length; i++) {
			num = chas[i] - '0';
			if (num < 0 || num > 9) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.convert("-2147483649"));
	}
}
