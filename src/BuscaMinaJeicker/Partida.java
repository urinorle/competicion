package BuscaMinaJeicker;

import java.util.*;

public class Partida {
    static Scanner sc = new Scanner(System.in);

    public static char[][] inicioTablero(int x, int y, int minas) {
        char[][] tablero = new char[x][y];

        char casilla = '·';

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablero[i][j] = casilla;
            }
        }
        return tablero;

    }

    public static char[][] inicioSecret(int x, int y, int minas) {
        char[][] secret = new char[x][y];
        char mina = '*';
        char casilla = '·';

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                secret[i][j] = casilla;
            }
        }

        colocarMinas(secret, minas, mina, x, y);

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (secret[i][j] != mina) {
                    int count = contarMinasAlrededor(secret, mina, x, y, i, j);
                    if (count > 0) {
                        secret[i][j] = (char) (count + '0');
                    } else {
                        secret[i][j] = casilla;
                    }
                }
            }
        }

        return secret;
    }

    private static void colocarMinas(char[][] secret, int minas, char mina, int x, int y) {
        Random random = new Random();
        if (minas > 0) {
            int randomX = random.nextInt(x);
            int randomY = random.nextInt(y);

            if (secret[randomX][randomY] != mina) {
                secret[randomX][randomY] = mina;
                colocarMinas(secret, minas - 1, mina, x, y);
            } else {
                colocarMinas(secret, minas, mina, x, y);
            }
        }
    }

    private static int contarMinasAlrededor(char[][] secret, char mina, int x, int y, int i, int j) {
        int count = 0;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                int nx = i + dx;
                int ny = j + dy;
                if (nx >= 0 && nx < x && ny >= 0 && ny < y && secret[nx][ny] == mina) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void jugar(char[][] tablero, char[][] secret, int x, int y, int fila, int columna) {
        do {
            for (int i = 0; i < x; i++) {
                System.out.print(i + "  ");
                for (int j = 0; j < y; j++) {
                    System.out.print(tablero[i][j] + "  ");
                }
                System.out.println();
            }

            System.out.print("   ");
            for (int j = 0; j < y; j++) {
                System.out.print(j + "  ");
            }
            System.out.println();
            System.out.println("Dime la fila y la columna: ");

            fila = sc.nextInt();
            columna = sc.nextInt();

            if (fila >= 0 && fila < x && columna >= 0 && columna < y) {
                if (secret[fila][columna] == '*') {
                    System.out.println("Mala suerte, has perdido");
                    mostrarMinas(tablero, secret, x, y);
                    break;
                } else {
                    tablero[fila][columna] = secret[fila][columna];
                }
            }
        } while (secret[fila][columna] != '*');
    }

    private static void mostrarMinas(char[][] tablero, char[][] secret, int x, int y) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (secret[i][j] == '*') {
                    tablero[i][j] = secret[i][j];
                }
            }
        }

        for (int i = 0; i < x; i++) {
            System.out.print(i + "  ");
            for (int j = 0; j < y; j++) {
                System.out.print(tablero[i][j] + "  ");
            }
            System.out.println();
        }

        System.out.print("   ");
        for (int j = 0; j < y; j++) {
            System.out.print(j + "  ");
        }
    }

}

