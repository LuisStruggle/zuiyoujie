package com.study.eight.twentySix;

import java.util.Arrays;

/**
 * 题目：数组排序之后相邻数的最大差值
 * 
 * 描述：给定一个整型数组arr，返回排序后的相邻两数的最大差值。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int maxGap(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}

		// 排序
		Arrays.sort(nums);

		int pre = nums[0];
		int max = 0;
		for (int i = 1; i < nums.length; i++) {
			if ((nums[i] - pre) > max) {
				max = nums[i] - pre;
			}
			pre = nums[i];
		}
		return max;
	}

	// O(N)时间复杂度
	public int maxGap1(int[] nums) {
		if (nums == null || nums.length < 2) {
			return 0;
		}
		int len = nums.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < len; i++) {
			min = Math.min(min, nums[i]);
			max = Math.max(max, nums[i]);
		}

		if (min == max) {
			return 0;
		}

		boolean[] hasNum = new boolean[len + 1]; // 判断当前桶号中，是否为空
		int[] maxs = new int[len + 1]; // 记录当前桶号中的最小值
		int[] mins = new int[len + 1]; // 记录当期桶号中的最大值

		int bid = 0;
		for (int i = 0; i < len; i++) {
			bid = bucket(nums[i], len, min, max); // 算出桶号
			mins[bid] = hasNum[bid] ? Math.min(mins[bid], nums[i]) : nums[i];
			maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], nums[i]) : nums[i];
			hasNum[bid] = true;
		}

		// 算出最大差值
		int res = 0;
		int lastMax = 0;
		int i = 0;
		while (i <= len) {
			if (hasNum[i++]) { // 找到第一个不为空的桶(默认是第一个桶，因为有最小值，最小值就在第一个桶中)
				lastMax = maxs[i - 1];
				break;
			}
		}

		for (; i <= len; i++) {
			if (hasNum[i]) {
				res = Math.max(res, mins[i] - lastMax);
				lastMax = maxs[i];
			}
		}

		return res;
	}

	// 使用long类型是为了防止相乘时溢出
	private int bucket(long num, long len, long min, long max) {
		// TODO Auto-generated method stub
		return (int) ((num - min) * len / (max - min));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.maxGap(new int[] { 9, 3, 1, 10 }));
		System.out.println(s.maxGap1(new int[] { 9, 3, 1, 10 }));
	}

}
