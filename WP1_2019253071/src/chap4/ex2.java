package chap4;

import java.util.Scanner;

public class ex2 {
	public static int fastPower(int x, int n) {
		if (n == 0) {
			return 1;
		}
		int std = fastPower(x, n / 2);
		int temp = std * std;
		if (n % 2 == 0) {
			return temp;
		} else {
			return x * temp;
		}
	}

	public static void main(String[] args) {
		int x, n, result;
		Scanner Sc = new Scanner(System.in);
		System.out.println("빠른 제곱을 구해주는 프로그램입니다.");
		System.out.print("제곱할 수를 입력하세요 : ");
		x = Sc.nextInt();
		n = Sc.nextInt();
		result = fastPower(x, n);
		System.out.print(result);
	}

}
