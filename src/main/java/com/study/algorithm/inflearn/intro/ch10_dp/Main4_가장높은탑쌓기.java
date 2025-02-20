package com.study.algorithm.inflearn.intro.ch10_dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 가장 높은 탑 쌓기(LIS 응용)
 */
public class Main4_가장높은탑쌓기 {

	private static int[] dy;

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		ArrayList<Brick> list = new ArrayList<>();
		dy = new int[n];

		for (int i = 0; i < n; i++) {
			int s = kb.nextInt();
			int h = kb.nextInt();
			int w = kb.nextInt();
			list.add(new Brick(s, h, w));
		}

		System.out.println(solution(list));
	}

	private static int solution(ArrayList<Brick> arr) {
		int answer;

		Collections.sort(arr);

		dy[0] = arr.get(0).h;
		answer = dy[0];

		for (int i = 1; i < arr.size(); i++) {
			int max_h = 0;
			for (int j = i - 1; j >= 0; j--) {
				if (arr.get(j).w > arr.get(i).w && dy[j] > max_h) {
					max_h = dy[j];
				}
			}
			dy[i] = max_h + arr.get(i).h;
			answer = Math.max(answer, dy[i]);
		}
		return answer;
	}

	private static class Brick implements Comparable<Brick> {

		private int s, h, w;

		public Brick(int s, int h, int w) {
			this.s = s;
			this.h = h;
			this.w = w;
		}

		// 내림차순 정렬 (this가 앞에 있으면 오름차순, 뒤에 있으면 내림차순 정렬)

		@Override
		public int compareTo(Brick ob) {
			return ob.s - this.s;
		}
	}
}