package com.study.algorithm.inflearn.intro.ch09_greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 최대 수입 스케쥴(우선순위 큐 응용문제)
 */
public class Main4_최대수입스케쥴 {

	private static int n, max = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		ArrayList<Lecture> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int m = kb.nextInt(); // 강연료
			int d = kb.nextInt(); // 허용가능한 강연일
			arr.add(new Lecture(m, d));
			if (d > max) max = d; // 최대 허용가능한 강연일을 max에 입력
		}
		System.out.println(solution(arr));
	}

	private static int solution(ArrayList<Lecture> arr) {
		int answer = 0;
		PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
		Collections.sort(arr);

		int j = 0;

		for (int i = max; i >= 1; i--) {
			for (; j < n; j++) {
				if (arr.get(j).time < i) break;
				pQ.offer(arr.get(j).money);
			}
			if (!pQ.isEmpty()) answer += pQ.poll();
		}
		return answer;
	}

	private static class Lecture implements Comparable<Lecture> {
		private int money, time;

		public Lecture(int money, int time) {
			this.money = money;
			this.time = time;
		}

		// 내림차순 정렬
		@Override
		public int compareTo(Lecture ob) {
			return ob.time - this.time;
		}
	}
}
