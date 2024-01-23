package buscaminas_guillem;

import java.util.Scanner;


public class Players {
	String nom;
	int partidesWin = 0;
	int partidesLose = 0;
	
	static void veureJugador(Players j1) {
		if (j1 != null) {
			System.out.println("El jugador " + j1.nom + " ha guanyat " + j1.partidesWin + " ha perdut: " + j1.partidesLose);
		}
		if (j1 == null) {
			System.out.println("Escull primer el jugador!!");
		}
	}
	
	static Players definirjugador() {
		Players j = new Players();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.nom = sc.nextLine();
		j.partidesWin = 0;
		j.partidesLose = 0;
		return j;
	}
	
	public static void ranking() {
		// TODO Auto-generated method stub

	}
}
