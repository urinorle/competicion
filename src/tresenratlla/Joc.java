package tresenratlla;

import java.util.Scanner;

public class Joc {

	public static void inicialitzar(Jugadors j1, char[][] tauler) {
		if (j1 != null) {
			for (int i = 0; i < Menu.mesura; i++) {
				for (int j = 0; j < Menu.mesura; j++) {
					tauler[i][j] = '-';
				}
			}
		} else {
			System.out.println("Escull primer els jugadors!!");
		}

	}

	public static void mostrar(char[][] tauler) {
		for (int i = 0; i < Menu.mesura; i++) {
			for (int j = 0; j < Menu.mesura; j++) {
				System.out.print(tauler[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void jugada() {
		System.out.println("Comença el j1");
		
	}

	
	
	
}
