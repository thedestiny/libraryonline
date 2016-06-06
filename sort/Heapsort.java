package com.it.sort;

public class Heapsort {
	private int[] array;
	private int n;
	public Heapsort(int[] array,int n) {
		this.array = array;
		this.n = n - 1;
	}
	public int[] heapsort() {
		creat();
		sort();
		return array;
	}

	private void sort() {
		while (n > 0) {
			swap(0, n);
			n--;
			siftdown(0);
		}

	}
  // 初始化堆，生成最大堆
	private void creat() {
		for (int i = n / 2; i >= 0; i--) {
			siftdown(i);
		}
	}

	private void siftdown(int i) {
		// flag 判断是否向下调整
		int t, flag = 0;
		while (i * 2 <= n && flag == 0) {
			// 判断和左支的关系，t记录最大值的下标
			if (array[i] > array[i * 2]) {
				t = i * 2;
			} else {
				t = i;
			}
			// 判断是否有右支
			if (i * 2 + 1 <= n) {
				if (array[t] > array[2 * i + 1]) {
					t = i * 2 + 1;
				}
			}
			if (t != i) {
				swap(t, i);
				i = t;
			} else {
				flag = 1;
			}

		}

	}

	private void swap(int t, int i) {
		int temp;
		temp = array[t];
		array[t] = array[i];
		array[i] = temp;

	}

}
