package chap4;

import java.util.Scanner;

public class ex1 {
	public static double babylonianSqrt(double x) {
		double std = x, temp = 0, loop = 1000, i = 0;
		while (true) {
			std = (std + (x / std)) / 2;
			if (std == temp || loop == i)
				break;
			temp = std;
			i++;
		}
		return std;

	}

	public static void main(String[] args) {
		double input, result;
		Scanner Sc = new Scanner(System.in);
		System.out.println("바빌로니안 제곱근을 구해주는 프로그램입니다.");
		System.out.print("예측할 수를 입력하세요 : ");
		input = Sc.nextDouble();
		result = babylonianSqrt(input);
		System.out.printf("예측 값은 %.8f 입니다", result);

	}

}
