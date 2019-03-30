package com.study.two.ten;

import java.util.Stack;

/**
 * 题目：两个单链表生成相加链表
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

	// 方案一：利用栈结构求解
	public Node addLists1(Node head1, Node head2) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		while (head1 != null) {
			s1.push(head1.value);
			head1 = head1.next;
		}
		while (head2 != null) {
			s2.push(head2.value);
			head2 = head2.next;
		}

		int flag = 0; // 是否进位，进位1，不进位0
		int val1 = 0;
		int val2 = 0;
		Node addNode = null;
		Node curNode = null;
		while (!s1.isEmpty() || !s2.isEmpty()) {
			val1 = s1.isEmpty() ? 0 : s1.pop();
			val2 = s2.isEmpty() ? 0 : s2.pop();

			curNode = new Node((val1 + val2 + flag) % 10);
			curNode.next = addNode;
			addNode = curNode;
			flag = (val1 + val2 + flag) / 10;
		}
		if (flag == 1) {
			curNode = new Node(1);
			curNode.next = addNode;
			addNode = curNode;
		}
		return addNode;
	}

	// 方案二：利用链表的逆序求解，可以省掉栈空间
	public Node addLists2(Node head1, Node head2) {
		Node pre = null;
		Node next = null;
		while (head1 != null) {
			next = head1.next;
			head1.next = pre;
			pre = head1;
			head1 = next;
		}
		head1 = pre;
		pre = null;
		next = null;
		while (head2 != null) {
			next = head2.next;
			head2.next = pre;
			pre = head2;
			head2 = next;
		}
		head2 = pre;

		Node addNode = null;
		Node curNode = null;
		int flag = 0; // 0代表没有进位，1代表有进位。
		int val1 = 0;
		int val2 = 0;

		while (head1 != null || head2 != null) {
			val1 = head1 == null ? 0 : head1.value;
			val2 = head2 == null ? 0 : head2.value;

			curNode = new Node((val1 + val2 + flag) % 10);
			curNode.next = addNode;
			addNode = curNode;
			flag = (val1 + val2 + flag) / 10;

			head1 = head1 == null ? null : head1.next;
			head2 = head2 == null ? null : head2.next;
		}
		if (flag == 1) {
			curNode = new Node(1);
			curNode.next = addNode;
			addNode = curNode;
		}

		return addNode;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Node head1 = s.new Node(9);
		Node head11 = s.new Node(3);
		Node head12 = s.new Node(7);
		head1.next = head11;
		head11.next = head12;

		Node head2 = s.new Node(6);
		Node head21 = s.new Node(3);
		head2.next = head21;
		System.out.println(s.addLists2(head1, head2));
	}

}
