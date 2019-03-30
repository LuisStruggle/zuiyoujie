package com.study.eight.twenty;

/**
 * 题目：打印N个数组整体最大的Top K
 * 
 * 描述：有N个长度不一的数组，所有的数组都是有序的，请从大到小打印这N个数组整体最大的前K个数。
 * 
 * @author zhangyundu
 *
 */
public class Solution {
	// 普通方法，时间复杂度O(K*matrix.length)
	public void printTopK(int[][] matrix, int topk) {
		if (matrix == null || matrix.length == 0 || topk < 1) {
			return;
		}
		int max = Integer.MIN_VALUE;
		// 得到每一行的长度
		int[] arr = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			arr[i] = matrix[i].length - 1;
		}

		int index = -1;
		for (int k = 0; k < topk; k++) {
			max = Integer.MIN_VALUE;
			index = -1;
			for (int i = 0; i < matrix.length; i++) {
				if (arr[i] > -1 && matrix[i][arr[i]] > max) {
					max = matrix[i][arr[i]];
					index = i;
				}
			}

			if (index != -1) {
				arr[index] -= 1;
				System.out.println(max);
			}
		}
	}

	class HeapNode {
		public int value; // 值是什么
		public int arrNum; // 来自哪个数组
		public int index; // 来自数组的哪个位置

		public HeapNode(int value, int arrNum, int index) {
			this.value = value;
			this.arrNum = arrNum;
			this.index = index;
		}
	}

	// 思路：先排序，再选择，利用堆排序
	public void printTopK1(int[][] matrix, int topk) {
		int heapSize = matrix.length;
		HeapNode[] heap = new HeapNode[heapSize];
		for (int i = 0; i != heapSize; i++) {
			int index = matrix[i].length - 1;
			heap[i] = new HeapNode(matrix[i][index], i, index);
			heapInsert(heap, i);
		}
		System.out.print("TOP " + topk + " : ");
		for (int i = 0; i != topk; i++) {
			if (heapSize == 0) {
				break;
			}
			System.out.print(heap[0].value + " ");
			if (heap[0].index != 0) {
				heap[0].value = matrix[heap[0].arrNum][--heap[0].index];
			} else {
				swap(heap, 0, --heapSize);
			}
			heapify(heap, 0, heapSize);
		}
	}

	private void heapify(HeapNode[] heap, int index, int heapSize) {
		// TODO Auto-generated method stub
		int left = index * 2 + 1;
		int right = index * 2 + 2;
		int largest = index;
		while (left < heapSize) {
			if (heap[left].value > heap[index].value) {
				largest = left;
			}
			if (right < heapSize && heap[right].value > heap[largest].value) {
				largest = right;
			}
			if (largest != index) {
				swap(heap, largest, index);
			} else {
				break;
			}
			index = largest;
			left = index * 2 + 1;
			right = index * 2 + 2;
		}
	}

	private void heapInsert(HeapNode[] heap, int index) {
		// TODO Auto-generated method stub
		while (index != 0) {
			int parent = (index - 1) / 2;
			if (heap[parent].value < heap[index].value) {
				swap(heap, parent, index);
				index = parent;
			} else {
				break;
			}
		}
	}

	private void swap(HeapNode[] heap, int index1, int index2) {
		// TODO Auto-generated method stub
		HeapNode tmp = heap[index1];
		heap[index1] = heap[index2];
		heap[index2] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s = new Solution();
		s.printTopK(new int[][] { { 219, 845, 971 }, { 548, 558 } }, 5);
		s.printTopK1(new int[][] { { 219, 845, 971 }, { 548, 558 } }, 5);
	}

}
