package assign;

import java.util.Scanner;

public class Anagram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String first = sc.next();
			if (first.equals("quit")) {
				System.out.println("종료되었습니다.");
				break;
			}
			String second = sc.next();
			int result = numberNeeded(first, second);
			if (result == 0) {
				System.out.println("anagram!");
			} else {
				System.out.println("not anagram!");
			}
		}
	}

	public static int numberNeeded(String first, String second) {
		int count = 0;

		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			int dif = countNum(first, alphabet) - countNum(second, alphabet);
			int sum = countNum(first, alphabet) + countNum(second, alphabet);
			System.out.print(alphabet + " = " + sum + ", ");

			if (dif < 0) {
				dif = dif * -1;
			}
			count += dif;
		}
		return count;
	}

	public static int countNum(String str, char ch) {
		int count = 0;

		if (str.indexOf(ch) == -1) {
			return 0;
		}
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				count++;
			}
		}

		return count;
	}
}
