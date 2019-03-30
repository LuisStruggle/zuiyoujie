package com.study.nine.six;

/**
 * 题目：折纸问题
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 折叠次数2的N次方减一
	public void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	private void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.println(down ? "down" : "up");
		printProcess(i + 1, N, false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.printAllFolds(3);
		// System.out.println(Math.pow(2, 4));
	}
}
