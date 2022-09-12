package com.song;

public class practice {

	public static void main(int [] data) {
		int i,j;
		int arr[]  = {8,2,4,9,13,5};
		for(i= 0 ; i<arr.length-1;i++) {
			for(j=1; j<arr.length; j ++) {
				if(arr[i]>arr[j]) {
					int tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
		for(i = 0; i < arr.length-1;i++) {
		System.out.println(arr[i]);
		}
	}
}

