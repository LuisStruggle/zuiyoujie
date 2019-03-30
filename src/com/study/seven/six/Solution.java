package com.study.seven.six;

/**
 * 题目：在其他数都出现k次的数组中找到只出现一次的数
 * 
 * 描述：再给定一个整型数组arr和一个大于1的整数k。已知arr中只有1个数出现了1次，其他的数都出现了k次，请返回只出现了1次的数。
 * 
 * @author zhangyundu
 *
 */
public class Solution {

	public int onceNum(int[] arr, int k) {
		int num = 0;
		if (k % 2 == 0) {
			for (int i = 0; i < arr.length; i++) {
				num ^= arr[i];
			}
		} else {
			// 可以统计实现
		}
		return num;
	}

	// 思路：因为k个相同的k进制数进行无进位相加，结果一定是每一位上都是0的k进制数，所以只出现一次的那个数最终就会剩下来。
	public int onceNum1(int[] arr, int k) {
		int[] eO = new int[32];
		for (int i = 0; i != arr.length; i++) {
			setExclusiveOr(eO, arr[i], k);
		}
		int res = getNumFromKSysNum(eO, k);
		return res;
	}

	private int getNumFromKSysNum(int[] eO, int k) {
		// TODO Auto-generated method stub
		int res = 0;
		for (int i = eO.length - 1; i != -1; i--) {
			res = res * k + eO[i];
		}
		return res;
	}

	private void setExclusiveOr(int[] eO, int value, int k) {
		// TODO Auto-generated method stub
		int[] curKSysNum = getKSysNumFromNum(value, k);
		for (int i = 0; i != eO.length; i++) {
			eO[i] = (eO[i] + curKSysNum[i]) % k;
		}
	}

	private int[] getKSysNumFromNum(int value, int k) {
		// TODO Auto-generated method stub
		int[] res = new int[32];
		int index = 0;
		while (value != 0) {
			res[index++] = value % k;
			value = value / k;
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.onceNum1(
				new int[] { 1, 2, 3, 4, 3, 4, 3, 2, 4, 2 }, 3));
	}

}
