package com.study.two.twelve;

import java.util.Stack;

/**
 * 题目：将单链表的每k个节点之间逆序
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

	// 方法一：统计head的长度，从头到尾循环，按要求遍历
	public Node reverseKNodes1(Node head, int k) {
		if (head == null || head.next == null || k <= 1) {
			return head;
		}
		Node cur = head;
		int len = 0;
		while (cur != null) {
			len++;
			cur = cur.next;
		}

		if (k > len) {
			return head;
		}

		Node per = null;
		Node next = null;
		Node newH = null;
		Node newF1 = null;
		Node newF2 = null;
		int i = 0, j = 0;
		while (i < len / k) {
			if (j == k) {
				if (newH == null) {
					newH = per;
				} else {
					newF1.next = per;
				}
				per = null;
				next = null;
				j = 0;
				i++;
			} else {
				if (j == 1) {
					newF1 = newF1 == null ? per : newF2;
					newF2 = per;
				}

				next = head.next;
				head.next = per;
				per = head;
				head = next;
				j++;
			}
		}
		newF2.next = head;

		return newH;
	}

	// 方法一：用一个栈存k个元素，然后，出栈，构成链表
	public Node reverseKNodes2(Node head, int k) {
		if (head == null || head.next == null || k <= 1) {
			return head;
		}

		Stack<Node> stack = new Stack<Node>();
		int num = 0;
		Node newH = null;
		Node newF = null;
		Node node = null;
		while (num < k && head != null) {
			stack.push(head);
			head = head.next;
			num++;
			if (num == k) {
				while (!stack.isEmpty()) {
					node = stack.pop();
					node.next = null;
					if (newH == null) {
						newH = node;
						newF = newH;
					} else {
						newF.next = node;
						newF = newF.next;
					}
				}
				num = 0;
			}
		}

		Node temp = null;
		while (!stack.isEmpty()) {
			node = stack.pop();
			// 如果链表的len小于k
			if (newF == null) {
				newH = stack.pop();
			} else {
				node.next = null;
				temp = newF.next;
				node.next = temp;
				newF.next = node;
			}
		}

		return newH;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head = s.new Node(1);
		Node head1 = s.new Node(2);
		Node head2 = s.new Node(3);
		Node head3 = s.new Node(4);
		Node head4 = s.new Node(5);
		Node head5 = s.new Node(6);
		Node head6 = s.new Node(7);
		Node head7 = s.new Node(8);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head6;
		head6.next = head7;
		System.out.println(s.reverseKNodes2(head6, 3));
	}

}
