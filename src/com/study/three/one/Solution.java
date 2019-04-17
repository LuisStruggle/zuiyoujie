package com.study.three.one;

import java.util.Stack;

/**
 * 题目：分别用递归和非递归实现二叉树的前序、中序、后序遍历
 * 
 * @author zhangyundu
 *
 */
class Node {
	public int value;
	public Node left;
	public Node right;

	public Node(int value) {
		this.value = value;
	}
}

public class Solution {
	public void preOrderRecur(Node head) { // 递归，前序遍历
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public void inOrderRecur(Node head) { // 递归，中序遍历
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public void posOrderRecur(Node head) { // 递归，后序遍历
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	public void preOrderUnRecur(Node head) { // 非递归，前序遍历
		if (head == null) {
			return;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(head);
		while (!stack.isEmpty()) {
			head = stack.pop();
			System.out.print(head.value + " ");

			if (head.right != null) {
				stack.push(head.right);
			}

			if (head.left != null) {
				stack.push(head.left);
			}
		}
	}

	public void inOrderUnRecur(Node head) { // 非递归，中序遍历
		if (head == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();

		while (!stack.isEmpty() || head != null) {
			if (head != null) {
				stack.push(head);
				head = head.left;
			} else {
				head = stack.pop();
				System.out.print(head.value + " ");
				head = head.right;
			}
		}
	}

	public void posOrderUnRecur(Node head) { // 非递归，后序遍历
		if (head == null) {
			return;
		}
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		s1.push(head);
		while (!s1.isEmpty()) {
			head = s1.pop();
			s2.push(head);
			if (head.left != null) {
				s1.push(head.left);
			}
			if (head.right != null) {
				s1.push(head.right);
			}
		}

		while (!s2.isEmpty()) {
			System.out.print(s2.pop().value + " ");
		}
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node head1 = new Node(2);
		Node head2 = new Node(3);
		Node head3 = new Node(4);
		Node head4 = new Node(5);
		Node head5 = new Node(6);
		Node head6 = new Node(7);
		head.left = head1;
		head.right = head2;
		head1.left = head3;
		head1.right = head4;
		head2.left = head5;
		head2.right = head6;

		Solution s = new Solution();
		s.posOrderUnRecur(head);
	}

}
