package assign;

import java.util.Scanner;

public class Anagram {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);//입력받기 위한 scanner 변수
		String array1[] = new String [1000];//anagram인 목록 배열
		String array2[] = new String [1000];//anagram이 아닌 목록 배열
		int i = 0,j=0,k=0;//반복문을 위한 변수 (i는 quit입력시 결과 출력, j는 anagram인 목록 출력, k는 anagram이 아닌 목록 출력)
		while (true) {//quit입력 전까지 반복
			String first = sc.next();//첫번째 문자열
			if (first.equals("quit")) {//quit입력시 while문 break 및 결과 출력
				System.out.println("anagram!");
				for(k=0;k<i;k++) {//anagram인 목록 출력
					System.out.println(array1[k]);
				}
				System.out.println("not anagram!");
				for(k=0;k<j;k++) {//anagram이 아닌 목록 출력
					System.out.println(array2[k]);
				}
				System.out.println("종료되었습니다.");
				break;
			}
			String second = sc.next();//두번째 문자열
			int result = anagram(first, second);//anagram 분석
			if (result == 0) {//anagram이면 array1에 삽입
				array1[i] = first + " " + second;
				i++;
			} 
			else {//anagram이 아니면 array2에 삽입
				array2[j] = first + " " + second;
				j++;
			}
		}
	}

	public static int anagram(String first, String second) {//anagram 분석 함수
		int count = 0;//결과값 변수(0일시 anagram)

		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {//a-z까지 문자 개수 세는 반복문
			int i = countalphabet(first, alphabet) - countalphabet(second, alphabet);
			int sum = countalphabet(first, alphabet) + countalphabet(second, alphabet);
			System.out.print(alphabet + " = " + sum + ", ");

			if (i < 0) {
				i = i * -1;
			}
			count += i;
		}
		System.out.println();
		return count;//anagram 분석 출력(0일시 anagram)
	}

	public static int countalphabet(String a, char b) {//문자열 개수 세는 함수
		int count = 0;

		if (a.indexOf(b) == -1) {
			return 0;
		}
		for (int i = 0; i < a.length(); i++) {//반복문에서 a-z까지 돌린 alphabet 중 하나 포함되면 그 alphabet에 count+1
			if (a.charAt(i) == b) {
				count++;
			}
		}

		return count;//갯수 출력(0 or 1)
	}
}
