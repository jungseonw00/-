package com.study.algorithm.personal.sorting;

import java.util.Arrays;

/**
 * 앞의 원소들과 비교하며 정렬한다.
 */
public class 삽입정렬 {

	public static void main(String[] args) {
		int[] arr = {8, 5, 6, 2, 4};
		System.out.println(Arrays.toString(solution(arr.length, arr)));
	}

	private static int[] solution(int n, int[] arr) {
		for (int i = 1; i < n; i++) {
			int tmp = arr[i], j;
			for (j = i - 1; j >= 0; j--) {
				if (arr[j] > tmp) {
					arr[j + 1] = arr[j];
				} else {
					break;
				}
			}
			arr[j + 1] = tmp;
		}
		return arr;
	}
}