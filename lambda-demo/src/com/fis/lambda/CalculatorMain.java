package com.fis.lambda;

import java.rmi.server.Operation;

public class CalculatorMain {

	public static void main(String[] args) {
		
		
		CalculatorImpl c=new CalculatorImpl();
		System.out.println(c.operation(1, 2));
		
		//Anonymous class name
		Calculator cal1= new Calculator() {
			
			@Override
			public int operation(int a, int b) {
				// TODO Auto-generated method stub
				return a+b;
			}
		};
		
		System.out.println(cal1.operation(10,120));
		
		
		
		//Lambda function
		
		Calculator cal2=(a,b)->a+b;
		
		System.out.println(cal2.operation(200,300));
		
		
		
		

	}

}
