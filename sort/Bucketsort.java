package com.it.sort;

public class Bucketsort {
	/*
	 * 1.Ͱ���������ȶ��� 2.Ͱ�����ǳ������򷽷�������һ�֣��ȿ���Ҫ�죬��Ȼ������ɢ�Ƚϸߵ���������
	 * 3.ʱ�临�Ӷ�ΪO(M+N),��ķѿռ��һ�����򷽷�����Ȼ������ݲ��ϴ󣬿�����ɢ������
	 */
	// ���� �������ֵ������10000
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
