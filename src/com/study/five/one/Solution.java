package com.study.five.one;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：判断两个字符串是否互为变形词
 * 
 * 描述：给定两个字符串str1和str2，如果str1和str2中出现的字符种类一样且每种字符出现的次数也一样，那么str1和str2互为变形词。
 * 请实现函数判断两个字符串是否互为变形词。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public boolean isDeformation(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		Map<Character, Integer> map1 = new HashMap<Character, Integer>();
		Map<Character, Integer> map2 = new HashMap<Character, Integer>();
		char c;
		for (int i = 0; i < str1.length(); i++) {
			c = str1.charAt(i);
			if (map1.containsKey(c)) {
				map1.replace(c, map1.get(c) + 1);
			} else {
				map1.put(c, 1);
			}
			c = str2.charAt(i);
			if (map2.containsKey(c)) {
				map2.replace(c, map2.get(c) + 1);
			} else {
				map2.put(c, 1);
			}
		}

		boolean flag = true;

		for (Character key : map1.keySet()) {
			if (map2.containsKey(key)) {
				if (map1.get(key) != map2.get(key)) {
					flag = false;
					break;
				}
			} else {
				flag = false;
				break;
			}
		}

		if (flag) {
			return true;
		}
		return false;
	}

	public boolean isDeformation1(String str1, String str2) {
		if (str1 == null || str2 == null || str1.length() != str2.length()) {
			return false;
		}

		int[] map = new int[256];
		for (int i = 0; i < str1.length(); i++) {
			map[str1.charAt(i)]++;
		}

		for (int i = 0; i < str2.length(); i++) {
			if (map[str2.charAt(i)] != 0) {
				map[str2.charAt(i)]--;
			} else {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isDeformation1("163325256", "213325656"));
	}

}
