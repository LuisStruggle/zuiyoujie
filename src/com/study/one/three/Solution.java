package com.study.one.three;

import java.util.Stack;

/**
 * 题目：如何仅用递归函数和栈操作逆序一个栈
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty()) {
			return result;
		} else {
			int last = getAndRemoveLastElement(stack);
			stack.push(result);
			return last;
		}
	}

	public void reverse(Stack<Integer> stack) {
		if (stack.isEmpty()) {
			return;
		} else {
			// 每次提取最后一个，提到最后，提出来的就是第一个元素，这时候开始插入，正好可以反过来
			int i = getAndRemoveLastElement(stack);
			reverse(stack);
			stack.push(i);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		Stack<Integer> st = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		s.reverse(st);
		System.out.println(st);
	}

}
