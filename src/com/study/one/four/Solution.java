package com.study.one.four;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：猫狗队列
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 思路：构建一个新的，带有宠物实例和计算器的类，然后创建猫狗队列，实现本题的要求。
	private Queue<PetEnterQueue> dogQ;
	private Queue<PetEnterQueue> catQ;
	private long count;

	public Solution() {
		this.dogQ = new LinkedList<PetEnterQueue>();
		this.catQ = new LinkedList<PetEnterQueue>();
		this.count = 0;
	}

	public void add(Pet pet) {
		if (pet.getPetType().equals("dog")) {
			this.dogQ.add(new PetEnterQueue(pet, count++));
		} else if (pet.getPetType().equals("cat")) {
			this.catQ.add(new PetEnterQueue(pet, count++));
		} else {
			throw new RuntimeException("err, not dog or cat");
		}
	}

	public Pet pollAll() {
		if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
			if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
				return this.dogQ.poll().getPet();
			} else {
				return this.catQ.poll().getPet();
			}
		} else if (!this.dogQ.isEmpty()) {
			return this.dogQ.poll().getPet();
		} else if (!this.catQ.isEmpty()) {
			return this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("err, queue is empty!");
		}
	}

	public Dog pollDog() {
		if (!this.isDogQueueEmpty()) {
			return (Dog) this.dogQ.poll().getPet();
		} else {
			throw new RuntimeException("Dog queue is empty!");
		}
	}

	public Cat pollCat() {
		if (!this.isCatQueueEmpty()) {
			return (Cat) this.catQ.poll().getPet();
		} else {
			throw new RuntimeException("Cat queue is empty!");
		}
	}

	private boolean isCatQueueEmpty() {
		// TODO Auto-generated method stub
		return this.catQ.isEmpty();
	}

	private boolean isDogQueueEmpty() {
		// TODO Auto-generated method stub
		return this.dogQ.isEmpty();
	}

	public boolean isEmpty() {
		return this.dogQ.isEmpty() && this.catQ.isEmpty();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
