package com.song.java;

class Data<T>{
	T obj;
	Data(T ob){
		obj = ob;
	}
	T getObj() {
		return obj;
	}
}

public class Printer {
	public <T> void println(T obj){
		System.out.println(obj);
	}
	
}
