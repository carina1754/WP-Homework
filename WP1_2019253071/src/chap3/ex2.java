package chap3;

import java.util.Scanner;

public class ex2 {
	public static void main(String[] args) {
		double w, h, result = 0, bmi;//������, Ű, bmi���� ����

		Scanner Sc = new Scanner(System.in);//�Է¹ޱ� ���� scanner ����

		System.out.println("BMI�� �����ִ� ���α׷��Դϴ�.");

		System.out.print("�����Ը� �Է��ϼ��� : ");

		w = Sc.nextDouble();

		System.out.print("Ű�� �Է��ϼ���(m ����) : ");

		h = Sc.nextDouble();
		result = w / (h * h);

		if (result < 15.0) {//bmi�� 15�̸��� �� ������ ��ü��
			System.out.print("������ ��ü��");
		} else if (result >= 15.0 && result < 18.5) {//bmi�� 15�̻� 18.5�̸��� �� ��ü��

			System.out.print("��ü��");
		} else if (result >= 18.5 && result < 23.0) {//bmi�� 18.5�̻� 23�̸��� �� ����

			System.out.print("����");
		} else if (result >= 23.0 && result <= 27.5) {//bmi�� 23�̻� 27.5������ �� ��ü��

			System.out.print("��ü��");
		} else if (result > 27.5 && result <= 40.0) {//bmi�� 27.5�ʰ� 40������ �� ��

			System.out.print("��");
		} else if (result > 40.0) {//bmi�� 40�ʰ��� �� ������ ��
			System.out.print("������ ��");
		}
		else {//����
			System.out.print("����");
		}
	}
}
