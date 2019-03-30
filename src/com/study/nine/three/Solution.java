package com.study.nine.three;

/**
 * 题目：有关阶乘的两个问题
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 原问题：给定一个非负整数N，返回N！结果的末尾为0的数量。
	public int zeroNum1(int num) {
		// 因为因子2的数目总是多于因子5，所以统计出有多少个因子5，就有多少个0
		if (num < 0) {
			return 0;
		}
		int n = 0;
		int cur = 0;
		for (int i = 5; i <= num; i = i + 5) {
			cur = i;
			while (cur % 5 == 0) {
				n++;
				cur /= 5;
			}
		}
		return n;
	}

	public int zeroNum2(int num) {
		// 因为因子2的数目总是多于因子5，所以统计出有多少个因子5，就有多少个0
		if (num < 0) {
			return 0;
		}
		int res = 0;
		while (num != 0) {
			res += num / 5;
			num /= 5;
		}
		return res;
	}

	// 进阶问题：给定一个非负整数N，如果用二进制表达N！的结果，返回最低位的1在哪个位置上，认为最右的位置为位置0.
	public int rightOne1(int num) {
		// 最低位的1在哪个位置上，完全取决于1-N的数中因子2有多少个，因为只要出现一个因子2，最低位的1就会向左移一位。
		if (num < 1) {
			return -1;
		}
		int res = 0;
		while (num != 0) {
			num >>>= 1;
			res += num;
		}
		return res;
	}

	// 通过公式推导：如果把N！的结果中因子2的总个数记为Z，把N的二进制数表达式中1的个数记为m，还存在如下一个关系Z=N-m。
	public int rightOne2(int num) {
		if (num < 1) {
			return -1;
		}
		int temp = num;
		int ones = 0;
		while (temp != 0) {
			ones += (temp & 1) != 0 ? 1 : 0;
			temp >>= 1;
		}
		return num - ones;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.zeroNum2(1000000000));
	}

}
