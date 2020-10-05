package chap4;

import java.util.Scanner;

public class ex1 {
	public static double babylonianSqrt(double x) {//바빌로니안 제곱근 함수
		double loop = 1000, std = x, temp = 0, i = 0;//얼만큼 반복할 것인지의 변수, 예측값 변수, 임시로 저장하여 반복문 탈출을 위한 변수, 얼만큼 반복했는지의 변수
		while (true) {//예측값이 더이상 바뀌지 않을 경우 반복문 탈출
			std = (std + (x / std)) / 2;//바빌로니안 함수 
			if (std == temp || loop == i) {//반복문을 돌리기 후와 전의 값을 비교했을 때 같으면 break or 1000번 돌았을 시 break
				break;
				}
			i++;
			temp = std;
		}
		return std;

	}

	public static void main(String[] args) {
		double input, result;//입력 변수, 결과 변수
		Scanner Sc = new Scanner(System.in);//입력받기 위한 scanner 변수
		System.out.println("바빌로니안 제곱근을 구해주는 프로그램입니다.");
		System.out.print("예측할 수를 입력하세요 : ");
		input = Sc.nextDouble();
		result = babylonianSqrt(input);
		System.out.printf("예측 값은 %.8f 입니다", result);

	}

}
