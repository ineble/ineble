package com.song;

public class Car {//ī Ŭ����
	int speed; //�ʵ�
	
	void run() { //�޼ҵ�
		System.out.println(speed + "���� �޸��ϴ�.");
	}

	public static void main(String[] args) {//���� �޼ҵ�
		Car myCar = new Car();
		
		myCar.speed = 60; //��ü�� ���� �ʵ� ���� why-> �ν��ҽ� �ʵ�ϱ�
		myCar.run(); //��ü�� ���� �޼ҵ� ����
	}
}
