package com.study.one.nine;

/**
 * 题目：求最大子矩阵的大小
 * 
 * 描述：给定一个整型矩阵map，其中的值只有0和1两种，求其中全是1的所有矩形区域中，最大的矩形区域为1的数量。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 以每一行做切割，统计当前行作为底的情况下，每个位置往上的1的数量。
	public int maxRecSize(int[][] map) {
		if (map == null || map.length == 0 || map[0].length == 0) {
			return 0;
		}
		int[] height = new int[map[0].length];
		int max = 0;
		int temp = 0;
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++) {
				height[j] = map[i][j] == 0 ? 0 : height[j] + 1;
			}
			temp = maxRecFromBotton(height);
			if (max < temp) {
				max = temp;
			}
		}
		return max;
	}

	public int maxRecFromBotton(int[] height) {// 计算以当前行为底的直方图的最大面积
		int maxArea = 0;
		int temp = 0;
		int i = 0, j = 0, k = 0;
		for (i = 0; i < height.length; i++) {
			j = i - 1;
			k = i + 1;
			while (j > -1) {
				if (height[i] <= height[j]) {
					j--;
				} else {
					break;
				}
			}
			while (k < height.length) {
				if (height[i] <= height[k]) {
					k++;
				} else {
					break;
				}
			}
			temp = (k - j - 1) * height[i];
			if (temp > maxArea) {
				maxArea = temp;
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		// System.out.println(s.maxRecSize(new int[][] { { 1, 0, 1, 1 },
		// { 1, 1, 1, 1 }, { 1, 1, 1, 0 } }));
		System.out.println(s.maxRecSize(new int[][] { { 1, 1, 1, 1 },
				{ 1, 0, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 0, 0 } }));
	}

}
