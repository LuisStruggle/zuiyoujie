package com.study.eitht.two;

import java.util.Arrays;

/**
 * 题目：将正方形矩阵顺时针旋转90° 描述：给定一个NxN的矩阵matrix，把这个矩阵调整成顺时针转动90°后的形式。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public void rotateMatrix(int[][] matrix) {
		int tR = 0, tC = 0;
		int dR = matrix.length - 1, dC = matrix[0].length - 1;
		// 思路：一圈一圈的调换位置，上和右换，右和下换，下和左换，左和上换
		while (tR < dR && tC < dC) {
			// 计算一次调整的元素个数
			int count = dR - tR;
			int tmp = 0;
			for (int i = 0; i < count; i++) {
				tmp = matrix[tR][tC + i];
				matrix[tR][tC + i] = matrix[dR - i][tC];
				matrix[dR - i][tC] = matrix[dR][dC - i];
				matrix[dR][dC - i] = matrix[tR + i][dC];
				matrix[tR + i][dC] = tmp;
			}
			tR++;
			tC++;
			dR--;
			dC--;
		}
		System.out.println(Arrays.toString(matrix[3]));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		int[][] matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 },
				{ 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		s.rotateMatrix(matrix);
	}

}
