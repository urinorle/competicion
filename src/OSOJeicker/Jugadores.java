package OSOJeicker;

import java.util.Scanner;

public class Jugadores {
    String nomJugador;
	int partidesGuanyades;
	int partidesPerdudes;
	
	static void veureJugador(Jugadores j) {
		System.out.println("El jugador " + j.nomJugador + " ha guanyat " + j.partidesGuanyades + " ha perdut: " + j.partidesPerdudes);
	}
	
	static Jugadores crearJugador() {
		Jugadores j = new Jugadores();
		System.out.println("Digues el nom: ");
		Scanner sc = new Scanner(System.in);
		j.nomJugador = sc.nextLine();
		j.partidesGuanyades = 0;
		j.partidesPerdudes = 0;
		return j;  
	}
    
}
