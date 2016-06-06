package com.it.sort;

public class Bubblesort {

	public int[] bubblesort(int[] num) {
		// 冒泡排序是双重嵌套 时间复杂度是O(N*N)
		int t;
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = 0; j < num.length - i; j++) {
				if (num[j] < num[j + 1]) {
					t = num[j];
					num[j] = num[j + 1];
					num[j + 1] = t;
				}
			}
		}
		return num;
	}
}
