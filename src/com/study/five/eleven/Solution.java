package com.study.five.eleven;

/**
 * 题目：翻转字符串
 * 
 * 描述：给定一个字符类型的数组chas，请在单词间做逆序调整。只要做到单词顺序逆序即可，对空格的位置没有特别要求。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public void rotateWord(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}

		String str = String.valueOf(chas);
		String[] strs = str.split(" ");
		System.out.println(strs.length);
		str = "";
		for (int i = strs.length - 1; i > 0; i--) {
			str += strs[i] + " ";
		}
		str += strs[0];

		chas = str.toCharArray();

		System.out.println(chas);

	}

	// 整体逆序，然后找到每个单词逆序
	public void rotateWord1(char[] chas) {
		if (chas == null || chas.length == 0) {
			return;
		}

		reverse(chas, 0, chas.length - 1);

		System.out.println(chas);

		// 逆序每一个单词
		int start = 0;
		int end = start;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] == ' ') {
				reverse(chas, start, end - 1);
				start = end + 1;
				end = start;
			} else {
				end++;
			}
		}

		System.out.println(chas);
	}

	public void reverse(char[] chas, int start, int end) {
		char tmp = 0;
		while (start < end) {
			tmp = chas[start];
			chas[start] = chas[end];
			chas[end] = tmp;
			start++;
			end--;
		}
	}

	// 补充问题：给定一个字符类型的数组chas和一个整数size，请把大小为size的左半区整体移到右半区，右半区整体移到左边。
	public void rotate1(char[] chas, int size) {
		if (chas == null || size < 0 || size >= chas.length) {
			return;
		}
		reverse(chas, 0, size - 1);
		reverse(chas, size, chas.length - 1);
		reverse(chas, 0, chas.length - 1);
	}

	public void rotate2(char[] chas, int size) {
		if (chas == null || size < 0 || size >= chas.length) {
			return;
		}
		int start = 0;
		int lpart = size;
		int rpart = chas.length - lpart;
		int s = Math.min(lpart, rpart);
		int end = lpart > rpart ? size : chas.length - s;
		int d = lpart - rpart;

		while (true) {
			if (lpart > 0 && rpart > 0) { // 交换
				exchange(chas, start, end);
				start++;
				end++;
				lpart--;
				rpart--;
			} else {
				if (lpart == 0 && rpart == 0) {
					break;
				}

				if (lpart == 0) {
					start = start - s;
					lpart = s;
				}

				if (rpart == 0) {
					rpart = s;
				}

				if (d < 0) {
					if (lpart < rpart) {
						end = end - s - lpart;
					} else {
						end = end - s - rpart;
					}
				} else {
					if (lpart < rpart) {
						end = end - lpart;
					} else {
						end = end - rpart;
					}
				}

				s = Math.min(lpart, rpart);
				d = lpart - rpart;
			}
		}
		System.out.println(chas);
	}

	public void exchange(char[] chas, int start, int end) {
		char tmp = chas[start];
		chas[start] = chas[end];
		chas[end] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.rotateWord1(new char[] { 'd', 'o', 'g', ' ', 'l', 'o', 'v', 'e', 's',
				' ', 'p', 'i', 'g' });

		s.rotate2(new char[] { '1', '2', '3', '4', '5', '6', '7', 'A', 'B',
				'C', 'D' }, 10);
	}

}
