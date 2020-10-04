package assign;

import java.util.Scanner;

public class Anagram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String array1[] = new String [100];
		String array2[] = new String [100];
		int i = 0,j=0,k=0;
		while (true) {
			String first = sc.next();
			if (first.equals("quit")) {
				System.out.println("anagram!");
				for(k=0;k<i;k++) {
					System.out.println(array1[k]);
				}
				System.out.println("not anagram!");
				for(k=0;k<j;k++) {
					System.out.println(array2[k]);
				}
				System.out.println("종료되었습니다.");
				break;
			}
			String second = sc.next();
			int result = numberNeeded(first, second);
			if (result == 0) {
				array1[i] = first + " " + second;
				i++;
			} 
			else {
				array2[j] = first + " " + second;
				j++;
			}
		}
	}

	public static int numberNeeded(String first, String second) {
		int count = 0;

		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			int i = countNum(first, alphabet) - countNum(second, alphabet);
			int sum = countNum(first, alphabet) + countNum(second, alphabet);
			System.out.print(alphabet + " = " + sum + ", ");

			if (i < 0) {
				i = i * -1;
			}
			count += i;
		}
		return count;
	}

	public static int countNum(String a, char b) {
		int count = 0;

		if (a.indexOf(b) == -1) {
			return 0;
		}
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == b) {
				count++;
			}
		}

		return count;
	}
}
