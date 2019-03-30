package com.study.one.one;

import java.util.Stack;

/**
 * 题目：设计一个有getMin功能的栈
 * 
 * 描述：实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返回栈中最小元素的操作。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;

	public Solution() {
		this.stackData = new Stack<Integer>();
		this.stackMin = new Stack<Integer>();
	}

	public void push(int newNum) {
		if (stackMin.isEmpty()) {
			stackMin.push(newNum);
		} else {
			if (stackMin.peek() >= newNum) {
				stackMin.push(newNum);
			}
		}
		stackData.push(newNum);
	}

	public int pop() {
		if (stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty");
		}
		int value = stackData.pop();
		if (value == getMin()) {
			stackMin.pop();
		}
		return value;
	}

	public int getMin() {
		if (stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty.");
		}
		return stackMin.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
