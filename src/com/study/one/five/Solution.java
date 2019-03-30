package com.study.one.five;

import java.util.Stack;

/**
 * 题目：用一个栈实现另一个栈的排序
 * 
 * 描述：一个栈中元素的类型为整数，现在想将该栈从顶到底按从大到小的顺序排序，只许申请一个栈。除此以外，可以申请新的变量，但不能申请额外的数据结构。
 * 如何完成排序？
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public void sortStackByStack(Stack<Integer> stack) {
		Stack<Integer> res = new Stack<Integer>();
		int value1, value2;
		while (!stack.isEmpty()) {
			if (res.isEmpty()) {
				res.push(stack.pop());
			} else {
				value1 = stack.peek();
				value2 = res.peek();
				if (value1 < value2) {
					value1 = stack.pop();
					while (!res.isEmpty()) {
						if (res.peek() > value1) {
							stack.push(res.pop());
						} else {
							res.push(value1);
							break;
						}
					}
					if (res.isEmpty()) {
						res.push(value1);
					}
				} else {
					res.push(stack.pop());
				}
			}
		}
		stack = res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Stack<Integer> res = new Stack<Integer>();
		res.push(3);
		res.push(2);
		res.push(1);
		res.push(5);
		res.push(2);
		res.push(7);
		res.push(0);
		s.sortStackByStack(res);
	}

}
