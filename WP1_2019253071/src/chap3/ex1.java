package chap3;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {

		Scanner Sc = new Scanner(System.in);//�Է¹ޱ� ���� scanner ����

		double a, b, c;//������������ ����� ����
		double temp;//���ǰ��� �� root�� �� ����
		double sqrt;//temp�� root�� ����
		double x1, x2;//������������ ��

		System.out.println("������������ ���� �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ����� �Է��ϼ��� : ");
		a = Sc.nextInt();
		System.out.print("������ ����� �Է��ϼ��� : ");
		b = Sc.nextInt();
		System.out.print("����׸� �Է��ϼ��� : ");
		c = Sc.nextInt();
		temp = (b*b)-(4*a*c);//b^2-4ac ���� temp�� ����
		sqrt = Math.sqrt(temp);// temp root�����
		if (temp > 0) {//�Ǻ������� temp�� 0���� ũ�� �ΰ��� ���� ����
			x1 = (-b + sqrt) / (a*2);
			x2 = (-b - sqrt) / (a*2);
			System.out.print("������������ ���� " + x1 + " ��" + x2 + " �ΰ��Դϴ�.");// �������� �տ� ������ ���
		}
		else if (temp == 0) {//�Ǻ������� temp�� 0�̸� �߱��� ����
			x1 = (-b + sqrt) / (a*2);
			System.out.print("������������ ���� �߱��� " + x1 + "�Դϴ�.");
		}
		else if (temp < 0) {//�Ǻ������� temp�� 0���� ������ �Ǳ��� �������� ����
			System.out.print("������������ �Ǳ��� �����ϴ�.");
		}
		else {
			System.out.print("����");
		}

	}

}