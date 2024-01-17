package EjerciciosJeicker;

import java.util.*;

public class ComConills {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int nCasos = sc.nextInt();
		
		for(int i=0; i<nCasos;i++) {
			int num = sc.nextInt();
			int num2 = fibonacci(num);
			System.out.println(num2);
		}
		
	}

	private static int fibonacci(int num) {
		if(num == 1) {
			return 1;
		}
		if(num == 0) {
			return 0;
		}
		return (fibonacci(num-1) + fibonacci(num-2));
		
	}

}
