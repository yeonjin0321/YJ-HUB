package com.day12;

import java.util.Random;
import java.util.Scanner;
import java.util.Scanner;

public class RandomGame_1 {
	//static이 있는 메소드에 대해서는 인스턴스화 없이
	//클래스 타입.메소드명으로 호출이 가능하다.
	public static void gameStart() { //메소드 앞에 static이 있는 형태.
		int cnt = 1; //회차를 관리한다. 전변?지변?, 언제 반복문을 탈출할 것인가?
		Random r = new Random(); // 참조형 클래스 변수이름이 r 이다.
		int dap = r.nextInt(10); // 0이상 10미만의 점수를 리턴해 준다. 입력 전에 채번해야한다.
		Scanner scan = new Scanner(System.in);

		System.out.println("0부터 9까지의 숫자를 입력하시오."); // 사용자가 입력한 값을 담을 변수 선언.
		String str = null; // 선언먼저

		while ((str = scan.next()) != null) { // 입력된 값이 null값이 아닌동안 진행된다. 몇번인지는 정해지지 않았다.
			if (Integer.parseInt(str) == dap) {
				System.out.println("마따~");
				break;
			} else if (Integer.parseInt(str) > dap) {
				System.out.println("나차라~");
				cnt--;
			} else if (Integer.parseInt(str) < dap) {
				System.out.println("노피라~");
				cnt--;
			} 
			if (cnt == 0) {
				System.out.println("다섯번의 기회를 다 소진하셨습니다.");
				System.out.println("답은 " + dap+ "입니다");
				break;
		}
		System.out.println("while문을 탈출하면 여기가 출력된다.");
	}

	public static void main(String[] args) {
		// 메소드 호출시 구현된 메소드 앞에 static이 있으면 인스턴스화 없이 클래스 타입.메소드 명으로 호출이 가능하다
		RandomGame_1.gameStart();
	}

}
