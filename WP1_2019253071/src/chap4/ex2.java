package chap4;

import java.util.Scanner;

public class ex2 {
	public static int fastPower(int x, int n) {//�������� �Լ�
		
		if (n == 0) {//0���̸� ������ 1
			return 1;
		}

		int std = fastPower(x, n / 2);//�¼��� 2�� ������ std�� ����
		int temp = std * std;//std�� ����
		
		if (n % 2 == 0) {//���� �¼��� ¦���� �� �¼��� 2�� ���� �������� ���
			return temp;
		} 
		else {//���� �¼��� Ȧ���� �� �¼��� 2�� ���� �������� �ѹ� �� ������ ���� ���Ͽ� ���
			return x * temp;
		}
	}

	public static void main(String[] args) {
		int x, n, result;//������ ����, ��ŭ ������ �������� ����, ��� ����
		Scanner Sc = new Scanner(System.in);//�Է¹ޱ� ���� scanner ����
		System.out.println("���� ������ �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ���� �Է��ϼ���(ex)2 4 : ");
		x = Sc.nextInt();
		n = Sc.nextInt();
		result = fastPower(x, n);
		System.out.print(result);
	}

}
