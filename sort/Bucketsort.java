package com.it.sort;

public class Bucketsort {
	/*
	 * 1.桶排序是最稳定的 2.桶排序是常见排序方法中最快的一种，比快排要快，当然对于离散度较高的是这样。
	 * 3.时间复杂度为O(M+N),最耗费空间的一种排序方法。当然如果数据差距较大，可以离散化处理。
	 */
	// 假设 数组最大值不超过10000
	private int[] array = new int[10000];
	public int[] bucketsort(int[] num) {
		for (int i = 0; i < num.length; i++) {
			array[num[i]]++;
		}
		int count = 0;
		for (int i = 0; i < 1000; i++) {
			if (array[i] != 0) {
				for (int j = 0; j < array[i]; j++) {
					num[count++] = i;
				}
			}
		}
		return num;
	}

}
