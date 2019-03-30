package com.study.two.six;

/**
 * 题目：环形单链表的约瑟夫问题
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

	public Node josephusKill1(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int i = 1;
		while (head.next != head) {
			if (i == m - 1) {
				head.next = cur.next;
				head = head.next;
				cur = head.next;
				i = 1;
			} else {
				head = head.next;
				cur = cur.next;
				i++;
			}
		}
		return head;
	}

	// 进阶解法，将时间复杂度从上面的O（n*m）降到O（n）
	public Node josephusKill2(Node head, int m) {
		// 思路：直接算出最终那个不会被kill掉，就可以在O（n）之内。
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head;
		int num = 1;
		while (cur.next != head) {
			cur = cur.next;
			num++;
		}
		num = getLive(num, m);
		while (--num != 0) {
			head = head.next;
		}

		head.next = head;

		return head;
	}

	public int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
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
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = head;
		System.out.println(s.josephusKill1(head, 2));
	}

}
