package com.appium.practice.Appium;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s="Ratnakar";
		for(int i=0;i<s.length();i++){
			System.out.print(s.charAt(i));
			for(int j=1;j<=i+1;j++){
				System.out.print("*");
				
			}
			
			
		}

	}

}
