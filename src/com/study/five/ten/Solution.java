package com.study.five.ten;

/**
 * 题目：字符串的调整与替换
 * 
 * 描述：给定一个字符类型的数组chas[]，chas右半区全是空字符，左半区不含有空字符。现在想将左半区中所有的空格字符替换成“%20”，
 * 假设chas右半区足够大，可以满足替换所需要的空间，请完成替换函数。
 * 
 * 举例：如果把chas的左半区看作字符串，为“a b c”，假设chas的右半区足够大。替换后，chas的左半区为“a%20b%20%20c”。
 * 
 * 要求：替换函数的时间复杂度为O（N），额外空间复杂度为O（1）。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 一种思路，转换成字符串，替换完成，在遍历字符串，赋值到chas[]中
	public void replace(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		String str = String.valueOf(chas); // 不能
		str = str.replaceAll(" ", "%20");
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 0) {
				chas[i] = str.charAt(i);
			} else {
				break;
			}
		}
		System.out.println(chas);
	}

	// 另外一种，第一遍统计空格数，第二遍从后向前，移非空的字符，并添加替换的字符
	public void replace1(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int numNull = 0;
		for (char c : chas) {
			if (c == ' ') {
				numNull++;
			}
		}

		for (int i = chas.length - 1; i > -1; i--) {
			if (chas[i - numNull * 2] != ' ') {
				chas[i] = chas[i - numNull * 2];
			} else {
				numNull--;
				chas[i] = '0';
				chas[--i] = '2';
				chas[--i] = '%';
			}
		}
		System.out.println(chas);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		char[] chas = new char[20];
		chas[0] = 'a';
		chas[1] = ' ';
		chas[2] = 'b';
		chas[3] = ' ';
		chas[4] = ' ';
		chas[5] = 'c';
		s.replace1(chas);
	}

}
