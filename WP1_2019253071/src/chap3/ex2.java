package chap3;

import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		double w, h, result = 0, bmi;//몸무게, 키, bmi지수 변수

		Scanner Sc = new Scanner(System.in);//입력받기 위한 scanner 변수

		System.out.println("BMI를 구해주는 프로그램입니다.");

		System.out.print("몸무게를 입력하세요 : ");

		w = Sc.nextDouble();

		System.out.print("키를 입력하세요(m 기준) : ");

		h = Sc.nextDouble();
		result = w / (h * h);

		if (result < 15.0) {//bmi가 15미만일 시 병적인 저체중
			System.out.print("병적인 저체중");
		} else if (result >= 15.0 && result < 18.5) {//bmi가 15이상 18.5미만일 시 저체중

			System.out.print("저체중");
		} else if (result >= 18.5 && result < 23.0) {//bmi가 18.5이상 23미만일 시 정상

			System.out.print("정상");
		} else if (result >= 23.0 && result <= 27.5) {//bmi가 23이상 27.5이하일 시 과체중

			System.out.print("과체중");
		} else if (result > 27.5 && result <= 40.0) {//bmi가 27.5초과 40이하일 시 비만

			System.out.print("비만");
		} else if (result > 40.0) {//bmi가 40초과일 시 병적인 비만
			System.out.print("병적인 비만");
		}
		else {//예외
			System.out.print("오류");
		}
	}
}
