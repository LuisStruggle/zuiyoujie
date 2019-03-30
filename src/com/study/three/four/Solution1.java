package com.study.three.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：二叉树的序列化和反序列化
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

	// 方法二：用层遍历实现序列化和反序列化，每个值结束加一个“!”，空值用“#”表示
	public String serialByLevel(Node head) {
		if (head == null) {
			return "#!";
		}
		Queue<Node> queue = new LinkedList<Node>();
		Node temp;
		String str = "";
		queue.add(head);
		while (!queue.isEmpty()) {
			temp = queue.poll();
			if (temp == null) {
				str += "#!";
			} else {
				str += temp.value + "!";
				queue.add(temp.left);
				queue.add(temp.right);
			}
		}
		return str;
	}

	// 反序列化
	public Node reconByLevelString(String levelStr) {
		String[] strs = levelStr.split("!");
		int num = strs.length;
		Node[] nodes = new Node[num];
		Node head = null;
		for (int i = strs.length - 1; i >= 0; i--) {
			head = strs[i].equals("#") ? null : new Node(
					Integer.valueOf(strs[i]));

			nodes[i] = head;
			if (head == null) {
				continue;
			}

			head.right = nodes[--num];
			head.left = nodes[--num];
		}
		return head;
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
		Node head = s.reconByLevelString(s.serialByLevel(head1));

	}
}
