package chap3;

import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		double w, h, result = 0, bmi;

		Scanner Sc = new Scanner(System.in);

		System.out.println("BMI를 구해주는 프로그램입니다.");

		System.out.print("몸무게를 입력하세요");

		w = Sc.nextDouble();

		System.out.print("키를 입력하세요(m 기준)");

		h = Sc.nextDouble();
		result = w / (h * h);

		if (result < 15.0) {
			System.out.print("병적인 저체중");
		} else if (result >= 15.0 && result < 18.5) {

			System.out.print("저체중");
		} else if (result >= 18.5 && result < 23.0) {

			System.out.print("정상");
		} else if (result >= 23.0 && result <= 27.5) {

			System.out.print("과체중");
		} else if (result > 27.5 && result <= 40.0) {

			System.out.print("비만");
		} else if (result > 40.0) {
			System.out.print("병적인 비만");
		}

	}
}
