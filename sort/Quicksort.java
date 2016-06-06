package com.it.sort;

public class Quicksort {
	private int[] array;

	public Quicksort(int[] array) {
		this.array = array;
	}

	public int[] quicksort() {
		int head = 0;
		int tail = array.length - 1;
		sort(head, tail);
		return array;
	}

	public void sort(int head, int tail) {
		int i, j, t, temp;
		if (head > tail) {
			return;
		}
		temp = array[head];
		i = head;
		j = tail;
		while (i != j) {
			while (array[j] >= temp && i < j) {
				j--;
			}
			while (array[i] <= temp && i < j) {
				i++;
			}

			if (i < j) {
				t = array[i];
				array[i] = array[j];
				array[j] = t;
			}
			array[head] = array[i];
			array[i] = temp;
			sort(head, i - 1);
			sort(i + 1, tail);
		}

	}

}
