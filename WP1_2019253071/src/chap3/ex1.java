package chap3;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {

		Scanner Sc = new Scanner(System.in);//입력받기 위한 scanner 변수

		double a, b, c;//이차방정식의 계수들 변수
		double temp;//근의공식 중 root에 들어갈 변수
		double sqrt;//temp의 root값 변수
		double x1, x2;//이차방정식의 근

		System.out.println("이차방정식의 근을 구해주는 프로그램입니다.");
		System.out.print("이차항 계수를 입력하세요 : ");
		a = Sc.nextInt();
		System.out.print("일차항 계수를 입력하세요 : ");
		b = Sc.nextInt();
		System.out.print("상수항를 입력하세요 : ");
		c = Sc.nextInt();
		temp = (b*b)-(4*a*c);//b^2-4ac 공식 temp에 저장
		sqrt = Math.sqrt(temp);// temp root씌우기
		if (temp > 0) {//판별식으로 temp가 0보다 크면 두개의 근을 가짐
			x1 = (-b + sqrt) / (a*2);
			x2 = (-b - sqrt) / (a*2);
			System.out.print("이차방정식의 근은 " + x1 + " 과" + x2 + " 두개입니다.");// 작은값이 앞에 오도록 출력
		}
		else if (temp == 0) {//판별식으로 temp가 0이면 중근을 가짐
			x1 = (-b + sqrt) / (a*2);
			System.out.print("이차방정식의 근은 중근인 " + x1 + "입니다.");
		}
		else if (temp < 0) {//판별식으로 temp가 0보다 작으면 실근이 존재하지 않음
			System.out.print("이차방정식의 실근이 없습니다.");
		}
		else {
			System.out.print("오류");
		}

	}

}