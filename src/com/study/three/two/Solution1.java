package com.study.three.two;

/**
 * 题目：打印二叉树的边界节点
 * 
 * 描述：给定一棵二叉树的头结点head，按照如下两种标准分别实现二叉树边界节点的逆时针打印。
 * 
 * @author zhangyundu
 *
 */
public class Solution1 {

	class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 按照标准二打印
	public void printEdge2(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		if (head.left != null && head.right != null) {
			printLeftEdge(head.left, true);
			printRightEdge(head.right, true);
		} else {
			printEdge2(head.left != null ? head.left : head.right);
		}
		System.out.println();
	}

	// 打印出左边界
	public void printLeftEdge(Node head, boolean print) {
		if (head == null) {
			return;
		}
		if (print || (head.left == null && head.right == null)) {
			System.out.print(head.value + " ");
		}
		printLeftEdge(head.left, print);
		printLeftEdge(head.right, print && head.left == null ? true : false);
	}

	// 打印出右边界
	public void printRightEdge(Node head, boolean print) {
		if (head == null) {
			return;
		}
		printRightEdge(head.left, print && head.right == null ? true : false);
		printRightEdge(head.right, print);
		if (print || (head.left == null && head.right == null)) {
			System.out.print(head.value + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution1 s = new Solution1();
		Node head1 = s.new Node(1);
		Node head2 = s.new Node(2);
		Node head3 = s.new Node(3);
		Node head4 = s.new Node(4);
		Node head5 = s.new Node(5);
		Node head6 = s.new Node(6);
		Node head7 = s.new Node(7);
		Node head8 = s.new Node(8);
		Node head9 = s.new Node(9);
		Node head10 = s.new Node(10);
		Node head11 = s.new Node(11);
		Node head12 = s.new Node(12);
		Node head13 = s.new Node(13);
		Node head14 = s.new Node(14);
		Node head15 = s.new Node(15);
		Node head16 = s.new Node(16);
		head1.left = head2;
		head1.right = head3;
		head2.right = head4;
		head3.left = head5;
		head3.right = head6;
		head4.left = head7;
		head4.right = head8;
		head5.left = head9;
		head5.right = head10;
		head8.right = head11;
		head9.left = head12;
		head11.left = head13;
		head11.right = head14;
		head12.left = head15;
		head12.right = head16;
		s.printEdge2(head1);
	}

}
