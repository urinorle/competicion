package tresenratlla;

import java.util.Scanner;

public class Jugadors {
	String nom;
	int partidesWin = 0;
	int partidesLose = 0;
	
	static void veureJugador(Jugadors j1, Jugadors j2) {
		if (j1 != null) {
			System.out.println("El jugador " + j1.nom + " ha guanyat " + j1.partidesWin + " ha perdut: " + j1.partidesLose);
		}
		if (j2 != null) {
			System.out.println("El jugador " + j2.nom + " ha guanyat " + j2.partidesWin + " ha perdut: " + j2.partidesLose);
		}
		if (j1 == null) {
			System.out.println("Escull primer els jugadors!!");
		}
	}
	
	static Jugadors definirjugador() {
		Jugadors j = new Jugadors();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.nom = sc.nextLine();
		j.partidesWin = 0;
		j.partidesLose = 0;
		return j;
	}
}


