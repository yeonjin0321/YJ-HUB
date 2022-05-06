package test.kh0503;

// 더 큰타입은 더 작은 타입에 대입연산자를 통해서 재정의 할 수 없다.
public class Exam2 {
	// 너는 클래스급인데 왜 문자열 값이 나오지?
	String name = "이순신";

	public static void main(String[] args) {
		Exam2 e2 =new Exam2();
		System.out.println(e2.name);
	}

}
