package com.study.three.six;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：在二叉树中找到累加和为指定值的最长路径长度
 * 
 * @author zhangyundu
 *
 */
public class Solution1 {
	class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public int getMaxLength(Node head, int sum) {
		Map<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0);
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}

	private int preOrder(Node head, int sum, int preSum, int level, int maxLen,
			Map<Integer, Integer> sumMap) {
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}

		if (sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}

		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);

		if (level == sumMap.get(curSum)) {// 退格到父节点前，删除该分支的节点和，一个分支，一个分支的遍历。
			sumMap.remove(curSum);
		}
		return maxLen;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		Node head1 = s.new Node(-3);
		Node head2 = s.new Node(3);
		Node head3 = s.new Node(-9);
		Node head4 = s.new Node(1);
		Node head5 = s.new Node(0);
		Node head6 = s.new Node(2);
		Node head7 = s.new Node(1);
		Node head8 = s.new Node(1);
		Node head9 = s.new Node(6);
		head1.left = head2;
		head1.right = head3;
		head2.left = head4;
		head2.right = head5;
		head3.left = head6;
		head3.right = head7;
		head5.left = head8;
		head5.right = head9;
		System.out.println(s.getMaxLength(head1, 4));
	}

}
