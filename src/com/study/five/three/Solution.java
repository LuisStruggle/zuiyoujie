package com.study.five.three;

/**
 * 题目：去掉字符串中连续出现k个0的子串
 * 
 * 描述：给定一个字符串str和一个整数k，如果str中正好有连续的k个‘0’字符出现时，把k个连续的‘0’字符去除，返回处理后的字符串。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public String removeKZeros(String str, int k) {
		if (str == null || str.isEmpty() || k < 1) {
			return str;
		}
		int num = 0;
		int index = 0;
		while (index < str.length()) {
			if (str.charAt(index) == '0') {
				num++;
			} else {
				if (num == k) {
					str = str.substring(0, index - k) + str.substring(index);
					index -= k;
				}
				num = 0;
			}
			index++;
		}

		if (num == k) {
			str = str.substring(0, index - k) + str.substring(index);
		}

		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.removeKZeros("A00B0c00d000A00", 2));
	}

}
