package com.study.eight.twentyOne;

/**
 * 题目：边界都是1的最大正方形大小
 * 
 * 描述：给定一个N*N的矩阵matrix，在这个矩阵中，只有0和1两种值，返回边框全是1的最大正方形的边长长度。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 普通方法：以每一个定点作为正方形的左上角，每次检查四条边是否为1，时间复杂度为O(N的四次方)
	public int getMaxSize(int[][] m) {
		if (m == null || m.length == 0) {
			return 0;
		}

		int res = 0;
		int len = m.length;
		boolean flag = true;

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				ok: for (int k = (len - Math.max(i, j)); k > 0; k--) { // 边的可能长度
					flag = true;
					// 上边
					for (int l = j; l < (j + k); l++) {
						if (m[i][l] != 1) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						break;
					}
					// 右边
					for (int l = i; l < (i + k); l++) {
						if (m[l][j + k - 1] != 1) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						break;
					}
					// 下边
					for (int l = j; l < (j + k); l++) {
						if (m[i + k - 1][l] != 1) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						break;
					}
					// 左边
					for (int l = i; l < (i + k); l++) {
						if (m[l][j] != 1) {
							flag = false;
							break;
						}
					}
					if (!flag) {
						break;
					} else {
						res = Math.max(res, k);
						break ok;
					}
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getMaxSize(new int[][] { { 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 1 }, { 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 1, 1 } }));
		System.out.println(s.getMaxSize(new int[][] { { 1, 1 }, { 1, 1 } }));
	}
}
