package com.study.five.six;

/**
 * 题目：替换字符串中连续出现的指定字符串
 * 
 * 描述：给定三个字符串str、from和to，已知from字符串中无重复字符，把str中所有from的子串全部替换成to字符串，
 * 对连续出现from的部分要求只要替换成一个to字符串，返回最终的结果字符串。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public String replace(String str, String from, String to) {
		if (str == null || from == null || str.equals("") || from.equals("")) {
			return str;
		}

		int num = 0;
		int nextStart = str.indexOf(from, 0);
		int start = nextStart;
		while (start != -1) {
			nextStart = str.indexOf(from, start + 1);
			if (nextStart - start == from.length()) {
				num++;
				start = nextStart;
			} else {
				str = str.substring(0, start - num * from.length()) + to
						+ str.substring(start + from.length());
				if (nextStart == -1) {
					start = nextStart;
				} else {
					start = to.length() - (num + 1) * from.length() + nextStart;
				}
				num = 0;
			}
		}
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.replace("123abcabc23abcabc222abc", "2", "W"));
	}

}
