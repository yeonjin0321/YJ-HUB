package test.kh0503;

// 더 큰타입은 더 작은 타입에 대입연산자를 통해서 재정의 할 수 없다.
// 메소드 앞에 fianl이 오면 오버라이딩이 안된다.
// 클래스 앞에 fianl이 오면 상속이 안된다.
public class Exam3 {

	public static void main(String[] args) {
		boolean isFail = false;
		Exam3 e3 = new Exam3();

		System.out.println(e3); // 주소번지 출력됨.
		
		//디폴트 생성자가 호출된다.
		// uVO를 인스턴스(참조형)변수라 한다.
		// 디폴트 생성자를 호출했을 때는 mem_id =null, mem_pw =null, birth = null 초기화
		UserVO uVO = new UserVO();
		// 디폴트 생성자를 호출했을 때는 mem_id =banana, mem_pw =156, birth = 1999-12-25로 초기화
		uVO = new UserVO("banana", "156", "1999-12-25"); //파라미터에 값이 없으면, 밑에 null로 출력됨.
		System.out.println(uVO.getMem_id());
		System.out.println(uVO.getMem_pw());
		System.out.println(uVO.getBirth());

	}
}
