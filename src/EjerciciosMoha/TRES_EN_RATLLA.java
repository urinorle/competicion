package EjerciciosMoha;

import java.util.Scanner;

public class TRES_EN_RATLLA {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InterruptedException {
		int opcio;
		System.out
				.println("ESCOGE UNA DE LAS SIGUIENTES OPCIONES:\n" + "1.- Mostrar ayuda\n" + "2.- Definir jugadores\n"
						+ "3.- Mostrar jugadores \n" + "4.- Jugar partida\n" + "5.- Cerrar programa");
		opcio = sc.nextInt();

		switch (opcio) {
		case 1:
			System.out.println("aquí te explico la ayuda durante 10 segundos");
			for (int i = 10; i >= 1; i--) {
				System.out.print(i + " ");
				Thread.sleep(1000);
			}
			System.out.println();
			main(args);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		default:
			System.out.println("OPCIÓN INCORRECTA!!! \n");
			main(args);
			break;
		}
	}

}
