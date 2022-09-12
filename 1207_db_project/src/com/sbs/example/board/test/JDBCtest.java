package com.sbs.example.board.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCtest {

	public static void main(String[] args) {
		Connection conn = null; // DB ���� ��ü

	   	try {
	   		Class.forName("com.mysql.cj.jdbc.Driver"); // Mysql JDBC ����̹� �ε�
	   		String url = "jdbc:mysql://127.0.0.1:3306/text_board?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
	   		// ���� ���ڿ� ���� => jdbc:mysql://��Ʈ��ũ �ּ�:��Ʈ ��ȣ/���� DB��?�ɼ�1&�ɼ�2&�ɼ�3...

	   		conn = DriverManager.getConnection(url, "root", ""); // Mysql JDBC ����̹� ���� �޼ҵ� => (���� ���ڿ�, �����ͺ��̽� ID, �����ͺ��̽� PASSWORD)
	   		// Connection ��ü�� ��ȯ => ������ conn�� �̿��ؼ� �������� ������ �����Դϴ�.

	   	} catch (ClassNotFoundException e) {
	   		System.out.println("����̹� �ε� ����");
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
	   	}
	}

}
