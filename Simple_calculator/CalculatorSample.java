package calculatorProject;

import java.util.Scanner;
public class CalculatorSample {
	public static int arithmetic(int operator,int a,int b) {
		int op=0;
		switch(operator) {
		case 1:
			op=a+b;
			break;
		case 2:
			op=a-b;
			break;
		case 3:
			op=a*b;
			break;
		case 4:
			op=a/b;
			break;
		case 5:
			op=a%b;
			break;
		default:
			System.out.println("You gave invalid operator");
		}
		return op;
	}
	public static int bitwise(int operator,int a,int b) {
		int op=0;
		switch(operator) {
		case 1:
			op=a & b;
			break;
		case 2:
			op=a | b;
			break;
		case 3:
			op=a ^ b;
			break;
		default:
			System.out.println("You gave invalid operator");
		}
		return op;
	}
	public static int bitwiseNot(int operator, int a) {
	    int op = 0;
	    if (operator == 4) {
	        op = ~a;
	    } else {
	        System.out.println("You gave invalid operator");
	    }
	    return op;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		boolean isContinue=true;
		System.out.println("Calculator");
		while(isContinue) {
		System.out.println("Enter the number for operation : \n 1.Arithmetic operation \n 2.Bitwise operation");
		int o=sc.nextInt();
		switch(o) {
		case 1:
			System.out.println("1.Addition 2.Subtraction 3.Multiplication 4.Division 5.Modulus");
			int operator=sc.nextInt();
			System.out.println("Enter first number :");
			int x=sc.nextInt();
			System.out.println("Enter second number :");
			int y=sc.nextInt();
			System.out.println(arithmetic(operator,x,y));
			break;
		case 2:
			System.out.println("1.bitwise And 2.bitwise Or 3.bitwise XOr 4.bitwise Not");
			int operator1=sc.nextInt();
			System.out.println("Enter first number :");
			int a=sc.nextInt();
			int b=0;
			if (operator1 !=4 ) {
				System.out.println("Enter second number :");
				b=sc.nextInt();
				System.out.println(bitwise(operator1,a,b));
			}
			else
				System.out.println(bitwiseNot(operator1,a));
			break;
		default:
			System.out.println("You gave invalid operation");
		}
		System.out.println("Do you want to continue: yes(1) / no(0)");
		int cont=sc.nextInt();
		if(cont == 0) {
			isContinue = false;
		}
		}
		 System.out.println("Exiting the calculator. Goodbye!");
	        sc.close();
}}