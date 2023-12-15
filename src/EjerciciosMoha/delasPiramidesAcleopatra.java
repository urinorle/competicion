package EjerciciosMoha;

import java.util.Scanner;

public class delasPiramidesAcleopatra {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int nCasos = sc.nextInt();

		for (int i = 0; i < nCasos; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();

			if ((A > 0 && B > 0 && C > 0) || (A < 0 && B < 0 && C < 0)) {
				int distAB = B - A;
				int distBC = C - B;
				if (distAB > distBC) {
					System.out.println(C);
				} else if (distAB < distBC) {
					System.out.println(A);
				} else {
					System.out.println("EMPATE");
				}
			}

			if (A < 0 && B > 0 && C > 0) {
				int distAB = B - A - 1;
				int distBC = C - B;
				if (distAB > distBC) {
					System.out.println(C);
				} else if (distAB < distBC) {
					System.out.println(A);
				} else {
					System.out.println("EMPATE");
				}
			}

			if (A < 0 && B < 0 && C > 0) {
				int distAB = B - A;
				int distBC = C - B - 1;
				if (distAB > distBC) {
					System.out.println(C);
				} else if (distAB < distBC) {
					System.out.println(A);
				} else {
					System.out.println("EMPATE");
				}
			}

		}

	}

}
