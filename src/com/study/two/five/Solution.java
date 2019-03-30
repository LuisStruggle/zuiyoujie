package com.study.two.five;

/**
 * 题目：反转部分单向链表
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

	public Node reversePart(Node head, int from, int to) {
		if (head == null || head.next == null || from < 1 || to < 1
				|| to - from < 1) {
			return head;
		}

		int num = 0;
		Node cur = head;
		while (cur != null) {
			cur = cur.next;
			num++;
		}
		if (to > num) {
			return head;
		}

		cur = head;
		Node per = from == 1 ? null : head;
		Node next = head.next;
		int i = 1;
		while (i < to) {
			i++;
			if (i > from) {
				if (per != null) {
					cur.next = next.next;
					next.next = per.next;
					per.next = next;
					next = cur.next;
				} else {
					cur.next = next.next;
					next.next = cur;
					head = next;
					next = cur.next;
				}
			} else {
				cur = cur.next;
				next = next.next;
				per = from == 2 ? per : per.next;
			}

		}

		// Node
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head = s.new Node(1);
		Node head1 = s.new Node(2);
		Node head2 = s.new Node(3);
		Node head3 = s.new Node(4);
		Node head4 = s.new Node(5);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = null;
		System.out.println(s.reversePart(head, 1, 3));
	}

}
