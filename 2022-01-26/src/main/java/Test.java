import java.sql.Connection;
import java.sql.DriverManager;

public class Test {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String pass = "";
		
		Connection conn = null;
		
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("����̹� �˻� ����!");
			conn = DriverManager.getConnection(url,user,pass);
			System.out.println("���� ����" + conn);
		} catch(Exception e) {
			System.out.println("����̹� ��");
			e.printStackTrace();
		}
		
	}
}
