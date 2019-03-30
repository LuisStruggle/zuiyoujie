package com.study.two.two;

/**
 * 补充题目：实现双向链表，倒数第K个节点的删除。
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

	public DoubleNode removeLastKthNode(DoubleNode head, int lastKth) {
		if (head == null || lastKth < 1) {
			return head;
		}
		DoubleNode cur = head;
		while (cur != null) {
			lastKth--;
			cur = cur.next;
		}
		if (lastKth == 0) {
			head = head.next;
			head.last = null;
		}
		if (lastKth < 0) {
			cur = head;
			while (++lastKth != 0) {
				cur = cur.next;
			}
			DoubleNode newNext = cur.next.next;
			cur.next = newNext;
			if (newNext != null) {
				newNext.last = cur;
			}
		}
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		DoubleNode head1 = s.new DoubleNode(1);
		DoubleNode head11 = s.new DoubleNode(2);
		DoubleNode head12 = s.new DoubleNode(3);
		DoubleNode head13 = s.new DoubleNode(4);
		DoubleNode head14 = s.new DoubleNode(5);
		head1.next = head11;
		head1.last = null;
		head11.next = head12;
		head11.last = head1;
		head12.next = head13;
		head12.last = head11;
		head13.next = head14;
		head13.last = head12;
		head14.next = null;
		head14.last = head13;
		System.out.println(s.removeLastKthNode(head1, 2));
	}

}
