package chap4;

import java.util.Scanner;

public class ex1 {
	public static double babylonianSqrt(double x) {//�ٺ��δϾ� ������ �Լ�
		double loop = 1000, std = x, temp = 0, i = 0;//��ŭ �ݺ��� �������� ����, ������ ����, �ӽ÷� �����Ͽ� �ݺ��� Ż���� ���� ����, ��ŭ �ݺ��ߴ����� ����
		while (true) {//�������� ���̻� �ٲ��� ���� ��� �ݺ��� Ż��
			std = (std + (x / std)) / 2;//�ٺ��δϾ� �Լ� 
			if (std == temp || loop == i) {//�ݺ����� ������ �Ŀ� ���� ���� ������ �� ������ break or 1000�� ������ �� break
				break;
				}
			i++;
			temp = std;
		}
		return std;

	}

	public static void main(String[] args) {
		double input, result;//�Է� ����, ��� ����
		Scanner Sc = new Scanner(System.in);//�Է¹ޱ� ���� scanner ����
		System.out.println("�ٺ��δϾ� �������� �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ���� �Է��ϼ��� : ");
		input = Sc.nextDouble();
		result = babylonianSqrt(input);
		System.out.printf("���� ���� %.8f �Դϴ�", result);

	}

}
