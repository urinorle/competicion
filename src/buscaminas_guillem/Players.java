package buscaminas_guillem;

import java.util.Scanner;

public class Players {
	String nom;
	int partidesWin = 0;
	int lvl = 0;
	int exp = 0;

	static void veureJugador(Players j1, Players j2, Players j3, Players j4) {
		if (j1 != null) {
			System.out.println("El jugador " + j1.nom + " ha guanyat " + j1.partidesWin);
			System.out.println("Es nivell" + j1.lvl);
		}
		if (j1 != null) {
			System.out.println("El jugador " + j2.nom + " ha guanyat " + j2.partidesWin);
			System.out.println("Es nivell" + j2.lvl);
		}

		if (j1 != null) {
			System.out.println("El jugador " + j3.nom + " ha guanyat " + j3.partidesWin);
			System.out.println("Es nivell" + j3.lvl);
		}

		if (j1 != null) {
			System.out.println("El jugador " + j4.nom + " ha guanyat " + j4.partidesWin);
			System.out.println("Es nivell" + j4.lvl);
		}

	}

	static Players definirjugador() {
		Players j = new Players();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.nom = sc.nextLine();
		j.partidesWin = 0;
		return j;
	}

}
