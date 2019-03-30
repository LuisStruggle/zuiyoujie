package com.study.five.two;

/**
 * 题目：字符串中数字子串的求和
 * 
 * 描述：给定一个字符串str，求其中全部数字串所代表的数字之和。
 * 
 * 要求：
 * 
 * 1，忽略小数点字符，例如“A1.3”，其中包含两个数字1和3.
 * 
 * 2，如果紧贴数字子串的左侧出现字符“-”，当连续出现的数量为奇数时，则数字视为负，连续出现的数量为偶数时，则数字视为正。例如，“A-1BC--12”，
 * 其中包含数字为-1和12.
 * 
 * @author zhangyundu
 *
 */
public class Solution {

	public int numSum(String str) {
		String zStr = "";
		int sum = 0;
		str += "E"; // 扩充一个字符长度，方便遍历
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 58 && str.charAt(i) > 47) {
				zStr += str.charAt(i);
			} else {
				if (!zStr.equals("") && !zStr.endsWith("-")) {
					sum += Integer.valueOf(zStr);
					zStr = "";
				}

				if (str.charAt(i) == '-') {
					zStr = (zStr.isEmpty()) ? "-" : "";
				} else {
					zStr = "";
				}
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.numSum("-a--2----4---b--234---23-"));
	}
}
