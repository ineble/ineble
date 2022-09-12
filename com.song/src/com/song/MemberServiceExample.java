package com.song;

public class MemberServiceExample {

	public static void main(String[] args) { //정적메소드
		MemberService memberService = new MemberService(); //인스턴스 멤버를 사용하고 싶음 -> 여기서는 메소드들 //객체의 생성-> 참조 변수로 함수에 접근
		
		boolean result = memberService.login("hong", "12345"); 
		if(result) {	
			System.out.println("로그인 되었습니다.");
			memberService.logout("hong");
		}else {
			System.out.println("id 또는 password가 올바르지 않습니다.");
		}

	}

}
