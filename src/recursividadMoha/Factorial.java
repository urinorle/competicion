package recursividadMoha;

import java.util.Scanner;

public class Factorial {
	public static int aux = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Calculem el factorial del número que digas a continuación:");
		int n = sc.nextInt();
		calcularFactorial(n);
		System.out.println(aux);
	}

	public static int calcularFactorial(int número) {

		if (número != 1 && número != 0) {
			aux *= número;
			número--;
			calcularFactorial(número);
		} else {
			return aux;
		}
		return número;
	}

}
