package com.study.seven.five;

/**
 * 题目：在其他数都出现偶数次的数组中找到出现奇数次的数
 * 
 * 描述：给定一个整型数组arr，其中只有一个数出现了奇数次，其他的数都出现了偶数次，打印这个数。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public void printOddTimesNum1(int[] arr) {
		int num = 0;
		for (int i = 0; i < arr.length; i++) {
			num ^= arr[i];
		}
		System.out.println(num);
	}

	// 进阶：有两个数出现了奇数次，其他的数都出现了偶数次，打印这两个数。
	// 要求时间复杂度为O(N)，额外空间复杂度为O(1)
	public void printOddTimesNum2(int[] arr) {
		// 详细解释看课本，还是很容易懂的
		int num = 0; // 存储两个奇数异或的结果
		for (int i = 0; i < arr.length; i++) {
			num ^= arr[i];
		}
		int one = 0;
		int k = num & (~num + 1); // 获取二进制最右侧为1的位
		for (int i = 0; i < arr.length; i++) {
			if ((k & arr[i]) != 0) {
				one ^= arr[i];
			}
		}
		System.out.println(one + "," + (num ^ one));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.printOddTimesNum2(new int[] { 2, 3, 7, 7, 2, 3, 3, 4 });
	}
}
