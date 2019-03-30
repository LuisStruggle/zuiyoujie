package com.study.nine.four;

/**
 * 题目：判断一个点是否在矩形内部
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 平行于x和y的情况。
	public boolean isInside1(double x1, double y1, double x4, double y4,
			double x, double y) {
		if (x <= x1) {
			return false;
		}
		if (x >= x4) {
			return false;
		}
		if (y <= y4) {
			return false;
		}
		if (y >= y1) {
			return false;
		}
		return true;
	}

	// 不平行于x和y的情况。（求四个函数，关系式）
	public boolean isInside2(double x1, double y1, double x2, double y2,
			double x3, double y3, double x4, double y4, double x, double y) {
		if (y1 == y2) {
			return isInside1(x1, y1, x4, y4, x, y);
		}
		double k12 = (y2 - y1) / (x2 - x1);
		double b12 = y2 - k12 * x2;
		double k13 = (y3 - y1) / (x3 - x1);
		double b13 = y3 - k13 * x3;
		double k24 = (y4 - y2) / (x4 - x2);
		double b24 = y4 - k24 * x4;
		double k34 = (y4 - y3) / (x4 - x3);
		double b34 = y4 - k34 * x4;
		if (x <= x1) {
			return false;
		}
		if (x >= x4) {
			return false;
		}
		if (y <= y3) {
			return false;
		}
		if (y >= y2) {
			return false;
		}

		if (x3 <= x2) {
			if (x <= x3) {
				if ((x * k13 + b13) < y && (x * k12 + b12) > y) {
					return true;
				}
			} else if (x <= x2) {
				if ((x * k34 + b34) < y && (x * k12 + b12) > y) {
					return true;
				}
			} else {
				if ((x * k34 + b34) < y && (x * k24 + b24) > y) {
					return true;
				}
			}
		} else {
			if (x <= x2) {
				if ((x * k13 + b13) < y && (x * k12 + b12) > y) {
					return true;
				}
			} else if (x <= x3) {
				if ((x * k13 + b13) < y && (x * k24 + b24) > y) {
					return true;
				}
			} else {
				if ((x * k34 + b34) < y && (x * k24 + b24) > y) {
					return true;
				}
			}
		}
		return false;
	}

	// 通过坐标变换把矩阵转成平行的情况
	public boolean isInside3(double x1, double y1, double x2, double y2,
			double x3, double y3, double x4, double y4, double x, double y) {
		if (y1 == y2) {
			return isInside1(x1, y1, x4, y4, x, y);
		}
		double l = Math.abs(y4 - y3);
		double k = Math.abs(x4 - x3);
		double s = Math.sqrt(k * k + l * l);
		double sin = l / s;
		double cos = k / s;
		double x1R = cos * x1 + sin * y1;
		double y1R = -x1 * sin + y1 * cos;
		double x4R = cos * x4 + sin * y4;
		double y4R = -x4 * sin + y4 * cos;
		double xR = cos * x + sin * y;
		double yR = -x * sin + y * cos;
		return isInside1(x1R, y1R, x4R, y4R, xR, yR);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
