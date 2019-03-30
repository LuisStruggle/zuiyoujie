package com.study.two.two;


/**
 * 题目：分别实现两个函数，一个可以删除单链表中倒数第k个节点，另一个可以删除双链表中倒数第k个节点。
 * 
 * 要求：如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1).
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

	public Node removeLastKthNode(Node head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}

		// 统计Node的节点个数
		int num = 0;
		Node cur = head;
		while (cur != null) {
			num++;
			cur = cur.next;
		}

		// 移除第num-k+1位置上的节点
		if (num >= lastKth) {
			int i = num - lastKth;
			cur = head;
			while (--i > 0) {
				cur = cur.next;
			}

			cur.next = cur.next.next;
		}
		return head;
	}

	public Node removeLastKthNode1(Node head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}

		Node cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head1 = s.new Node(1);
		Node head11 = s.new Node(2);
		Node head12 = s.new Node(3);
		Node head13 = s.new Node(4);
		Node head14 = s.new Node(5);
		head1.next = head11;
		head11.next = head12;
		head12.next = head13;
		head13.next = head14;
		head14.next = null;
		System.out.println(s.removeLastKthNode(head1, 2));
	}

}
