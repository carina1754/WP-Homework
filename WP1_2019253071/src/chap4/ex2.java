package chap4;

import java.util.Scanner;

public class ex2 {
	public static int fastPower(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int n1 = fastPower(x, n / 2);
		int temp = n1 * n1;

		if (n % 2 == 0) {
			return temp;
		} else {
			return x * temp;
		}
	}

	public static void main(String[] args) {
		int x, n, result;
		Scanner Sc = new Scanner(System.in);
		System.out.println("�ٺ��δϾ� �������� �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ���� �Է��ϼ���");
		x = Sc.nextInt();
		n = Sc.nextInt();
		result = fastPower(x, n);
		System.out.print(result);
	}

}
