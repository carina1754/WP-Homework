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
		System.out.println("�ٺ��δϾ� �������� �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ���� �Է��ϼ��� : ");
		input = Sc.nextDouble();
		result = babylonianSqrt(input);
		System.out.printf("���� ���� %.8f �Դϴ�", result);

	}

}
