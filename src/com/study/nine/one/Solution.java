package com.study.nine.one;

/**
 * 题目：从5随机到7随机及其扩展
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	public int rand1To5() {
		return (int) (Math.random() * 5) + 1;
	}

	// 通过给定一个等概率随机产生1-5的随机函数rand1To5，在不使用任何额外的随机机制，请用rand1To5实现等概率随机产生1-7的随机函数rand1To7。
	public int rand1To7() {
		// 解析过程，看书
		int num = 0;
		do {
			num = (rand1To5() - 1) * 5 + (rand1To5() - 1);
		} while (num > 20);
		return num % 7 + 1;
	}

	// 补充题目：给定一个以p概率产生0，以1-p概率产生1的随机函数rand0p，在不使用任何额外的随机机制，请用rand01p实现等概率随机产生1-6的随机函数rand1To6。
	public int rand01p() {
		// 可随意改变p
		double p = 0.83;
		return Math.random() < p ? 0 : 1;
	}

	// 虽然rand01p方法以p的概率产生0，以1-p的概率产生1，但是rand01p产生01和10的概率却都是p（1-p），可以利用这一点来实现等概率随机产生0和1的函数。具体过程请查看如下代码中的rand01方法。
	public int rand01() {
		int num = 0;
		do {
			num = rand01p();
		} while (num == rand01p());
		return num;
	}

	public int rand0To3() {
		return rand01() * 2 + rand01();
	}

	public int rand1To6() {
		int num = 0;
		do {
			num = rand0To3() * 4 + rand0To3();
		} while (num > 11);
		return num % 6 + 1;
	}

	// 进阶问题：给定一个等概率随机产生1-M的随机函数rand1ToM，在不使用任何额外的随机机制。有两个输入参数，分别为m和n，请用rand1ToM（m）实现等概率随机产生1-n的随机函数rand1ToN。
	public int rand1ToM(int m) {
		return (int) (Math.random() * m) + 1;
	}

	public int rand1ToN(int n, int m) {

		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Math.random());
	}

}
