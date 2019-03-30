package com.study.two.four;

/**
 * 补充题目：反转双向链表
 * 
 * @author zhangyundu
 *
 */
public class Solution1 {
	class DoubleNode {
		public int value;
		public DoubleNode last;
		public DoubleNode next;

		public DoubleNode(int data) {
			this.value = data;
		}
	}

	public DoubleNode reverseList(DoubleNode head) {
		if (head == null) {
			return head;
		}

		// 循环移动
		DoubleNode cur = head.next;
		DoubleNode per = head;
		while (cur != null) {
			per.next = cur.next;
			if (cur.next != null) {
				cur.next.last = per;
			}
			cur.last = null;
			cur.next = head;
			head.last = cur;
			head = cur;
			cur = per.next;
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		DoubleNode head = s.new DoubleNode(1);
		DoubleNode head1 = s.new DoubleNode(2);
		DoubleNode head2 = s.new DoubleNode(3);
		head.next = head1;
		head.last = null;
		head1.next = head2;
		head1.last = head;
		head2.last = head1;
		System.out.println(s.reverseList(head));
	}
}
