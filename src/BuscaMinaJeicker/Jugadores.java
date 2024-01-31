package BuscaMinaJeicker;

import java.util.Scanner;

public class Jugadores {
	String Name;
	int GamesWin = 0;
	int nivel = 0;
	int xp = 0;
	static void veureJugador(Jugadores j, Jugadores j1, Jugadores j2, Jugadores j3, Jugadores j4) {
		if (j1 != null) {
			System.out.println();
			System.out.println("El jugador " + j1.Name + " a ganado: " + j1.GamesWin);
			System.out.println("Es nivel: " + j1.nivel);
		}
		if (j2 != null) {
			System.out.println();
			System.out.println("El jugador " + j2.Name + " a ganado:  " + j2.GamesWin);
			System.out.println("Es nivel: " + j2.nivel);
		}
		if (j3 != null) {
			System.out.println();
			System.out.println("El jugador " + j3.Name + " a ganado:  " + j3.GamesWin);
			System.out.println("Es nivel: " + j3.nivel);
		}
		if (j4 != null) {
			System.out.println();
			System.out.println("El jugador " + j4.Name + " a ganado:  " + j4.GamesWin);
			System.out.println("Es nivel: " + j4.nivel);
		}
		if (j1 == null && j2 == null && j3 == null && j4 == null) {
			System.out.println("No hay jugadores definidos");
		}
	}
	
	static Jugadores crearJugador() {
		Jugadores j = new Jugadores();
		System.out.println("Dime tu nombre: ");
		Scanner sc = new Scanner(System.in);
		j.Name = sc.nextLine();
		j.GamesWin = 0;
		return j;
	}
	
}
