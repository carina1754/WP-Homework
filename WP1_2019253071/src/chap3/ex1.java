package chap3;

import java.util.Scanner;

public class ex1 {

	public static void main(String[] args) {

		double a, b, c;
		double determinant;
		double root;
		double x1, x2;

		Scanner Sc = new Scanner(System.in);

		System.out.println("������������ ���� �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ����� �Է��ϼ��� : ");
		a = Sc.nextInt();
		System.out.print("������ ����� �Է��ϼ��� : ");
		b = Sc.nextInt();
		System.out.print("����׸� �Է��ϼ��� : ");
		c = Sc.nextInt();
		determinant = (b * b) - (4 * a * c);
		root = Math.sqrt(determinant);///// root�� ����ϴ� ��ɾ�
		if (determinant > 0) {
			x1 = (-b + root) / (2 * a);
			x2 = (-b - root) / (2 * a);
			System.out.print("������������ ���� " + x1 + " ��" + x2 + " �ΰ��Դϴ�.");
		}
		if (determinant == 0) {
			x1 = (-b + root) / (2 * a);
			System.out.print("������������ ���� �߱�����, " + x1 + "�Դϴ�.");
		}
		if (determinant < 0) {
			System.out.print("������������ ���� �����ϴ�.");
		}

	}

}