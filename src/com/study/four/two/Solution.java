package com.study.four.two;

/**
 * 题目：给定一个矩阵m，从左上角开始每次只能向右或向下走，最后到达右下角的位置，路径上所有的数字累加起来就是路径和，返回所有路径中最小的路径和。
 * 
 * 举例：如果给定的m如下：[[1 3 5 9],[8 1 3 4],[5 0 6 1],[8 8 4
 * 0]]，路径1,3,1,0,6,1,0是所有路径中路径和最小的，所以返回12.
 * 
 * 
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int minPathSum1(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int[][] nm = new int[row][col];
		// 统计第一行，依次往右的和
		int sum = 0;
		for (int i = 0; i < col; i++) {
			sum += m[0][i];
			nm[0][i] = sum;
		}
		sum = 0;
		// 统计第一列，依次往下的和
		for (int i = 0; i < row; i++) {
			sum += m[i][0];
			nm[i][0] = sum;
		}
		// 计算其它位置的和，“当前值加其上的值”和“当前值加其左的值”的比值中，选择最小的
		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				if (nm[i - 1][j] > nm[i][j - 1]) {
					nm[i][j] = nm[i][j - 1] + m[i][j];
				} else {
					nm[i][j] = nm[i - 1][j] + m[i][j];
				}
			}
		}

		return nm[row - 1][col - 1];
	}

	// 压缩空间，使O(MxN)的空间复杂，变为O(Min{M,N})
	public int minPathSum2(int[][] m) {
		if (m == null || m.length == 0 || m[0] == null || m[0].length == 0) {
			return 0;
		}
		int row = m.length;
		int col = m[0].length;
		int len = (row > col ? col : row);
		int[] temp = new int[len];
		temp[0] = m[0][0];
		for (int i = 1; i < len; i++) {
			if (row >= col) {
				temp[i] = m[0][i] + temp[i - 1];
			} else {
				temp[i] = m[i][0] + temp[i - 1];
			}
		}

		if (row >= col) {
			for (int i = 1; i < row; i++) {
				temp[0] += m[i][0];
				for (int j = 1; j < col; j++) {
					if (temp[j] > temp[j - 1]) {
						temp[j] = m[i][j] + temp[j - 1];
					} else {
						temp[j] += m[i][j];
					}
				}
			}
		} else {
			for (int i = 1; i < col; i++) {
				temp[0] += m[0][i];
				for (int j = 1; j < row; j++) {
					if (temp[j] > temp[j - 1]) {
						temp[j] = m[j][i] + temp[j - 1];
					} else {
						temp[j] += m[j][i];
					}
				}
			}
		}
		return temp[len - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.minPathSum2(new int[][] { { 1, 3, 5, 9 },
				{ 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } }));
	}

}
