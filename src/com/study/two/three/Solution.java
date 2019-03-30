package com.study.two.three;

/**
 * 题目：删除链表的中间节点和a/b处的节点
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

	public Node removeMidNode(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		int num = 0;
		Node cur = head;
		while (cur != null) {
			num++;
			cur = cur.next;
		}
		if (num > 2) {
			cur = head;
			num = num % 2 == 0 ? ((num / 2) - 1) : (num / 2);
			for (int i = 1; i < num; i++) {
				cur = cur.next;
			}

			cur.next = cur.next.next;
		} else {
			head = head.next;
		}

		return head;
	}

	public Node removeMidNode1(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		if (head.next.next == null) {
			return head.next;
		}
		Node per = head.next;
		Node cur = head.next.next;
		while (cur.next != null && cur.next.next != null) {
			per = per.next;
			cur = cur.next.next;
		}

		per.next = per.next.next;

		return head;
	}

	public Node removeByRatioNode(Node head, int a, int b) {
		double r = (double) a / b;
		if (head == null || r > 1 || r == 0) {
			return head;
		}
		int num = 0;
		Node cur = head;
		while (cur != null) {
			num++;
			cur = cur.next;
		}
		cur = head;
		if (r > 0 && r <= (double) 1 / num) {
			head = head.next;
		} else {
			for (int i = 1; i < num; i++) {
				if (r > (double) i / num && r <= (double) (i + 1) / num) {
					cur.next = cur.next.next;
					break;
				}
				cur = cur.next;
			}
		}

		return head;
	}

	public Node removeByRatioNode1(Node head, int a, int b) {
		if (a < 1 || a > b) {
			return head;
		}
		int num = 0;
		Node cur = head;
		while (cur != null) {
			cur = cur.next;
			num++;
		}

		num = (int) Math.ceil((double) (a * num) / (double) b);
		if (num == 1) {
			head = head.next;
		}
		if (num > 1) {
			cur = head;
			while (--num != 1) {
				cur = cur.next;
			}
			cur.next = cur.next.next;
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
		// System.out.println(s.removeMidNode(head));
		System.out.println(s.removeByRatioNode(head, 3, 3));
	}

}
