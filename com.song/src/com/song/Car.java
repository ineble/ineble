package com.song;

public class Car {//카 클래스
	int speed; //필드
	
	void run() { //메소드
		System.out.println(speed + "으로 달립니다.");
	}

	public static void main(String[] args) {//정적 메소드
		Car myCar = new Car();
		
		myCar.speed = 60; //객체를 통한 필드 접근 why-> 인스텀스 필드니깐
		myCar.run(); //객체를 통한 메소드 접근
	}
}
