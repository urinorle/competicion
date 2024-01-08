package memory;

import java.util.Scanner;

public class Jugador {
	String nomJugador;
	int partidesGuanyades;
	int partidesPerdudes;
	
	static void veureJugador(Jugador j) {
		System.out.println("El jugador " + j.nomJugador + " ha guanyat " + j.partidesGuanyades + " ha perdut: " + j.partidesPerdudes);
	}
	
	static Jugador crearJugador() {
		Jugador j = new Jugador();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.nomJugador = sc.nextLine();
		j.partidesGuanyades = 0;
		j.partidesPerdudes = 0;
		return j;
	}
	
}
