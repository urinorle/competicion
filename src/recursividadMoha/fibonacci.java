package recursividadMoha;

import java.util.Scanner;

public class fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		System.out.println("Sucesión de Fibonacci hasta el número " + n + ":");

		for (int i = 0; i < n; i++) {
			System.out.print(calcularFibonacci(i) + " ");
		}
	}

	public static int calcularFibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
		}
	}

}
