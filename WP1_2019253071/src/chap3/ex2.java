package chap3;

import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		double w, h, result = 0, bmi;

		Scanner Sc = new Scanner(System.in);

		System.out.println("BMI�� �����ִ� ���α׷��Դϴ�.");

		System.out.print("�����Ը� �Է��ϼ���");

		w = Sc.nextDouble();

		System.out.print("Ű�� �Է��ϼ���(m ����)");

		h = Sc.nextDouble();
		result = w / (h * h);

		if (result < 15.0) {
			System.out.print("������ ��ü��");
		} else if (result >= 15.0 && result < 18.5) {

			System.out.print("��ü��");
		} else if (result >= 18.5 && result < 23.0) {

			System.out.print("����");
		} else if (result >= 23.0 && result <= 27.5) {

			System.out.print("��ü��");
		} else if (result > 27.5 && result <= 40.0) {

			System.out.print("��");
		} else if (result > 40.0) {
			System.out.print("������ ��");
		}

	}
}
