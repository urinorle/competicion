package EjerciciosMoha;

import java.util.Scanner;

public class LaAlturaDeLaPirámide {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0;; i++) {
			int bloques = sc.nextInt();
			if (bloques == 0) {
				break;
			}
			int planta = 0;
			for (int j = 1;; j++) {
				if (j % 2 == 1) {
					int cuadrado = j * j;
					if (cuadrado <= bloques) {
						planta++;
					} else {
						System.out.println(planta);
						break;
					}
				}
			}

		}

	}

}
