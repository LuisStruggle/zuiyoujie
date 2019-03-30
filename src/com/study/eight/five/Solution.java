package com.study.eight.five;

/**
 * 题目：需要排序的最短子数组长度 描述：给定一个无序数组arr，求出需要排序的最短子数组长度。
 * 例如：arr=[1,5,3,4,2,6,7]返回4，因为只有[5,3,4,2]需要排序。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int getMinLength(int[] arr) {
		// 从前面找到一个数A>=前面数，从后面找到一个数B<=后面数，且A>B,Bindex-Aindex=答案，若A=B，则中间的数都和A，B相等，则没有子数组，否则中间仍然是子数组。
		int tflag = 0, eflag = arr.length - 1;
		int min = arr[eflag], max = arr[tflag];
		while (tflag < eflag) {
			if (max > min) {
				break;
			} else if (max == min) {
				if (arr[tflag + 1] >= max) {
					tflag++;
					max = arr[tflag];
				}
			} else {
				if (arr[tflag + 1] >= max) {
					tflag++;
					max = arr[tflag];
				}
				if (arr[eflag - 1] <= min) {
					eflag--;
					min = arr[eflag];
				}
			}
		}
		if (eflag <= tflag) {
			return 0;
		} else {
			return eflag - tflag + 1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.getMinLength(new int[] { 5, 2, 2, 2, 2, 2, 2 }));
	}
}
