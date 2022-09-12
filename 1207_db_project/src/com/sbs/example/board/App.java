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
			Class.forName("com.mysql.cj.jdbc.Driver"); // Mysql JDBC 드라이버 로딩
			String url = "jdbc:mysql://127.0.0.1:3306/practice?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
			// 연결 문자열 생성 => jdbc:mysql://네트워크 주소:포트 번호/연결 DB명?옵션1&옵션2&옵션3...

			conn = DriverManager.getConnection(url, "root", "");
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch(SQLException e) {
			System.out.println("에러 :" + e);
			
			while (true) {
				System.out.println("명령어 : ");
				String cmd = sc.nextLine();
				cmd = cmd.trim();
				
				doAction(conn,pstat,sc,cmd);
				
			}
			
			
			
		}finally { // 예외 상황이든 아니든 무조건 마지막에 실행하는 finally
	   		try {
	   			if (conn != null && !conn.isClosed()) {
	   				conn.close(); // 연결 종료
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
			
			System.out.println("제목 : ");
			title = sc.nextLine();
			System.out.println("내용 : ");
			body = sc.nextLine();
			
			try {
				

				String sql = "INSERT INTO article";
				sql += " SET regDate = now()";
				sql += ", updateDate = now()";
				sql += ", title = \"" + title + "\"";
				sql += ", body = \"" + body + "\"";

				pstat = conn.prepareStatement(sql);
				int affetedRows = pstat.executeUpdate();
				
				System.out.println("새 게시물이 추가되었습니다.");
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
					System.out.println("게시물이 존재하지 않습니다.");
					return 0;
				}
				System.out.println("번호 / 제목");
				while (rs.next()) {
					System.out.printf("%d / %s\n", rs.getInt("id"), rs.getString("title"));
				}
				System.out.println("모든 게시물이 조회되었습니다.");
			} catch (SQLException e) {
				System.out.println("에러: " + e);
			} finally { // 예외 상황이든 아니든 무조건 마지막에 실행하는 finally
				try {
					if (conn != null && !conn.isClosed()) {
						conn.close(); // 연결 종료
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				try {
					if (pstat != null && !pstat.isClosed()) {
						pstat.close(); // 연결 종료
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
				System.out.println("게시물이 삭제되었습니다.");
			} catch (SQLException e) {
				e.printStackTrace();
			} 

		}else if (cmd.startsWith("article modify ")) {
			int id = Integer.parseInt(cmd.split(" ")[2].trim());
		
			try {
				System.out.println("제목 : ");
				String title  = sc.nextLine();
				System.out.println("내용 : ");
				String body  = sc.nextLine();
				
				String sql = "UPDATE article";
				sql += " SET regDate = now()";
				sql += ", updateDate = now()";
				sql += ", title = \"" + title + "\"";
				sql += ", body = \"" + body + "\"";

				pstat = conn.prepareStatement(sql);
				pstat.executeUpdate(sql);
				
				System.out.println("게시물이 수정되었습니다.");
			} catch (SQLException e) {
				System.out.println("에러: " + e);
			} 
		}else if (cmd.equals("system exit")) {
			System.out.println("모든 프로그램을 종료합니다.");
			return -1;
		} else {
			System.out.println("명령어가 존재하지 않습니다.");
			return 0;
		}
		try {
				if (conn != null && !conn.isClosed()) {
					conn.close(); // 연결 종료
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstat != null && !pstat.isClosed()) {
					pstat.close(); // 연결 종료
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return 0;
	}
		
}
