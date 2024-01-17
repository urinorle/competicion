package ejercicios.Guillem.Recursivitat;

import java.util.Scanner;

public class ComConills {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();

		for (int i = 0; i < nCasos; i++) {
			int num = sc.nextInt();
			num = fibonacci(num);
			System.out.println(num);
		}
	}

	public static int fibonacci(int num) {
		if (num == 1) {
			return 1;
		} 
		if (num == 0) {
			return 0;
		} 
		return (fibonacci(num-1)+fibonacci(num-2));
		
	}

}
