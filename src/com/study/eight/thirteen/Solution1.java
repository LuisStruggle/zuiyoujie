package com.study.eight.thirteen;

/**
 * 题目：计算数组的小和（这是一种在归并排序的过程中，利用组间在进行合并时产生小和的过程。）
 * 
 * 时间复杂度为O(NlogN)、额外空间复杂度为O(N)的方法
 * 
 * @author zhangyundu
 *
 */
public class Solution1 {

	// 改进版
	public int getSmallSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}

		return handle(arr);
	}

	private int handle(int[] arr) {
		int sum = 0;
		if (arr.length > 1) {
			int mid = (int) Math.ceil((arr.length) / 2.0);
			int[] left = new int[mid];
			int[] right = new int[arr.length - mid];

			for (int i = 0; i < arr.length; i++) {
				if (i < mid) {
					left[i] = arr[i];
				} else {
					right[i - mid] = arr[i];
				}
			}
			sum += handle(left);
			sum += handle(right);

			// 遍历归并左右两个部分求和
			for (int i = 0; i < left.length; i++) {
				for (int j = 0; j < right.length; j++) {
					if (left[i] <= right[j]) {
						sum += left[i] * (right.length - j);
						break;
					}
				}
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s1 = new Solution1();
		System.out.println(s1.getSmallSum(new int[] { 1, 3, 5, 2, 4, 6 }));
	}

}
