package jocOSO_Guillem;

import java.util.Scanner;

public class Jugadors {
	String nom;
	int partidesWin = 0;
	int partidesJugades = 0;
	
	static Jugadors definirjugador() {
		Jugadors j = new Jugadors();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.nom = sc.nextLine();
		j.partidesWin = 0;
		return j;
	}
}
