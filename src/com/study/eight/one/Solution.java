package com.study.eight.one;

/**
 * 题目：转圈打印矩阵 描述：给定一个整型矩阵matrix，请按照转圈的方式打印它。 例如： 1 2 3 4 5 6 7 8 9 10 11 12 13 14
 * 15 16 打印结果为：1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 * 
 * @author zhangyundu
 *
 */
public class Solution {

	public void spiralOrderPrint(int[][] matrix) {
		int tR = 0, tC = 0;
		int dR = matrix.length - 1, dC = matrix[0].length - 1;
		while (tR < dR && tC < dC) {
			// 打印顺序，上右下左
			for (int i = tR; i <= dC; i++) {
				System.out.print(matrix[tR][i] + " ");
			}
			for (int i = tR + 1; i <= dR; i++) {
				System.out.print(matrix[i][dC] + " ");
			}
			for (int i = dC - 1; i >= tC; i--) {
				System.out.print(matrix[dR][i] + " ");
			}
			for (int i = dR - 1; i > tR; i--) {
				System.out.print(matrix[i][tC] + " ");
			}
			tR++;
			tC++;
			dR--;
			dC--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		s.spiralOrderPrint(matrix);
	}

}
