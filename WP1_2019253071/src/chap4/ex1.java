package chap4;

import java.util.Scanner;

public class ex1 {
	public static double babylonianSqrt(double x) {
		double rtn = x, prev = 0, LIMIT = 1000, loopIdx = 0;
		while (true) {

			rtn = (rtn + (x / rtn)) / 2;

			if (rtn == prev || LIMIT == loopIdx)
				break;

			prev = rtn;

			loopIdx++;

		}

		return rtn;

	}

	public static void main(String[] args) {
		double input, result;
		Scanner Sc = new Scanner(System.in);
		System.out.println("�ٺ��δϾ� �������� �����ִ� ���α׷��Դϴ�.");
		System.out.print("������ ���� �Է��ϼ���");
		input = Sc.nextDouble();
		result = babylonianSqrt(input);

		System.out.printf("%.8f", result);

	}

}
