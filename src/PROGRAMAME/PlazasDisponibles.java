package PROGRAMAME;

import java.util.Scanner;

public class PlazasDisponibles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();

		for (int i = 0; i < nCasos; i++) {
			int nEquipos = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int d = sc.nextInt();
			int e = sc.nextInt();
			int f = sc.nextInt();
			System.out.println(nEquipos - (a + b + c + d + e + f));
		}

	}

}
