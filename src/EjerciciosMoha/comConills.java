package EjerciciosMoha;

import java.util.Scanner;

public class comConills {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numCasos = sc.nextInt();
		for (int a = 0; a < numCasos; a++) {
			int numero = sc.nextInt();

			for (int i = 1; i <= numero; i++) {
				if (i == numero) {
					System.out.print(fibonacci(i) + " ");
				}
			}
		}

	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}
}
