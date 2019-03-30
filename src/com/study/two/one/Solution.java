package com.study.two.one;

/**
 * 题目：给定两个有序链表的头指针head1和head2，打印两个链表的公共部分。
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

	public void printCommonPart(Node head1, Node head2) {
		while (head1 != null && head2 != null) {
			if (head1.value == head2.value) {
				System.out.println(head1.value);
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				head1 = head1.next;
			}

		}
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

		Node head2 = s.new Node(1);
		Node head21 = s.new Node(4);
		Node head22 = s.new Node(5);
		Node head23 = s.new Node(7);
		Node head24 = s.new Node(8);
		head2.next = head21;
		head21.next = head22;
		head22.next = head23;
		head23.next = head24;
		head24.next = null;
		s.printCommonPart(head1, head2);
	}
}
