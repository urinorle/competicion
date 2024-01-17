package EjerciciosMoha;

import java.util.Scanner;

public class Asteroides {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCasos = sc.nextInt();
        for (int i = 0; i < numCasos; i++) {
            int FILAS = sc.nextInt();
            int COLUMNAS = sc.nextInt();
            char[][] matriz = new char[FILAS][COLUMNAS];

            for (int j = 0; j < FILAS; j++) {
                String fila = sc.next();
                matriz[j] = fila.toCharArray();
            }

            if (hayCamino(matriz)) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean hayCamino(char[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == 'S') {
                    return busquedaIntensa(matriz, i, j);
                }
            }
        }
        return false;
    }

    public static boolean busquedaIntensa(char[][] matriz, int fila, int columna) {
        if (fila < 0 || fila >= matriz.length || columna < 0 || columna >= matriz[0].length || matriz[fila][columna] == '*') {
            return false;
        }

        if (matriz[fila][columna] == 'F') {
            return true;
        }

        matriz[fila][columna] = '*';

        return busquedaIntensa(matriz, fila - 1, columna)
                || busquedaIntensa(matriz, fila + 1, columna)
                || busquedaIntensa(matriz, fila, columna - 1)
                || busquedaIntensa(matriz, fila, columna + 1);
    }
}


