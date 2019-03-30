package com.study.five.seven;

/**
 * 题目：字符串的统计字符串
 * 
 * 描述：给定一个字符串str，返回str的统计字符串。例如，“aaabbadddffc”的统计字符串为“a_3_b_2_a_1_d_3_f_2_c_1”。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public String getCountString(String str) {
		if (str == null || str.equals("")) {
			return str;
		}

		int num = 1;
		char c = str.charAt(0);
		String newStr = c + "_";
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == c) {
				num++;
			} else {
				c = str.charAt(i);
				newStr += num + "_" + c + "_";
				num = 1;
			}
		}
		newStr += num;
		return newStr;
	}

	// 补充题目：给定一个字符串的统计字符串cstr，再给定一个整数index，返回cstr所代表的原始字符串上的第index个字符。例如，“a_1_b_100”多代表的原始字符串上第0个字符是’a'，第50个字符是‘b’。
	public char getCharAt(String cstr, int index) {
		if (cstr == null || cstr.equals("")) {
			return 0;
		}
		int sum = 0;
		String[] strs = cstr.split("_");
		for (int i = 1; i < strs.length; i += 2) {
			sum += Integer.valueOf(strs[i]);
			if (sum >= (index + 1)) {
				return strs[i - 1].charAt(0);
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getCharAt(
				s.getCountString("aaaaaaaaaaaaaaaabbadddffc"), 19));
		System.out.println(s.getCountString("aaaaaaaaaaaaaaaabbadddffc"));
	}

}
