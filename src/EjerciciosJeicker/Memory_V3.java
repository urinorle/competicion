package EjerciciosJeicker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Memory_V3 {
	public static Scanner sc = new Scanner(System.in);
	public static final int MEDIDA_DEL_TABLERO = 4;
	public static Random rd = new Random();
	
	public static void main(String[] args) {
		char Tauler[][] = new char[MEDIDA_DEL_TABLERO][MEDIDA_DEL_TABLERO];
		char Secret[][] = new char[MEDIDA_DEL_TABLERO][MEDIDA_DEL_TABLERO];
		int Opcio;
		int Opcio2;
		System.out.println("Benvinguts al joc MEMORY!");
		System.out.println();
		do {
			Opcio = Menu();
			switch (Opcio) {
			default:
			case 0:
				break;

			case 1:
				inicialitzarTauler(Tauler);
				posarPeces(Secret);
				remenarPeces(Secret);
				partidaSolitaria(Tauler, Secret);
				break;

			case 2:
				inicialitzarTauler(Tauler);
				posarPeces(Secret);
				remenarPeces(Secret);
				partidaNormalV2(Tauler, Secret);
				break;
			case 3:
				inicialitzarTauler(Tauler);
				posarPeces(Secret);
				remenarPeces(Secret);
				Opcio2 = Menu2();
				if (Opcio2 == 1) {
					modeAleatori(Tauler, Secret);
				}
				else {
					
				}
				break;
			}
		} while (Opcio != 0);

	}

	public static void modeAleatori(char[][] Matriu, char[][] Secret) {
		int turno = 0;
		int puntsJugador1 = 0;
		int BOT = 0;

		while (casellesPendents(Matriu) >= 2) {
			if (hacerJugadaCPUFacil(Matriu, Secret, turno)) {
				System.out.println("PARELLA");
				if (turno == 0)
					puntsJugador1++;
				else
					BOT++;

				System.out.println("Punts Jugador 1: " + puntsJugador1);
				System.out.println("Punts Jugador 2: " + BOT);
			}

			else {
				if (turno == 0) {
					System.out.println("UNA ALTRA VEGADA SERÀ");
					turno = (turno + 1) % 2;
				}
				else {
					System.out.println("La maquina ha fallado");
					turno = (turno + 1) % 2;
				}
			}
		}
		System.out.println("Final de la partida.");
		if (puntsJugador1 > BOT)
			System.out.println("Guanyador Jugador 1");
		else if (BOT > puntsJugador1)
			System.out.println("Guanayador Jugador 2");
		else
			System.out.println("Empat");

		System.out.println("Punts Jugador 1: " + puntsJugador1);
		System.out.println("Punts Jugador 2: " + BOT);

		return;
	}
	
	public static boolean hacerJugadaCPUFacil(char[][] tablero, char[][] Secret, int turno) {
		if (turno == 0) {
			int filaCasella1, columnaCasella1;
			int filaCasella2, columnaCasella2;
			char valor1, valor2;

			mostrarTauler(tablero);
			do {
				System.out.println("Si us plau, indica una casella que estigui tapada");
				filaCasella1 = demanarFila();
				columnaCasella1 = demanarColumna();
			} while (!validaCasella(tablero, filaCasella1, columnaCasella1));

			valor1 = demandarCasella(Secret, filaCasella1, columnaCasella1);
			destapaCasella(tablero, filaCasella1, columnaCasella1, valor1);

			mostrarTauler(tablero);
			System.out.println();
			do {
				System.out.println("Si us plau, indica una casella que estigui tapada");
				filaCasella2 = demanarFila();
				columnaCasella2 = demanarColumna();
			} while (!validaCasella(tablero, filaCasella2, columnaCasella2));

			valor2 = demandarCasella(Secret, filaCasella2, columnaCasella2);
			destapaCasella(tablero, filaCasella2, columnaCasella2, valor2);

			mostrarTauler(tablero);
			System.out.println();
			if (valor1 == valor2)
				return true;
			else {
				tapaCasella(tablero, filaCasella1, columnaCasella1);
				tapaCasella(tablero, filaCasella2, columnaCasella2);
				return false;
			}
		}
		else {
			int filaCasella1, columnaCasella1;
			int filaCasella2, columnaCasella2;
			char valor1, valor2;

			System.out.println("TURNO DE LA MAQUINA");
			do {
				filaCasella1 = rd.nextInt(MEDIDA_DEL_TABLERO);
				columnaCasella1 = rd.nextInt(MEDIDA_DEL_TABLERO);
			} while (!validaCasella(tablero, filaCasella1, columnaCasella1));

			valor1 = demandarCasella(Secret, filaCasella1, columnaCasella1);
			destapaCasella(tablero, filaCasella1, columnaCasella1, valor1);

			
			do {
				filaCasella2 = rd.nextInt(MEDIDA_DEL_TABLERO);
				columnaCasella2 = rd.nextInt(MEDIDA_DEL_TABLERO);
			} while (!validaCasella(tablero, filaCasella2, columnaCasella2));

			valor2 = demandarCasella(Secret, filaCasella2, columnaCasella2);
			destapaCasella(tablero, filaCasella2, columnaCasella2, valor2);
			System.out.println();
			mostrarTauler(tablero);
			System.out.println();
			if (valor1 == valor2)
				return true;
			else {
				tapaCasella(tablero, filaCasella1, columnaCasella1);
				tapaCasella(tablero, filaCasella2, columnaCasella2);
				return false;
			}
		}
		
	}
	
	public static void partidaNormalV2(char[][] Matriu, char[][] Secret) {
		int turno = 0;
		int puntsJugador1 = 0;
		int puntsJugador2 = 0;

		while (casellesPendents(Matriu) >= 2) {
			if (hacerJugada(Matriu, Secret)) {
				System.out.println("PARELLA");
				if (turno == 0)
					puntsJugador1++;
				else
					puntsJugador2++;

				System.out.println("Punts Jugador 1: " + puntsJugador1);
				System.out.println("Punts Jugador 2: " + puntsJugador2);
			}

			else {
				System.out.println("UNA ALTRA VEGADA SERÀ");
				turno = (turno + 1) % 2;
			}
		}
		System.out.println("Final de la partida.");
		if (puntsJugador1 > puntsJugador2)
			System.out.println("Guanyador Jugador 1");
		else if (puntsJugador2 > puntsJugador1)
			System.out.println("Guanayador Jugador 2");
		else
			System.out.println("Empat");

		System.out.println("Punts Jugador 1: " + puntsJugador1);
		System.out.println("Punts Jugador 2: " + puntsJugador2);

		return;
	}

	public static void partidaSolitaria(char[][] Matriu, char[][] Secret) {
		while (casellesPendents(Matriu) >= 2)
			if (hacerJugada(Matriu, Secret))
				System.out.println("PARELLA");
			else
				System.out.println("UNA ALTRA VEGADA SERÀ");

		return;
	}

	public static boolean hacerJugada(char[][] tablero, char[][] Secret) {
		int filaCasella1, columnaCasella1;
		int filaCasella2, columnaCasella2;
		char valor1, valor2;

		mostrarTauler(tablero);
		do {
			System.out.println("Si us plau, indica una casella que estigui tapada");
			filaCasella1 = demanarFila();
			columnaCasella1 = demanarColumna();
		} while (!validaCasella(tablero, filaCasella1, columnaCasella1));

		valor1 = demandarCasella(Secret, filaCasella1, columnaCasella1);
		destapaCasella(tablero, filaCasella1, columnaCasella1, valor1);

		mostrarTauler(tablero);

		do {
			System.out.println("Si us plau, indica una casella que estigui tapada");
			filaCasella2 = demanarFila();
			columnaCasella2 = demanarColumna();
		} while (!validaCasella(tablero, filaCasella2, columnaCasella2));

		valor2 = demandarCasella(Secret, filaCasella2, columnaCasella2);
		destapaCasella(tablero, filaCasella2, columnaCasella2, valor2);

		mostrarTauler(tablero);

		if (valor1 == valor2)
			return true;
		else {
			tapaCasella(tablero, filaCasella1, columnaCasella1);
			tapaCasella(tablero, filaCasella2, columnaCasella2);
			return false;
		}
	}

	public static int casellesPendents(char[][] Matriu) {

		int caselles = 0;

		for (int i = 0; i < MEDIDA_DEL_TABLERO; i++)
			for (int j = 0; j < MEDIDA_DEL_TABLERO; j++)
				if (Matriu[i][j] == '?')
					caselles++;
		return caselles;
	}

	public static void triaCasella(char[][] tablero, char[][] secreto) {
		int fila;
		int columna;
		do {
			fila = demanarFila();
			columna = demanarColumna();
			if (!validaCasella(tablero, fila, columna))
				System.out.println("Casella ja destapada. Tria una altra");
		} while (!validaCasella(tablero, fila, columna));

		char valor = demandarCasella(secreto, fila, columna);
		destapaCasella(tablero, fila, columna, valor);

	}

	public static int demanarFila() {
		int fila;
		do {
			System.out.println("Diguem la fila que vols");
			fila = sc.nextInt();
			if (fila < 0 || fila >= MEDIDA_DEL_TABLERO)
				System.out.println("Si us plau, entre 0 i " + (MEDIDA_DEL_TABLERO - 1));
		} while (fila < 0 || fila >= MEDIDA_DEL_TABLERO);
		return fila;

	}

	public static boolean validaCasella(char[][] matriu, int fila, int columna) {
		return (matriu[fila][columna] == '?');
	}

	public static void tapaCasella(char[][] matriu, int fila, int columna) {
		matriu[fila][columna] = '?';
	}

	public static void inicialitzarSecret(char[][] cerdo) {
		remenarPeces(cerdo);
		mostrarTauler(cerdo);
	}

	public static void remenarPeces(char[][] mesclando) {
		Random rd = new Random();

		for (int i = 0; i < 100; i++) {
			int filaV1;
			int colV1;
			int filaV2;
			int colV2;
			boolean repetir = false;
			do {
				filaV1 = rd.nextInt(MEDIDA_DEL_TABLERO);
				colV1 = rd.nextInt(MEDIDA_DEL_TABLERO);
				filaV2 = rd.nextInt(MEDIDA_DEL_TABLERO);
				colV2 = rd.nextInt(MEDIDA_DEL_TABLERO);
				if (filaV1 == filaV2 && colV1 == colV2) {
					repetir = true;
				} else {
					repetir = false;
				}
			} while (repetir);
			char V1 = mesclando[filaV1][colV1];
			char V2 = mesclando[filaV2][colV2];
			mesclando[filaV2][colV2] = V1;
			mesclando[filaV1][colV1] = V2;

		}

	}

	public static void posarPeces(char[][] secretoPapi) {
		char letra = 'A';
		int num = 0;
		for (int i = 0; i < MEDIDA_DEL_TABLERO; i++) {
			for (int j = 0; j < MEDIDA_DEL_TABLERO; j++) {
				if (num != 0 && (num % 2) == 0) {
					letra++;
				}
				secretoPapi[i][j] = letra;
				num++;

			}
		}
	}

	public static void mostrarTauler(char[][] Caca) {
		for (int i = 0; i < MEDIDA_DEL_TABLERO; i++) {
			for (int j = 0; j < MEDIDA_DEL_TABLERO; j++) {
				if (j != 0) {
					System.out.print(Caca[i][j] + " ");
				} else {
					System.out.print(i + " " + Caca[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println("  0 1 2 3");

	}

	public static void inicialitzarTauler(char[][] Bebote) {
		for (int j = 0; j < MEDIDA_DEL_TABLERO; j++) {
			for (int k = 0; k < MEDIDA_DEL_TABLERO; k++) {
				Bebote[j][k] = '?';
			}
		}

	}

	public static int Menu() {
		int Opcio;
		System.out.println("Selecciona el modo de juego");
		System.out.println("0. Sortir");
		System.out.println("1. Jugar Partida Solitaria");
		System.out.println("2. Jugar Partida 1 VS 1 ");
		System.out.println("3. Jugar Partida 1 VS Bot");
		

		do {
			System.out.print("Digues una Opció: ");
			Opcio = sc.nextInt();
			if (Opcio > 3 || Opcio < 0)
				System.out.println("Opcio no vàlida");

		} while (Opcio > 3 || Opcio < 0);
		System.out.println();
		return Opcio;
	}
	
	public static int Menu2() {
		int Opcio;
		System.out.println("Selecciona la dificultad");
		System.out.println("0. Sortir");
		System.out.println("1. Fácil");
		System.out.println("2. Dificil ");
		

		do {
			System.out.print("Digues una Opció: ");
			Opcio = sc.nextInt();
			if (Opcio > 2 || Opcio < 0)
				System.out.println("Opcio no vàlida");
			
		} while (Opcio > 2 || Opcio < 0);
		System.out.println();
		return Opcio;
	}

	public static int demanarColumna() {
		int Columna;
		do {
			System.out.println("Diguem la columna que vols");
			Columna = sc.nextInt();
			if (Columna < 0 || Columna >= MEDIDA_DEL_TABLERO)
				System.out.println("Si us plau, entre 0 i " + (MEDIDA_DEL_TABLERO - 1));
		} while (Columna < 0 || Columna >= MEDIDA_DEL_TABLERO);
		return Columna;

	}

	public static char demandarCasella(char[][] matriz, int fila, int columna) {
		return (matriz[fila][columna]);
	}

	public static void destapaCasella(char[][] matriu, int fila, int columna, char valor) {
		matriu[fila][columna] = valor;
	}

}
