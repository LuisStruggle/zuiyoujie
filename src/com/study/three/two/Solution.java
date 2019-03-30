package com.study.three.two;

/**
 * 题目：打印二叉树的边界节点
 * 
 * 描述：给定一棵二叉树的头结点head，按照如下两种标准分别实现二叉树边界节点的逆时针打印。
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

	// 按照标准一打印
	public void printEdge1(Node head) {
		if (head == null) {
			return;
		}
		// 得到树的高
		int height = getHeight(head, 0);
		// 左右两边的边集合
		Node[][] edgeMap = new Node[height][2];
		setEdgeMap(head, 0, edgeMap);

		// 打印左边界
		for (int i = 0; i != edgeMap.length; i++) {
			System.out.print(edgeMap[i][0].value + " ");
		}

		// 打印既不是左边界，也不是有边界的叶子节点
		printLeafNotInMap(head, 0, edgeMap);

		// 打印右边界
		for (int i = edgeMap.length - 1; i >= 0; i--) {
			if (edgeMap[i][0] != edgeMap[i][1]) {
				System.out.print(edgeMap[i][1].value + " ");
			}
		}

		System.out.println();

	}

	private void printLeafNotInMap(Node head, int i, Node[][] edgeMap) {
		// TODO Auto-generated method stub
		if (head == null) {
			return;
		}
		if (head.left == null && head.right == null) {
			if (head != edgeMap[i][0] && head != edgeMap[i][1]) {
				System.out.print(head.value + " ");
			}
		}
		printLeafNotInMap(head.left, i + 1, edgeMap);
		printLeafNotInMap(head.right, i + 1, edgeMap);
	}

	private void setEdgeMap(Node head, int i, Node[][] edgeMap) {
		// TODO Auto-generated method stub
		if (head == null) {
			return;
		}
		edgeMap[i][0] = edgeMap[i][0] == null ? head : edgeMap[i][0];
		edgeMap[i][1] = head;
		setEdgeMap(head.left, i + 1, edgeMap);
		setEdgeMap(head.right, i + 1, edgeMap);
	}

	private int getHeight(Node head, int i) {
		// TODO Auto-generated method stub
		if (head == null) {
			return i;
		}
		return Math.max(getHeight(head.left, i + 1),
				getHeight(head.right, i + 1));
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
		s.printEdge1(head1);
	}

}
