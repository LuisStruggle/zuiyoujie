package com.study.nine.five;

/**
 * 题目：判断一个点是否在三角形内部
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 书中将的比较详细，可惜看不懂，如果点在内部，则按逆时针A,B,C访问三角形，则走过的边都在点的右边
	public boolean isInside(double x1, double y1, double x2, double y2,
			double x3, double y3, double x, double y) {
		// 如果三角形的点不是逆时针输入，改变一下顺序

		if (crossProduct(x3 - x1, y3 - y1, x2 - x1, y2 - y1) >= 0) {
			double tmpx = x2;
			double tmpy = y2;
			x2 = x3;
			y2 = y3;
			x3 = tmpx;
			y3 = tmpy;
		}

		if (crossProduct(x2 - x1, y2 - y1, x - x1, y - y1) < 0) {
			return false;
		}
		if (crossProduct(x3 - x2, y3 - y2, x - x2, y - y2) < 0) {
			return false;
		}
		if (crossProduct(x1 - x3, y1 - y3, x - x3, y - y3) < 0) {
			return false;
		}
		return true;
	}

	// 该方法描述了向量（x1，y1）叉乘向量（x2，y2），两个向量的开始点都是原点。
	public double crossProduct(double x1, double y1, double x2, double y2) {
		return x1 * y2 - x2 * y1;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isInside(1, 0, 0, 2, 3, 3, 4, 4));
	}

}
