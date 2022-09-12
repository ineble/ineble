import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ArticleDB {
	String uri = "jdbc:mysql://localhost:3306/test?serverTimezone=UTC";
	String user = "root";
	String pass = "";
	String driver = "com.mysql.cj.jdbc.Driver";
	
	private Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(uri,user,pass);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public ArrayList<Article> getArticleList(){
		String sql = "SELECT * FROM article";
		Connection conn = getConnection();
		
		ArrayList<Article> articleList = new ArrayList<>();
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
				while(rs.next()) {
					int idx = rs.getInt("idx");
					String title = rs.getString("title");
					String body = rs.getString("body");
					String regDate = rs.getString("regDate");
					Article addr = new Article(idx,title,body,regDate);
					articleList.add(addr);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return articleList;
		}
	
	public void InsertData() {
		String sql = String.format("INSERT INTO FROM article SET title = `Á¦¸ñ`, body = `body`, regDate = `2022-02-02`");
		Connection conn = getConnection();
		Statement stmt = null;
		try{
			stmt.executeUpdate(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
