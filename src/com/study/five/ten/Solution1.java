package com.study.five.ten;

/**
 * 补充题目：给定一个字符类型的数组chas[]，其中只含有数字字符和“*”字符。现在想把所有的“*”字符挪到chas的左边，数字字符挪到chas的右边。
 * 请完成调整函数。
 * 
 * 举例：如果把chas看作字符串，为“12**345”。调整后chas为“**12345”。
 * 
 * 要求： 1，调整函数的时间复杂度为O(N)，额外空间复杂度为O(1)。
 * 
 * 2，不得改变数字字符从左到右出现的顺序。
 * 
 * 
 * @author zhangyundu
 *
 */
public class Solution1 {
	public void modify(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}
		int len = chas.length - 1;
		int j = len;
		for (int i = len; i > -1; i--) {
			if (chas[i] != '*') {
				chas[j--] = chas[i];
			}
		}

		while (j > -1) {
			chas[j--] = '*';
		}

		System.out.println(chas);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s1 = new Solution1();
		s1.modify(new char[] { '1', '*', '*', '2', '3' });
	}
}
