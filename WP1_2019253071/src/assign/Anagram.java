package assign;

import java.util.Scanner;

public class Anagram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);//�Է¹ޱ� ���� scanner ����
		String array1[] = new String [1000];//anagram�� ��� �迭
		String array2[] = new String [1000];//anagram�� �ƴ� ��� �迭
		int i = 0,j=0,k=0;//�ݺ����� ���� ���� (i�� quit�Է½� ��� ���, j�� anagram�� ��� ���, k�� anagram�� �ƴ� ��� ���)
		while (true) {//quit�Է� ������ �ݺ�
			String first = sc.next();//ù��° ���ڿ�
			if (first.equals("quit")) {//quit�Է½� while�� break �� ��� ���
				System.out.println("anagram!");
				for(k=0;k<i;k++) {//anagram�� ��� ���
					System.out.println(array1[k]);
				}
				System.out.println("not anagram!");
				for(k=0;k<j;k++) {//anagram�� �ƴ� ��� ���
					System.out.println(array2[k]);
				}
				System.out.println("����Ǿ����ϴ�.");
				break;
			}
			String second = sc.next();//�ι�° ���ڿ�
			int result = anagram(first, second);//anagram �м�
			if (result == 0) {//anagram�̸� array1�� ����
				array1[i] = first + " " + second;
				i++;
			} 
			else {//anagram�� �ƴϸ� array2�� ����
				array2[j] = first + " " + second;
				j++;
			}
		}
	}

	public static int anagram(String first, String second) {//anagram �м� �Լ�
		int count = 0;//����� ����(0�Ͻ� anagram)

		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {//a-z���� ���� ���� ���� �ݺ���
			int i = countalphabet(first, alphabet) - countalphabet(second, alphabet);
			int sum = countalphabet(first, alphabet) + countalphabet(second, alphabet);
			System.out.print(alphabet + " = " + sum + ", ");

			if (i < 0) {
				i = i * -1;
			}
			count += i;
		}
		System.out.println();
		return count;//anagram �м� ���(0�Ͻ� anagram)
	}

	public static int countalphabet(String a, char b) {//���ڿ� ���� ���� �Լ�
		int count = 0;

		if (a.indexOf(b) == -1) {
			return 0;
		}
		for (int i = 0; i < a.length(); i++) {//�ݺ������� a-z���� ���� alphabet �� �ϳ� ���ԵǸ� �� alphabet�� count+1
			if (a.charAt(i) == b) {
				count++;
			}
		}

		return count;//���� ���(0 or 1)
	}
}
