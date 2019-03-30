package com.study.two.seven;

import java.util.Stack;

/**
 * 题目：判断一个链表是否为回文结构
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// 普通解法
	public boolean isPalindrome1(Node head) {
		Stack<Node> stack = new Stack<Node>();
		Node cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value == stack.pop().value) {
				head = head.next;
			} else {
				return false;
			}
		}
		return true;
	}

	// 进阶：去除一半的额外空间
	public boolean isPalindrome2(Node head) {
		if (head == null || head.next == null) {
			return true;
		}
		// 查找右半部分
		Node right = head.next;
		Node cur = head;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}

		Stack<Node> stack = new Stack<Node>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value == stack.pop().value) {
				head = head.next;
			} else {
				return false;
			}

		}
		return true;
	}

	// 进阶：如果链表长度为N，时间复杂度达到O（N），额外空间复杂度到达O（1）。
	public boolean isPalindrome3(Node head) {
		// 个人思路，将前一部分逆序过来，跟后一半比
		if (head == null || head.next == null) {
			return true;
		}
		Node cur = head;
		int num = 0;
		while (cur != null) {
			num++;
			cur = cur.next;
		}
		cur = head;
		Node next = head.next;
		int i = 1;
		while (i < num / 2) {
			cur.next = next.next;
			next.next = head;
			head = next;
			next = cur.next;
			i++;
		}

		if (num % 2 != 0) {
			next = next.next;
			i++;
		}

		while (i < num) {
			if (head.value == next.value) {
				head = head.next;
				next = next.next;
			} else {
				return false;
			}
			i++;

		}

		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head = s.new Node(1);
		Node head1 = s.new Node(2);
		Node head2 = s.new Node(8);
		Node head3 = s.new Node(8);
		Node head4 = s.new Node(2);
		Node head5 = s.new Node(1);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		System.out.println(s.isPalindrome3(head));
	}

}
