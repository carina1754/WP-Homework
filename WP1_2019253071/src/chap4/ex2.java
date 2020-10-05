package chap4;

import java.util.Scanner;

public class ex2 {
	public static int fastPower(int x, int n) {//빠른제곱 함수
		
		if (n == 0) {//0승이면 무조건 1
			return 1;
		}

		int std = fastPower(x, n / 2);//승수를 2로 나누어 std에 저장
		int temp = std * std;//std를 제곱
		
		if (n % 2 == 0) {//만약 승수가 짝수일 시 승수를 2로 나눈 제곱값을 출력
			return temp;
		} 
		else {//만약 승수가 홀수일 시 승수를 2로 나눈 제곱값에 한번 더 제곱할 수를 곱하여 출력
			return x * temp;
		}
	}

	public static void main(String[] args) {
		int x, n, result;//제곱할 변수, 얼만큼 제곱할 것인지의 변수, 결과 변수
		Scanner Sc = new Scanner(System.in);//입력받기 위한 scanner 변수
		System.out.println("빠른 제곱을 구해주는 프로그램입니다.");
		System.out.print("제곱할 수를 입력하세요(ex)2 4 : ");
		x = Sc.nextInt();
		n = Sc.nextInt();
		result = fastPower(x, n);
		System.out.print(result);
	}

}
