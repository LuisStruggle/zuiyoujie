package com.study.eight.twentyFour;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：求最短通路值
 * 
 * 描述：用一个整型矩阵matrix表示一个网格，1代表有路，0代表无路，每一个位置只要不越界，都有上下左右4个方向，求从最左上角到最右下角的最短通路值。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 使用宽度优先遍历（上下左右四个方位有1，累加，并有一个队列可以朝四个方向走）
	public static int minPathValue(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0 || m[0][0] != 1
				|| m[m.length - 1][m[0].length - 1] != 1) {// 不满足题目要求的条件
			return 0;
		}

		int res = 0; // 记录最短路径的结果
		int[][] map = new int[m.length][m[0].length];
		map[0][0] = 1;
		Queue<Integer> rQ = new LinkedList<Integer>(); // 行坐标队列
		Queue<Integer> cQ = new LinkedList<Integer>(); // 列坐标队列

		rQ.add(0);
		cQ.add(0);

		int r = 0;
		int c = 0;
		while (!rQ.isEmpty()) {
			r = rQ.poll();
			c = cQ.poll();
			if (r == m.length - 1 && c == m[0].length - 1) {
				return map[r][c];
			}
			walkTo(map[r][c], r - 1, c, m, map, rQ, cQ); // up
			walkTo(map[r][c], r + 1, c, m, map, rQ, cQ); // down
			walkTo(map[r][c], r, c - 1, m, map, rQ, cQ); // left
			walkTo(map[r][c], r, c + 1, m, map, rQ, cQ); // right
		}

		return res;
	}

	private static void walkTo(int pre, int toR, int toC, int[][] m,
			int[][] map, Queue<Integer> rQ, Queue<Integer> cQ) {
		// TODO Auto-generated method stub
		if (toR < 0 || toR == m.length || toC < 0 || toC == m[0].length
				|| m[toR][toC] != 1 || map[toR][toC] != 0) { // map[toR][toC]
																// 防止回走的一个重要的条件
			return;
		}
		map[toR][toC] = pre + 1;
		rQ.add(toR);
		cQ.add(toC);
	}

	public static void main(String[] args) {
		System.out.println(minPathValue(new int[][] { { 1, 0, 1, 1, 1 },
				{ 1, 0, 1, 0, 1 }, { 1, 1, 1, 0, 1 }, { 0, 0, 0, 0, 1 } }));
	}
}
