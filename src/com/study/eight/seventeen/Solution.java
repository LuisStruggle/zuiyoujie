package com.study.eight.seventeen;

/**
 * 题目：子矩阵的最大累加和问题
 * 
 * 描述：给定一个矩阵matrix，其中的值有正、有负、有0，返回子矩阵的最大累加和。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 必须含有k行的子矩阵的最大累加和
	public int maxsum(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0) {
			return 0;
		}

		int[] tmp = null; // 累加数组
		int sum = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < m.length; i++) {
			tmp = new int[m[0].length];
			for (int j = i; j < m.length; j++) {
				cur = 0;
				for (int k = 0; k < m[0].length; k++) {
					tmp[k] += m[j][k];
					cur += tmp[k];
					if (cur > sum) {
						sum = cur;
					}
					if (cur < 0) {
						cur = 0;
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.maxsum(new int[][] { { -1, -1, -1 }, { -1, 2, 2 },
				{ -1, -1, -1 } }));
	}

}
