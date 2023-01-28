package Level_0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main21 {
	public static void main(String[] args) {
		solution2("onetwothreefourfivesixseveneightnine");
	}

	static long solution(String my_string) {
		// 어떤 규칙을 찾아야 함.
		my_string = my_string.replace("zero", "0");
		my_string = my_string.replace("one", "1");
		my_string = my_string.replace("two", "2");
		my_string = my_string.replace("three", "3");
		my_string = my_string.replace("four", "4");
		my_string = my_string.replace("five", "5");
		my_string = my_string.replace("six", "6");
		my_string = my_string.replace("seven", "7");
		my_string = my_string.replace("eight", "8");
		my_string = my_string.replace("nine", "9");

		return Long.parseLong(my_string);
	}

	static long solution2(String my_string) {

		String[] numbersArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		for (int i = 0; i < numbersArr.length; i++) {
			my_string = my_string.replaceAll(numbersArr[i], String.valueOf(i));
		}

		return Long.parseLong(my_string);
	}
}
