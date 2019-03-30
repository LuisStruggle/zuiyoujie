package com.study.two.four;

/**
 * 题目：分别实现反转单向链表和反转双向链表的函数。
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

	public Node reverseList(Node head) {
		if (head == null) {
			return head;
		}

		// 循环移动
		Node cur = head.next;
		Node per = head;
		while (cur != null) {
			per.next = cur.next;
			cur.next = head;
			head = cur;
			cur = per.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head = s.new Node(1);
		Node head1 = s.new Node(2);
		Node head2 = s.new Node(3);
		head.next = head1;
		head1.next = head2;
		System.out.println(s.reverseList(head));
	}

}
