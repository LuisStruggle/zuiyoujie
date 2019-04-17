package com.study.two.nine;

import java.util.HashMap;

/**
 * 题目：复制含有随机指针节点的链表
 * 
 * @author zhangyundu
 *
 */

class Node {
	public int value;
	public Node next;
	public Node rand;

	public Node(int data) {
		this.value = data;
	}
}

public class Solution {
	public Node copyListWithRand1(Node head) {
		HashMap<Node, Node> map = new HashMap<Node, Node>();

		Node cur = head;
		while (cur != null) {
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}

		cur = head;
		while (cur != null) {
			map.get(cur).next = map.get(cur.next);
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}

		return map.get(head);
	}

	// 进阶方法，利用有限几个变量完成链表调整的代码实现能力。
	public Node copyListWithRand2(Node head) {
		if (head == null) {
			return null;
		}

		Node cur = head;
		Node next = null;
		// 复制并链接每一个节点1->1'->2->2'->3->3'->null
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}

		cur = head;
		Node curCopy = null;
		// 设置复制节点的rand指针
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}

		Node res = head.next;
		cur = head;
		// 拆分，1->2->3->null,1'->2'->3'->null
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}

		return res;
	}
}
