package test.kh0503;

// 더 큰타입은 더 작은 타입에 대입연산자를 통해서 재정의 할 수 없다.
public class Exam1 {

	public static void main(String[] args) {

		int i = 5;
		double d = 1.5;
		i = (int) d; // 더블이 더 넓은 범위의 값을 담을 수 있음.
		// 따라서 치환이 불가능함 i =d;
		System.out.println(i); //5 -> 바꾸면 1 (정수형)
		boolean isOk = false; // 초기화 꼭 해줘야함 지변이라.
		//조건을 만족하지 않으면 단 한번도 실행기회는 없다.
		if(isOk) {
			float f = 1.5f;	
		}else {
			
		}
		//System.out.println(f);
		Exam1 e1 =new Exam1();
		// 지변은 인스턴스변수.변수명 이렇게 쓸수 없다 System.out.println(e1.i); 
	}

}
