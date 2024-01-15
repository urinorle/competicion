package mohamed3enraya;

import java.util.Scanner;

public class MENU {

	static public Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int opcio;
		System.out
				.println("ESCOGE UNA DE LAS SIGUIENTES OPCIONES:\n" + "1.- Mostrar ayuda\n" + "2.- Definir jugadores\n"
						+ "3.- Mostrar jugadores \n" + "4.- Jugar partida\n" + "0.- Cerrar programa");
		opcio = sc.nextInt();

		switch (opcio) {
		case 1:
			try {
				AYUDA.main(args);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			break;
		case 2:
			JUGADOR.definirJugador();
			main(args);
			break;
		case 3:
			if (JUGADOR.verificarExistenciaJugadores(false)) {
				System.out.println("Tienes que definir los jugadores primero");
			} else {
				JUGADOR.mostrarPuntaje();
			}
			break;
		case 4:
			break;
		case 0:
			if (JUGADOR.verificarExistenciaJugadores(true)) {
				JUGADOR.mostrarPuntaje();
			}
			break;
		default:
			System.out.println("OPCIÓN INCORRECTA!!! \n");
			main(args);
			break;
		}

	}

}
