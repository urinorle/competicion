package examenMohamedZekhnini;

import java.util.Random;
import java.util.Scanner;

public class LEGOCREUS {

	public static Scanner sc = new Scanner(System.in);
	public static Random rd = new Random();

	public static void main(String[] args) {
		int opcio;
		int dim = 0;
		int[][] tauler = null;
		int[][] taulerCentres = null;
		boolean TaulerInicialitzat = false;

		do {
			menu();
			opcio = sc.nextInt();

			switch (opcio) {
			case 1:
				System.out.println("Escull una dimensió entre 4 i 10:");
				do {
					dim = sc.nextInt();
				} while (dim < 4 || dim > 10);
				tauler = new int[dim][dim];
				taulerCentres = new int[dim][dim];
				inicialitzarTauler(taulerCentres, tauler, dim);
				TaulerInicialitzat = true;
				break;
			case 2:
				if (TaulerInicialitzat == true) {
					veureTauler(tauler, dim);
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}
				break;
			case 3:
				if (TaulerInicialitzat == true) {
					System.out.println("Digues la fila:");
					int x = sc.nextInt();
					System.out.println("Digues la columna:");
					int y = sc.nextInt();
					posarCreu(tauler, dim, x, y);
					posarCentre(taulerCentres, dim, x, y);
				} else {
					System.out.println("Has de inicialitzar el tauler abans :(");
				}
				break;
			case 4:
				if (TaulerInicialitzat == true) {
					inicialitzarTauler(taulerCentres, tauler, dim);
					int limit = (dim * dim) / 5;
					System.out.println("Posa el nº de creus que vols entre 1 i " + limit);
					int nCreus;
					do {
						nCreus = sc.nextInt();
					} while (nCreus < 1 || nCreus > limit);

					int contador = 0;
					while (contador != nCreus) {

						int Cx = rd.nextInt(1, (dim - 1));
						int Cy = rd.nextInt(1, (dim - 1));
						if (tauler[Cx][Cy] != 1) {
							posarCreu(tauler, dim, Cx, Cy);
							posarCentre(taulerCentres, dim, Cx, Cy);
							contador++;
						}
					}
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}

				break;
			case 5:
				if (TaulerInicialitzat == true) {
					boolean flag = false;
					System.out.println("Digues la fila de la casella que vols investigar");
					int Cx = sc.nextInt();
					System.out.println("Digues la fila de la casella que vols investigar");
					int Cy = sc.nextInt();
					if (taulerCentres[Cx][Cy] == 1) {
						flag = true;
					}
					System.out.println(flag);
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}
				break;
			case 6:
				if (TaulerInicialitzat == true) {
					int contador = 0;
					contador = comptarCreus(taulerCentres, contador);
					System.out.println("Hi ha un total de: " + contador + " creus");
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}
				break;
			case 7:
				if (TaulerInicialitzat == true) {
					boolean copiaFeta = false;
					crearCopiaTauler(tauler, copiaFeta);
					System.out.println("El tauler original:");
					System.out.println();
					veureTauler(tauler, dim);
					System.out.println("El tauler copiat:");
					System.out.println();
					veureTauler(tauler, dim);
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}
				break;
			case 8:
				if (TaulerInicialitzat == true) {
					int contador = 0;
					contador = comptarSuperCreus(taulerCentres, contador);
					System.out.println(contador);
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}
				break;
			case 9:
				if (TaulerInicialitzat == true) {
					int contador = 0;
					System.out.println("Digues la fila de la illa que vols analitzar: ");
					int x = sc.nextInt();
					System.out.println("Digues la columna de la illa que vols analitzar: ");
					int y = sc.nextInt();
					contador = Superficie(tauler, contador, x, y);
					System.out.println(contador);
				} else {
					System.out.println("Has de definir el tauler abans :(");
				}
				break;
			case 0:
				System.out.println("Adeu :)");
				break;
			default:
				System.out.println("Escull una opció correcta si us plau");
				break;
			}
		} while (opcio != 0);

	}

	public static int Superficie(int[][] tauler, int contador, int x, int y) {
		/*
		tauler[x][y] = 2;

		ocupar(tauler);
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				if (tauler[i][j] == 2) {
					contador++;
				}
			}

		}
		for (int i = 0; i < tauler.length; i++) {
			for (int j = 0; j < tauler[0].length; j++) {
				if (tauler[i][j] == 2) {
					tauler[i][j] == 1;
				}
			}

		}
		Ejercicio 75% hecho...
		*/
		return contador;
		
	}

	public static int comptarSuperCreus(int[][] taulerCentres, int contador) {
		int f = taulerCentres.length;
		int c = taulerCentres[0].length;
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {

				if (taulerCentres[i][j] == 1) {
					boolean flag = true;

					for (int k = 0; i < f; i++) {
						for (int l = 0; j < c; j++) {
							if (taulerCentres[k][l] == 1 && l == j && k == (i - 2)) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && l == j && k == (i + 2)) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && (l == (j + 2)) && k == i) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && (l == (j - 2)) && k == i) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && l == (j + 1) && k == (i + 1)) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && l == (j - 1) && k == (i - 1)) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && l == (j + 1) && k == (i - 1)) {
								flag = false;
							}
							if (taulerCentres[k][l] == 1 && l == (j - 1) && k == (i + 1)) {
								flag = false;
							}
						}
					}
					if (flag) {
						contador++; /* En teoria funciona... */
					}
				}
			}

		}
		return contador;
	}

	public static void crearCopiaTauler(int[][] tauler, boolean copiaFeta) {
		int[][] taulerCopia = new int[tauler.length][tauler[0].length];
		int f = tauler.length;
		int c = tauler[0].length;
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				taulerCopia[i][j] = tauler[i][j];
			}
		}
		copiaFeta = true;
	}

	public static int comptarCreus(int[][] taulerCentres, int contador) {
		int f = taulerCentres.length;
		int c = taulerCentres[0].length;
		for (int i = 0; i < f; i++) {
			for (int j = 0; j < c; j++) {
				if (taulerCentres[i][j] == 1) {
					contador++;
				}
			}

		}
		return contador;
	}

	public static void posarCentre(int[][] taulerCentres, int dim, int x, int y) {
		if (taulerCentres[x][y] == 0 && x > 0 && y > 0 && x < (dim - 1) && y < (dim - 1)) {
			taulerCentres[x][y] = 1;
		}

	}

	public static void posarCreu(int[][] tauler, int dim, int x, int y) {
		if (tauler[x][y] == 0 && x > 0 && y > 0 && x < (dim - 1) && y < (dim - 1)) {
			tauler[x][y] = 1;
			tauler[x + 1][y] = 1;
			tauler[x - 1][y] = 1;
			tauler[x][y - 1] = 1;
			tauler[x][y + 1] = 1;
		}

	}

	private static void veureTauler(int[][] tauler, int dim) {
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				System.out.print(tauler[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void inicialitzarTauler(int[][] taulerCentres, int[][] tauler, int dim) {
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				tauler[i][j] = 0;
			}
		}
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				taulerCentres[i][j] = 0;
			}
		}
	}

	public static void menu() {
		System.out.println("MENÚ D'OPCIÓNS:");
		System.out.println("1.- Definir Tauler\r\n" + "2.- Veure Tauler\r\n" + "3.- Posar Creu\r\n"
				+ "4.- Posar n-Creus\r\n" + "5.- Creu?\r\n" + "6.- Comptar Creus\r\n" + "7.- Copiar i Veure\r\n"
				+ "8.- SuperCreus\r\n" + "9.- Superfície  (recursiva)\r\n" + "0.- Sortir\r\n" + "");

	}

}
