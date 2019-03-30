package com.study.five.four;

/**
 * 题目：判断两个字符串是否为旋转词
 * 
 * 描述：如果一个字符串str，把字符串str前面任意的部分挪到后面形成的字符串叫作str的旋转词。比如：str=“12345”，str的旋转词有“12345
 * ”、“23451”、“34512”、“45123”、和“51234”。给定两个字符串a和b，请判断a和b是否为旋转词。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public boolean isRotation(String a, String b) {
		if (a == null || b == null || a.length() != b.length()) {
			return false;
		}

		int len = a.length();
		char c;
		for (int i = 0; i < len; i++) {
			if (a.equals(b)) {
				return true;
			}
			c = a.charAt(len - 1);
			a = c + a.substring(0, len - 1);
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isRotation("1234", "2341"));
	}

}
