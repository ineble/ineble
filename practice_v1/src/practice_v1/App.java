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
			System.out.println("��ɾ� : ");
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
			Class.forName("com.mysql.cj.jdbc.Driver"); // Mysql JDBC ����̹� �ε�
			String url = "jdbc:mysql://127.0.0.1:3306/practice?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=UTC&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
			// ���� ���ڿ� ���� => jdbc:mysql://��Ʈ��ũ �ּ�:��Ʈ ��ȣ/���� DB��?�ɼ�1&�ɼ�2&�ɼ�3...
			conn = DriverManager.getConnection(url, "root", ""); // Mysql JDBC ����̹� ���� �޼ҵ� => (���� ���ڿ�, �����ͺ��̽� ID, �����ͺ��̽�
																	// PASSWORD)

		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("����" + e);
		}
		if (cmd.length() == 0) {
			System.out.println("�Էµ� ��ɾ �������� �ʽ��ϴ�.");
			return 0; // �Ϲ������� ����
		}
		if (cmd.equals("Article write")) {
			System.out.println("== �Խñ� �ۼ� ==");
			System.out.println("���� : ");
			String title = sc.nextLine();
			System.out.println("���� : ");
			String body = sc.nextLine();

			SecSql sql = new SecSql();
			sql.append("INSERT INTO article");
			sql.append("SET regDate = now()");
			sql.append(", updateDate = now()");
			sql.append(", title = ?", title);
			sql.append(", body = ?", body);
			int id = DBUtil.insert(conn, sql);
			System.out.printf("%d�� �Խù� �ۼ� �Ϸ�!!!!\n", id);

		} else if (cmd.equals("Article list")) { // ��ü ����
			System.out.println("== �Խñ� ��� ==");
			List<article> articles = new ArrayList<>();
			SecSql sql = new SecSql();
			sql.append("SELECT * FROM article");
			sql.append(" ORDER BY id DESC");

			List<Map<String, Object>> articleListMap = DBUtil.selectRows(conn, sql);

			for (Map<String, Object> articleMap : articleListMap) {
				articles.add(new article(articleMap));
			}

			if (articles.size() == 0) {
				System.out.println("�Խñ��� �������� �ʽ��ϴ�.");
				return 0;
			}
			System.out.println("��ȣ / ����");
			for (article article : articles) {
				System.out.printf("%d / %s\n", article.id, article.title);
			}
			System.out.println("�Խñ� ��ȸ �Ϸ�!");

		} else if (cmd.startsWith("Article modify ")) { // ���� ���� ��ȣ�� �Խù� ����
			System.out.println("== �Խñ� ���� ==");
			
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
			System.out.println("���� :");
			String title = sc.nextLine();
			System.out.println("���� :");
			String body = sc.nextLine();

			SecSql sql = new SecSql();
			sql.append("UPDATE article");
			sql.append("SET regDate = now()");
			sql.append(", updateDate = now()");
			sql.append(", title = ?", title);
			sql.append(", body = ?", body);
			sql.append("WHERE id = ?", id);
			DBUtil.update(conn, sql);
			System.out.printf("%d�� �Խù� ���� �Ϸ�!!\n", id);
			
		} else if (cmd.startsWith("Article delete ")) { // ���� ���� ��ȣ�� �Խù� ����
			System.out.println("== �Խñ� ���� ==");
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
			SecSql sql = new SecSql();
			sql.append("DELETE FROM article");
			sql.append("WHERE id = ?", id);

			DBUtil.delete(conn, sql);
			System.out.printf("%d�� �Խñ� ���� �Ϸ�!\n", id);
		} else if (cmd.equals("system exit")) {
			System.out.println("���α׷��� �����մϴ�.");
			return -1;
		} else {
			System.out.println("�������� �ʴ� ��ɾ��Դϴ�.");
			return 0;
		}
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close(); // ���� ����
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
