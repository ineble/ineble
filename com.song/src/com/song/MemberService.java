package com.song;

public class MemberService {
	 
	public boolean login(String id, String password) {
		if(id == "hong") {
			if(password == "12345") {
				return true;
			}
		}
		return false;
	}
	
	public void logout(String id) {
		if(id == "hong") {
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		}
	}
}
