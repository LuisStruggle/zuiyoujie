package com.study.five.twelve;

/**
 * 题目：数组中两个字符串的最小距离
 * 
 * 描述：给定一个字符串数组strs，再给定两个字符串str1和str2，返回在strs中str1与str2的最小距离，如果str1或str2为null，
 * 或不在strs中，返回-1.
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 普通方法
	public int minDistance(String[] strs, String str1, String str2) {
		if (str1 == null || str2 == null) {
			return -1;
		}

		if (str1.equals(str2)) {
			return 0;
		}

		int s1 = -1;
		int s2 = -1;
		int minDistance = -1;
		for (int i = 0; i < strs.length; i++) {
			if (str1.equals(strs[i])) {
				s1 = i;
			}

			if (str2.equals(strs[i])) {
				s2 = i;
			}

			if (s1 != -1 && s2 != -1) {
				minDistance = minDistance == -1 ? Math.abs(s1 - s2) : Math.min(
						minDistance, Math.abs(s1 - s2));
			}

		}
		return minDistance;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		System.out.println(s.minDistance(new String[] { "1", "3", "3", "3",
				"2", "3", "1" }, "1", "2"));
		System.out.println(s.minDistance(new String[] { "CD" }, "CD", "AB"));

	}

}
