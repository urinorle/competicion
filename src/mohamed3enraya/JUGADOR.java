package mohamed3enraya;

import java.util.Scanner;

public class JUGADOR {

	public static String J1;
	public static String J2;
	public static int PuntosJ1 = 0;
	public static int PuntosJ2 = 0;
	public static Scanner sc = new Scanner (System.in);

	public static void definirJugador() {
		System.out.println("Introduce el nombre del jugador 1:");
		J1 = sc.nextLine();
		System.out.println("Introduce el nombre del jugador 2:");
		J2 = sc.nextLine();		
	}
	public static boolean verificarExistenciaJugadores(boolean TF) {
		if(J1 == null || J2 ==null) {
			TF = false;
		} else {
			TF = true;
		}
		return TF;		
	}
	public static void mostrarPuntaje() {
		System.out.println("Puntos " + J1 + ": " + PuntosJ1);
		System.out.println("Puntos " + J2 + ": " + PuntosJ2);
	}
	public static void reinciarContadores() {
		PuntosJ1 = 0;
		PuntosJ2 = 0;
	}

}
