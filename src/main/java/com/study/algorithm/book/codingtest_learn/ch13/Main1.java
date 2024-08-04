package com.study.algorithm.book.codingtest_learn.ch13;

public class Main1 {

	public static void main(String[] args) {
		int[] result = solution(new int[]{5, 2, 9, 1, 5, 6});
		for (int i : result) {
			System.out.println("i = " + i);
		}
	}

	static int[] solution(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int target = array[i];

			int j = i - 1;

			while (j >= 0 && target < array[j]) {
				array[j + 1] = array[j];
				j--;
			}

			array[j + 1] = target;
		}
		return array;
	}
}
