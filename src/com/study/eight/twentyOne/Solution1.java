package com.study.eight.twentyOne;

/**
 * 优化方法，时间复杂度也为O(N的三次方)
 * 
 * 思想：预处理统计从每一个位置出发，向下和向右1的个数。然后快速查询，某个位置，向下和向右的连续的1是否大于边长size，
 * 然后在判断该点的右上角向下和左下角向右的是否满足size。满足则符合要求。
 * 
 * @author zhangyundu
 *
 */
public class Solution1 {
	public void setBorderMap(int[][] m, int[][] right, int[][] down) {
		int r = m.length;
		int c = m[0].length;
		if (m[r - 1][c - 1] == 1) {
			right[r - 1][c - 1] = 1;
			down[r - 1][c - 1] = 1;
		}
		for (int i = r - 2; i != -1; i--) {
			if (m[i][c - 1] == 1) {
				right[i][c - 1] = 1;
				down[i][c - 1] = down[i + 1][c - 1] + 1;
			}
		}
		for (int i = c - 2; i != -1; i--) {
			if (m[r - 1][i] == 1) {
				right[r - 1][i] = right[r - 1][i + 1] + 1;
				down[r - 1][i] = 1;
			}
		}
		for (int i = r - 2; i != -1; i--) {
			for (int j = c - 2; j != -1; j--) {
				if (m[i][j] == 1) {
					right[i][j] = right[i][j + 1] + 1;
					down[i][j] = down[i + 1][j] + 1;
				}
			}
		}
	}

	public int getMaxSize(int[][] m) {
		int[][] right = new int[m.length][m[0].length]; // 表示从（i，j）出发，向右有多少个连续的1
		int[][] down = new int[m.length][m[0].length]; // 表示从（i，j）出发，向下有多少个连续的1
		setBorderMap(m, right, down);
		for (int size = Math.min(m.length, m[0].length); size != 0; size--) {
			if (hasSizeOfBorder(size, right, down)) {
				return size;
			}
		}
		return 0;
	}

	private boolean hasSizeOfBorder(int size, int[][] right, int[][] down) {
		for (int i = 0; i != right.length - size + 1; i++) {
			for (int j = 0; j != right[0].length - size + 1; j++) {
				if (right[i][j] >= size && down[i][j] >= size
						&& right[i + size - 1][j] >= size
						&& down[i][j + size - 1] >= size) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s1 = new Solution1();
		System.out.println(s1.getMaxSize(new int[][] { { 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1 }, { 0, 1, 0, 0, 1 }, { 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 1, 1 } }));
		System.out.println(s1.getMaxSize(new int[][] { { 0, 1 }, { 0, 1 } }));
	}

}
