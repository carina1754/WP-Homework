package chap4;

import java.util.Scanner;

public class ex1 {
	public static double babylonianSqrt(double x) {
		double rtn = x, prev = 0, LIMIT = 1000, loopIdx = 0;
		while (true) {

			rtn = (rtn + (x / rtn)) / 2;

			if (rtn == prev || LIMIT == loopIdx)
				break;

			prev = rtn;

			loopIdx++;

		}

		return rtn;

	}

	public static void main(String[] args) {
		double input, result;
		Scanner Sc = new Scanner(System.in);
		System.out.println("바빌로니안 제곱근을 구해주는 프로그램입니다.");
		System.out.print("예측할 수를 입력하세요");
		input = Sc.nextDouble();
		result = babylonianSqrt(input);

		System.out.printf("%.8f", result);

	}

}
