package com.study.three.six;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：在二叉树中找到累加和为指定值的最长路径长度
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public int getMaxLength(Node head, int sum) {
		if (head == null) {
			return 0;
		}
		Queue<Node> nodes = new LinkedList<Node>();
		nodes.add(head);
		Node node;
		int maxLength = 0;
		while (!nodes.isEmpty()) {
			node = nodes.poll();
			maxLength = preOrder(node, sum, 0, 0, maxLength);

			if (node.left != null) {
				nodes.add(node.left);
			}
			if (node.right != null) {
				nodes.add(node.right);
			}
		}
		return maxLength;
	}

	public int preOrder(Node head, int sum, int preSum, int length,
			int maxLength) {
		if (head == null) {
			return maxLength;
		}
		length++;
		preSum += head.value;
		if (sum == preSum) {
			if (length > maxLength) {
				maxLength = length;
			}
		}
		maxLength = preOrder(head.left, sum, preSum, length, maxLength);
		maxLength = preOrder(head.right, sum, preSum, length, maxLength);

		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
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
