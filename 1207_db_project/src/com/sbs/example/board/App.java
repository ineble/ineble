package com.sbs.example.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
	public void run() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		PreparedStatement pstat = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Mysql JDBC ����̹� �ε�
			String url = "jdbc:mysql://127.0.0.1:3306/practice?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
			// ���� ���ڿ� ���� => jdbc:mysql://��Ʈ��ũ �ּ�:��Ʈ ��ȣ/���� DB��?�ɼ�1&�ɼ�2&�ɼ�3...

			conn = DriverManager.getConnection(url, "root", "");
		} catch(ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch(SQLException e) {
			System.out.println("���� :" + e);
			
			while (true) {
				System.out.println("��ɾ� : ");
				String cmd = sc.nextLine();
				cmd = cmd.trim();
				
				doAction(conn,pstat,sc,cmd);
				
			}
			
			
			
		}finally { // ���� ��Ȳ�̵� �ƴϵ� ������ �������� �����ϴ� finally
	   		try {
	   			if (conn != null && !conn.isClosed()) {
	   				conn.close(); // ���� ����
	   			}
	   		} catch (SQLException e) {
	   			e.printStackTrace();
	   		}
	   	}
		

	
	}

	private int doAction(Connection conn, PreparedStatement pstat, Scanner sc, String cmd) {

		if (cmd.equals("article write")) {
			String title;
			String body;
			
			System.out.println("���� : ");
			title = sc.nextLine();
			System.out.println("���� : ");
			body = sc.nextLine();
			
			try {
				

				String sql = "INSERT INTO article";
				sql += " SET regDate = now()";
				sql += ", updateDate = now()";
				sql += ", title = \"" + title + "\"";
				sql += ", body = \"" + body + "\"";

				pstat = conn.prepareStatement(sql);
				int affetedRows = pstat.executeUpdate();
				
				System.out.println("�� �Խù��� �߰��Ǿ����ϴ�.");
				System.out.println("affetedRows:" + affetedRows);

			} catch (SQLException e) {
				e.printStackTrace();
			

			} 
		}else if (cmd.equals("article list")) {
			
			ResultSet rs = null;
			try {
				String sql = "SELECT * FROM article";
				sql += " ORDER BY id ASC";

				pstat = conn.prepareStatement(sql);
				rs = pstat.executeQuery(sql);
				if (rs == null) {
					System.out.println("�Խù��� �������� �ʽ��ϴ�.");
					return 0;
				}
				System.out.println("��ȣ / ����");
				while (rs.next()) {
					System.out.printf("%d / %s\n", rs.getInt("id"), rs.getString("title"));
				}
				System.out.println("��� �Խù��� ��ȸ�Ǿ����ϴ�.");
			} catch (SQLException e) {
				System.out.println("����: " + e);
			} finally { // ���� ��Ȳ�̵� �ƴϵ� ������ �������� �����ϴ� finally
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close(); // ���� ����
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (pstat != null && !pstat.isClosed()) {
						pstat.close(); // ���� ����
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}else if (cmd.startsWith("article delete ")) {
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
			
			try {
				String sql = "DELETE FROM article";
				sql += " WHERE id =" + id;
				pstat = conn.prepareStatement(sql);
				pstat.execute(sql);
				System.out.println("�Խù��� �����Ǿ����ϴ�.");
			} catch (SQLException e) {
				e.printStackTrace();
			} 

		}else if (cmd.startsWith("article modify ")) {
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
		
			try {
				System.out.println("���� : ");
				String title  = sc.nextLine();
				System.out.println("���� : ");
				String body  = sc.nextLine();
				
				String sql = "UPDATE article";
				sql += " SET regDate = now()";
				sql += ", updateDate = now()";
				sql += ", title = \"" + title + "\"";
				sql += ", body = \"" + body + "\"";

				pstat = conn.prepareStatement(sql);
				pstat.executeUpdate(sql);
				
				System.out.println("�Խù��� �����Ǿ����ϴ�.");
			} catch (SQLException e) {
				System.out.println("����: " + e);
			} 
		}else if (cmd.equals("system exit")) {
			System.out.println("��� ���α׷��� �����մϴ�.");
			return -1;
		} else {
			System.out.println("��ɾ �������� �ʽ��ϴ�.");
			return 0;
		}
		try {
				if (conn != null && !conn.isClosed()) {
					conn.close(); // ���� ����
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstat != null && !pstat.isClosed()) {
					pstat.close(); // ���� ����
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
		
}
