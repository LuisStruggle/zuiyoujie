package com.study.two.eight;

import java.util.Stack;

/**
 * 题目：将单向链表按某值划分成左边小、中间相等、右边大的形式。
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

	public Node listPartition1(Node head, int pivot) {
		// 构造一个额外的空间存储每一个节点，然后，小于pivot的构造成一个串，等于pivot的构造成一个串，大于pivot的构造成一个串。
		if (head == null) {
			return head;
		}
		Stack<Node> stack = new Stack<Node>();
		Node mid = head.next;
		Node min = head;
		while (mid != null) {
			if (mid.value < min.value) {
				stack.push(min);
				min = mid;
			} else {
				stack.push(mid);
			}
			mid = mid.next;
		}

		Node node = null;
		min.next = null;
		head = min;
		mid = head;
		while (!stack.isEmpty()) {
			node = stack.pop();
			if (node.value < pivot) {
				node.next = head;
				head = node;
			}
			if (node.value == pivot) {
				node.next = mid.next;
				mid.next = node;
				mid = mid.next;
			}
			if (node.value > pivot) {
				node.next = mid.next;
				mid.next = node;
			}
		}
		return head;
	}

	// 时间复杂度为O（N），空间复杂度为O（1）
	public Node listPartition2(Node head, int pivot) {
		// 思路：将原链表中的所有节点依次划分进三个链表，三个链表分别为small代表做部分，equal代表中间部分，big代表右部分。
		Node sH = null; // 小的头
		Node sT = null; // 小的尾
		Node eH = null; // 相等的头
		Node eT = null; // 相等的尾
		Node bH = null; // 大的头
		Node bT = null; // 大的尾

		Node next = null;

		while (head != null) {
			next = head.next;
			head.next = null;
			if (head.value < pivot) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value == pivot) {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			} else {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			}
			head = next;
		}

		if (sT != null) {
			sT.next = eH;
			if (eT != null) {
				eT.next = bH;
			} else {
				sT.next = bH;
			}
		} else {
			if (eT != null) {
				eT.next = bH;
				sH = eH;
			} else {
				sH = bH;
			}
		}

		return sH;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head = s.new Node(9);
		Node head1 = s.new Node(0);
		Node head2 = s.new Node(4);
		Node head3 = s.new Node(5);
		Node head4 = s.new Node(1);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = null;
		System.out.println(s.listPartition2(head, 3));
	}
}
