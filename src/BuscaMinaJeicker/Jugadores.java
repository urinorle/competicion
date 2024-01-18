package BuscaMinaJeicker;

import java.util.Scanner;

public class Jugadores {
	String Name;
	int GamesWin = 0;
	int GamesLoses = 0;
	//a
	static void veureJugador(Jugadores j, Jugadores j1) {
		if (j != null) {
			System.out.println();
			System.out.println("El jugador " + j.Name + " a ganado: " + j.GamesWin + " a perdido: " + j.GamesLoses);
		}
		if (j1 != null) {
			System.out.println();
			System.out.println("El jugador " + j1.Name + " a ganado:  " + j1.GamesWin + " a perdido: " + j1.GamesLoses);
			System.out.println();
		}
		if (j == null) {
			System.out.println("No hay jugadores definidos");
		}
	}
	
	static Jugadores crearJugador() {
		Jugadores j = new Jugadores();
		System.out.println("Dime tu nombre: ");
		Scanner sc = new Scanner(System.in);
		j.Name = sc.nextLine();
		j.GamesWin = 0;
		j.GamesLoses = 0;
		return j;
	}
	
}
