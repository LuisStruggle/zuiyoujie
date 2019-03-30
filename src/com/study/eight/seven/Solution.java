package com.study.eight.seven;

/**
 * 题目：在行列都排好序的矩阵中找数
 * 描述：给定一个有NxM的整型矩阵matrix和一个整数k，matrix的每一行和每一列都是排好序的。实现一个函数，判断k是否存在matrix中。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 现在行里面比较，再列里面比较
	public boolean isContains(int[][] matrix, int x) {
		boolean flag = false;
		for (int i = 0; i < matrix.length; i++) {
			if (x <= matrix[i][matrix[0].length - 1]) {
				for (int j = matrix[0].length - 1; j >= 0; j--) {
					if (x == matrix[i][j]) {
						flag = true;
						break;
					} else if (x > matrix[i][j]) {
						break;
					}
				}
			}
		}
		return flag;
	}

	public boolean isContains1(int[][] matrix, int x) {
		int row = 0;
		int col = matrix[0].length - 1;
		while (row < matrix.length && col > -1) {
			if (matrix[row][col] == x) {
				return true;
			} else if (matrix[row][col] > x) {
				col--;
			} else {
				row++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.isContains(new int[][] { { 0, 1, 2, 5 },
				{ 2, 3, 4, 7 }, { 4, 4, 4, 8 }, { 5, 7, 7, 9 } }, 7));
	}

}
