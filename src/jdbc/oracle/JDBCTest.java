package jdbc.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCTest {

	public static void main(String[] args) {
		// 물리적으로 떨어져 있는 오라클 서버와 연결통로를 만든다.
		// 메소드 호출로 객체생성 가능하다.
		// getConnection(URL,username,pw)
		Connection con = null;
		// 오라클 서버에 sql문을 전달할 때 사용함.
		PreparedStatement pstmt = null;
		// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함.
		ResultSet rs = null;

		String sql = "SELECT deptno, dname, loc From dept";
		// 꼭 예외처리 해줘야한다.
		try {
			// 오라클 제조사가 제공하는 드라이버 클래스가 있어야함.
			// 있는 위치는 C:\app\yeonc\product\11.1.0\db_1\jdbc\lib 아래에 ojdbc6.jar 안에 있다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@192.168.35.196:1521:orcl11", "scott", "tiger");
			// 파라미터로 받은 셀렉트문을 전달
			pstmt = con.prepareStatement(sql);
			// 전달된 셀렉트 문에 대한 처리를 요청하고 커서 받아내기
			rs = pstmt.executeQuery();
			while (rs.next()) { // rs를 가져오고 sys에 뎁트,이름,지역을 인트형식으로(0,1,2) 받아온다.
				System.out.println(rs.getInt("deptno") + ", " + rs.getString("dname") + ", " + rs.getString("loc"));
			}
			System.out.println(con + "생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			// stack메모리에 쌓인 에러 메시지
			e.printStackTrace();

		}
	}

}
