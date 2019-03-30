package com.study.one.two;

import java.util.Stack;

/**
 * 题目：编写一个类，用两个栈实现队列，支持队列的基本操作（add,poll,peek）.
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	private Stack<Integer> stackPush;
	private Stack<Integer> stackPop;

	public Solution() {
		this.stackPush = new Stack<Integer>();
		this.stackPop = new Stack<Integer>();
	}

	public void add(int value) {
		stackPush.push(value);
	}

	public int poll() {
		if (stackPop.isEmpty()) {
			if (stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			} else {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
		}
		return stackPop.pop();
	}

	public int peek() {
		if (stackPop.isEmpty()) {
			if (stackPush.isEmpty()) {
				throw new RuntimeException("Queue is empty!");
			} else {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}
		}
		return stackPop.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
