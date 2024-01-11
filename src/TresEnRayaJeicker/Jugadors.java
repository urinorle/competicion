package TresEnRayaJeicker;

import java.util.*;

import memory.Jugador;

public class Jugadors {
	String Name;
	int GamesWin;
	int GamesLoses;
	
	static void veureJugador(Jugadors j, Jugadors j1) {
		if (j != null) {
			System.out.println();
			System.out.println("El jugador " + j.Name + " ha guanyat " + j.GamesWin + " ha perdut: " + j.GamesLoses);
		}
		if (j1 != null) {
			System.out.println();
			System.out.println("El jugador " + j1.Name + " ha guanyat " + j1.GamesWin + " ha perdut: " + j1.GamesLoses);
			System.out.println();
		}
		if (j == null) {
			System.out.println("No hay jugadores definidos");
		}
	}
	
	static Jugadors crearJugador() {
		Jugadors j = new Jugadors();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.Name = sc.nextLine();
		j.GamesWin = 0;
		j.GamesLoses = 0;
		return j;
	}
	
}
