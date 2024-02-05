package EjerciciosMoha;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class triangulosLaEstructuraDeDatos {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Ttra = sc.nextInt(); // tamaño triangulo
		int Ttrb = sc.nextInt(); // sub-triangulo
		int Alto = Ttra;
		int ancho = (Alto * 2) - 1; // ancho de la matriz

		Integer[][] cajaConTriangulo = new Integer[Alto][ancho]; // creamos matriz de Tamaño Tring x ancho

		for (int i = 0; i < Alto; i++) {
			for (int j = 0; j < ancho; j++) {
				cajaConTriangulo[i][j] = null; // La rellenamos de MenorNúmero
			}
		}
		for (int i = 0; i < Alto; i++) {
			for (int j = 0; j < ancho; j++) {

				if (i == 0) {/* 1º FILA */
					if (j == (ancho / 2)) { /* EL VALOR DEL MEDIO */
						int dato = sc.nextInt();
						cajaConTriangulo[i][j] = dato;
					}
				} else if (i > 0 && i < (Alto - 1)) { /* FILAS INTERMEDIAS */
					if (j >= 1 && j < (ancho - 1)) {
						if ((cajaConTriangulo[i - 1][j + 1]) != null || (cajaConTriangulo[i - 1][j - 1] != null)) {
							int dato = sc.nextInt();
							cajaConTriangulo[i][j] = dato;
						}
					}
				} else if (i == (Alto - 1)) { /* FILA FINAL */
					if ((j % 2) == 0) {
						int dato = sc.nextInt();
						cajaConTriangulo[i][j] = dato;
					}
				}
			}
		}

		int dif = Ttra - Ttrb;
		int acum = 0;

		for (int fila = 0; fila <= dif; fila++) {
			for (int columna = 0; columna < ancho; columna++) {
				ArrayList<Integer> lista = new ArrayList<>();
				if (cajaConTriangulo[fila][columna] != null) {
					int valorMax = Integer.MIN_VALUE;
					int numSucesiones = 0;
					meterDatosEnArray(lista, numSucesiones, cajaConTriangulo, fila, columna, Ttrb);
					Collections.sort(lista, Collections.reverseOrder());
				}
				if (lista.size() > 0) {
					acum += lista.get(0);
				}

			}

		}
		System.out.println(acum);

	}

	private static void meterDatosEnArray(ArrayList<Integer> lista, int numSucesiones, Integer[][] cajaConTriangulo,
			int fila, int columna, int ttrb) {
		while (numSucesiones != ttrb) {
			numSucesiones++;
			lista.add(cajaConTriangulo[fila][columna]);
			meterDatosEnArray(lista, numSucesiones, cajaConTriangulo, fila + 1, columna + 1, ttrb);
			meterDatosEnArray(lista, numSucesiones, cajaConTriangulo, fila + 1, columna - 1, ttrb);
		}

	}

}
