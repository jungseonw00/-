package com.study.algorithm.book.codingtest_learn.ch16;

import java.util.ArrayList;
import java.util.Arrays;

public class Main77 {

	public static void main(String[] args) {
		int[] solution = solution(123);
		System.out.println("solution = " + Arrays.toString(solution));
		int[] solution1 = solution(350);
		System.out.println("solution1 = " + Arrays.toString(solution1));
	}

	private static int[] solution(int amount) {
		int[] denominations = {100, 50, 10, 1};

		ArrayList<Integer> change = new ArrayList<>();
		for (int coin : denominations) {
			while (amount >= coin) {
				change.add(coin);
				amount -= coin;
			}
		}

		return change.stream().mapToInt(Integer::intValue).toArray();
	}
}
