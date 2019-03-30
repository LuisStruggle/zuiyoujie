package com.study.eight.three;

/**
 * 题目：“之”字形打印矩阵 描述：给定一个矩阵matrix，按照“之”字形的方式打印这个矩阵
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 上下坐标都从（0,0）坐标开始，上坐标先右后下移动，下坐标先下后右移动，每次打印出上下坐标连线上的所有坐标点。第一次按左下到右上方向连线，第二次只能是右上到左下方向连线，以此类推……
	public void printMatrixZigZag(int[][] matrix) {
		int tR = 0, tC = 0, dR = 0, dC = 0;
		int row = matrix.length;
		int col = matrix[0].length;
		for (int i = 1; i < row + col; i++) {
			if (i % 2 == 1) {
				int r = dR, c = dC;
				// 先左下开始（打印出从左下到右上的所有点）
				while (r >= tR) {
					System.out.print(matrix[r][c] + " ");
					r--;
					c++;
				}
			} else {
				int r = tR, c = tC;
				// 先右上开始（打印出从右上到左下的所有点）
				while (r <= dR) {
					System.out.print(matrix[r][c] + " ");
					r++;
					c--;
				}
			}
			if (tC != col - 1) {
				tC++;
			} else {
				tR++;
			}
			if (dR != row - 1) {
				dR++;
			} else {
				dC++;
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 },
				{ 21, 22, 23, 24 } };
		s.printMatrixZigZag(matrix);
	}

}
