package practice_v1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import practice_v1.util.DBUtil;
import practice_v1.util.SecSql;

public class App {
	public void run() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;

		while (true) {
			System.out.println("명령어 : ");
			String cmd = sc.nextLine();
			cmd.trim();
			int actionResult = doAction(conn, sc, cmd);

			if (actionResult == -1) {
				break;
			}
		}

	}

	private int doAction(Connection conn, Scanner sc, String cmd) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Mysql JDBC 드라이버 로딩
			String url = "jdbc:mysql://127.0.0.1:3306/practice?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=UTC&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
			// 연결 문자열 생성 => jdbc:mysql://네트워크 주소:포트 번호/연결 DB명?옵션1&옵션2&옵션3...
			conn = DriverManager.getConnection(url, "root", ""); // Mysql JDBC 드라이버 연결 메소드 => (연결 문자열, 데이터베이스 ID, 데이터베이스
																	// PASSWORD)

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러" + e);
		}
		if (cmd.length() == 0) {
			System.out.println("입력된 명령어가 존재하지 않습니다.");
			return 0; // 일반적으로 끝냄
		}
		if (cmd.equals("Article write")) {
			System.out.println("== 게시글 작성 ==");
			System.out.println("제목 : ");
			String title = sc.nextLine();
			System.out.println("내용 : ");
			String body = sc.nextLine();

			SecSql sql = new SecSql();
			sql.append("INSERT INTO article");
			sql.append("SET regDate = now()");
			sql.append(", updateDate = now()");
			sql.append(", title = ?", title);
			sql.append(", body = ?", body);
			int id = DBUtil.insert(conn, sql);
			System.out.printf("%d번 게시물 작성 완료!!!!\n", id);

		} else if (cmd.equals("Article list")) { // 전체 보기
			System.out.println("== 게시글 목록 ==");
			List<article> articles = new ArrayList<>();
			SecSql sql = new SecSql();
			sql.append("SELECT * FROM article");
			sql.append(" ORDER BY id DESC");

			List<Map<String, Object>> articleListMap = DBUtil.selectRows(conn, sql);

			for (Map<String, Object> articleMap : articleListMap) {
				articles.add(new article(articleMap));
			}

			if (articles.size() == 0) {
				System.out.println("게시글이 존재하지 않습니다.");
				return 0;
			}
			System.out.println("번호 / 제목");
			for (article article : articles) {
				System.out.printf("%d / %s\n", article.id, article.title);
			}
			System.out.println("게시글 조회 완료!");

		} else if (cmd.startsWith("Article modify ")) { // 내가 정한 번호의 게시물 수정
			System.out.println("== 게시글 수정 ==");
			
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
			System.out.println("제목 :");
			String title = sc.nextLine();
			System.out.println("내용 :");
			String body = sc.nextLine();

			SecSql sql = new SecSql();
			sql.append("UPDATE article");
			sql.append("SET regDate = now()");
			sql.append(", updateDate = now()");
			sql.append(", title = ?", title);
			sql.append(", body = ?", body);
			sql.append("WHERE id = ?", id);
			DBUtil.update(conn, sql);
			System.out.printf("%d번 게시물 수정 완료!!\n", id);
			
		} else if (cmd.startsWith("Article delete ")) { // 내가 정한 번호의 게시물 수정
			System.out.println("== 게시글 삭제 ==");
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
			SecSql sql = new SecSql();
			sql.append("DELETE FROM article");
			sql.append("WHERE id = ?", id);

			DBUtil.delete(conn, sql);
			System.out.printf("%d번 게시글 삭제 완료!\n", id);
		} else if (cmd.equals("system exit")) {
			System.out.println("프로그램을 종료합니다.");
			return -1;
		} else {
			System.out.println("존재하지 않는 명령어입니다.");
			return 0;
		}
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close(); // 연결 종료
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
