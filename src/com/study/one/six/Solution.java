package com.study.one.six;

import java.util.Stack;

/**
 * 题目：用栈来求解汉诺塔问题
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 方法一：递归的方法
	public int hanoiProblem1(int num, String left, String mid, String right) {

		return 0;
	}

	// 方法二：非递归的方法，用栈来模拟汉诺塔的三个塔。
	public int hanoiProblem2(int num, String left, String mid, String right) {
		if (num < 1) {
			return 0;
		}
		int step = 0;
		Stack<Integer> ls = new Stack<Integer>();
		Stack<Integer> ms = new Stack<Integer>();
		Stack<Integer> rs = new Stack<Integer>();

		for (int i = num; i > 0; i--) {
			ls.push(i); // 构造最边的塔
		}

		while (!ls.isEmpty() || !ms.isEmpty()) {
			if (ls.isEmpty()) {
				if (rs.isEmpty() || ms.peek() < rs.peek()) {
					step++;
					rs.push(ms.pop());
					System.out.println("Move " + rs.peek() + " from " + mid
							+ " to " + right);
				} else {
					step++;
					ms.push(rs.pop());
					System.out.println("Move " + ms.peek() + " from " + right
							+ " to " + mid);

					step++;
					ls.push(ms.pop());
					System.out.println("Move " + ls.peek() + " from " + mid
							+ " to " + left);
				}
			} else if (ms.isEmpty()) {// mid为空
				if (rs.isEmpty() || ls.peek() > rs.peek()) {
					step++;
					ms.push(ls.pop());
					System.out.println("Move " + ms.peek() + " from " + left
							+ " to " + mid);
				} else {
					step++;
					ms.push(rs.pop());
					System.out.println("Move " + ms.peek() + " from " + right
							+ " to " + mid);
				}
			} else {// 两者均不为空
				if (ls.peek() < ms.peek()) {// 中大左
					if (rs.isEmpty() || ms.peek() < rs.peek()) {
						step++;
						rs.push(ms.pop());
						System.out.println("Move " + rs.peek() + " from " + mid
								+ " to " + right);
					} else {
						step++;
						ms.push(ls.pop());
						System.out.println("Move " + ms.peek() + " from "
								+ left + " to " + mid);
					}
				} else {// 左大中
					if (rs.isEmpty() || ms.peek() < rs.peek()) {
						rs.push(ms.pop());
						System.out.println("Move " + rs.peek() + " from " + mid
								+ " to " + right);
					} else {
						step++;
						ls.push(ms.pop());
						System.out.println("Move " + ls.peek() + " from " + mid
								+ " to " + left);
					}
				}
			}
		}
		return step;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.hanoiProblem2(2, "left", "mid", "right"));
	}

}
