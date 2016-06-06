package com.it.sort;

public class Test {

	public static void main(String[] args) {
		
		int[] array = {10,2,3,99,89,7,45,16,7,23,78,29,76,3,7,100};
//		Bucketsort bt = new Bucketsort();
//		array = bt.bucketsort(array);
//		Quicksort qs = new Quicksort(array);
//		array = qs.quicksort();
		Heapsort hs = new Heapsort(array,array.length);
		array = hs.heapsort();
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}

	}

}
