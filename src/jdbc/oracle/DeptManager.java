package jdbc.oracle;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;

public class DeptManager extends JFrame implements ActionListener { // jfram상속, 액션리스너 안에는 추상매소드가 있다.
	public final String _DRIVER = "oracle.jdbc.driver.OracleDriver";
	public final String _URL = "jdbc:oracle:thin:@192.168.35.196:1521:orcl11";
	public final String _USER = "scott";
	public final String _PW = "tiger";
	Connection con = null; // 인터페이스 -단독으로 인스턴스 불가 A a = new A()
	// 오라클 서버에 sql문을 전달할 때 사용함.
	PreparedStatement pstmt = null;
	// 조회결과를 받아서 자바에서 출력할 때 오라클에 커서를 조작해야 함.
	ResultSet rs = null;
	
	String sql = "SELECT deptno, dname, loc From dept";
	JButton jbtn_select = new JButton("조회");

	public DeptManager() { // 생성자호출
		// 이벤트 처리를 담당하는 핸들러 클래스의 주소번지
		// 내안에 액션퍼폼드 메소드가 재정의 되어있다면, this(나)를 쓴다.
		jbtn_select.addActionListener(this); // 셀렉트 버튼 클릭시 액션 퍼폼드 생성으로 자료 생성
		initDisplay(); // 화면창 생성! 둘의 순서는 상관이 없음 이미 조회버튼 생성이 되어있으니까.
	}

	public List<Map<String, Object>> getDeptList() {
		List<Map<String, Object>> deptList = null;
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
			rs = pstmt.executeQuery();
			deptList = new ArrayList<>();
			Map<String, Object> rmap = null;
			while (rs.next()) {
				rmap = new HashMap<>();
				rmap.put("deptno", rs.getInt("deptno"));
				rmap.put("dname", rs.getString("dname"));
				rmap.put("loc", rs.getString("loc"));
				deptList.add(rmap);

			}

			System.out.println(con + "생성 되었나요?");
		} catch (Exception e) {
			System.out.println("오라클 서버와 연결 통로 확보 실패");
			// stack메모리에 쌓인 에러 메시지
			e.printStackTrace();

		}

		return deptList; //자료 리스트 반환.
	}

	public void initDisplay() { //셀렉트 버튼 생성.
		this.add("North", jbtn_select);
		this.setSize(500, 400);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new DeptManager();
	}

	@Override // 추상매소드를 재정의 액션 퍼폼드. 셀렉트.
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbtn_select) { //셀렉트 버튼과 눌렀을때 그 소스가 같다면.
			List<Map<String, Object>> deptList = getDeptList(); // deptList 얻어오기
			for (int i = 0; i < deptList.size(); i++) { // for문으로 루핑하여 하나씩 뽑기.
				Map<String, Object> rmap = deptList.get(i); //rmap <
				System.out.println(rmap.get("deptno"));
			}
		}
	}

}
