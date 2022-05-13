package com.day18;
//구구단 중에서 시작단과 끝단을 입력받아서  출력하는 프로그램을 작성하시오.

//스캐너 없이 이중포문만을 사용.

public class Test_1 {
	public static void main(String[] args) {

		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				int result = i * j;
				System.out.println(i + "*" + j + "=" + result);
			}
			System.out.println(); // 한줄씩 띄우기
		}
	}
}