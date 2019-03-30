package com.study.three.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：如何比较直观地打印二叉树
 * 
 * 
 * 描述：二叉树可以用常规的三种遍历结果来描述其结构，但是不够直观，尤其是二叉树中有重复值的时候，仅通过三种遍历的结果来构造二叉树的真实结构更是难上加难，
 * 有时则根本不可能。
 * 
 * 给定一棵二叉树的头节点head，已知二叉树节点值的类型为32位整型，请实现一个打印二叉树的函数，可以直观地展示树的形状，也便于画出真实的结构。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	public void printTree(Node head) {
		if (head == null) {
			return;
		}
		int h = treeHeight(head, 0);
		Queue<Node> queue = new LinkedList<Node>();
		Queue<Integer> w = new LinkedList<Integer>();
		int len1 = 1, len2 = 0, len3 = 0, len4 = (int) Math.pow(2, h) / 2;
		queue.add(head);
		w.add(len4);

		Node temp;
		while (!queue.isEmpty()) {
			len4 /= 2;
			for (int i = 0; i < len1; i++) {
				temp = queue.poll();
				if (temp.left != null) {
					queue.add(temp.left);
					w.add(w.peek() - len4);
					len2++;
				}
				if (temp.right != null) {
					queue.add(temp.right);
					w.add(w.peek() + len4);
					len2++;
				}
				print(temp, w.peek() - len3);
				len3 = w.poll();
			}
			len1 = len2;
			len2 = 0;
			len3 = 0;
			System.out.println();
		}
	}

	// 左根右，根据树高，算出行数
	public void print(Node head, int w) {
		for (int i = 1; i < w; i++) {
			System.out.print(" ");
		}
		System.out.print(head.value);
	}

	// 计算出树的高度
	public int treeHeight(Node head, int h) {
		if (head == null) {
			return h;
		}
		return Math.max(treeHeight(head.left, h + 1),
				treeHeight(head.right, h + 1));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
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
		s.printTree(head1);
	}

}
