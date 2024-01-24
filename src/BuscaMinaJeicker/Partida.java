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
        while (minas > 0) {
            int randomX = random.nextInt(x);
            int randomY = random.nextInt(y);

            if (secret[randomX][randomY] != mina) {
                secret[randomX][randomY] = mina;
                minas--;
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
                System.out.printf("%2d ", i);
                for (int j = 0; j < y; j++) {
                    System.out.printf("%2c ", tablero[i][j]);
                }
                System.out.println();
            }
            
            System.out.print("   ");
            for (int j = 0; j < y; j++) {
                System.out.printf("%2d ", j);
            }
            System.out.println();
    
            fila = 0;
            columna = 0;
            do {
                System.out.println("Introduce la fila y la columna: ");
                fila = sc.nextInt();
                columna = sc.nextInt();
                if (fila < 0 || fila >= x || columna < 0 || columna >= y) {
                    System.out.println("Error, vuelve a introducir la fila y la columna: ");
                }
            } while (fila < 0 || fila >= x || columna < 0 || columna >= y);
            
            boolean esMina = comprobarMinas(tablero, secret, x, y, fila, columna);
            if (fila >= 0 && fila < x && columna >= 0 && columna < y) {
                tablero[fila][columna] = secret[fila][columna]; // Mover esta línea aquí
                if (esMina) {
                    break;
                } else if (secret[fila][columna] == '·') {
                    vacio(tablero, secret, x, y, fila, columna);
                    boolean esWin = win(tablero, secret, x, y, fila, columna);
                    if (esWin) {
                        break;
                    }
                }
            }
        } while (secret[fila][columna] != '*');
    }
    
    private static boolean comprobarMinas(char[][] tablero, char[][] secret, int x, int y, int fila, int columna) {
        boolean mina = false;
        if (secret[fila][columna] == '*') {
            System.out.println("Mala suerte, has perdido");
            mostrarMinas(tablero, secret, x, y);
            mina = true;
        }
        return mina;
    }
    
    private static boolean win(char[][] tablero, char[][] secret, int x, int y, int fila, int columna) {
        int contadorCasillas = 0;
        int contadorMinas = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (tablero[i][j] != '*') {
                    contadorCasillas++;
                } else {
                    contadorMinas++;
                }
            }
        }
        if (contadorCasillas == (x * y) - contadorMinas) {
            System.out.println("¡Felicidades, has ganado!");
            mostrarMinas(tablero, secret, x, y);
            return true;
        } else {
            return false;
        }
    }   

    private static void vacio(char[][] tablero, char[][] secret, int x, int y, int fila, int columna) {
        if (secret[fila][columna] == '·') {
            tablero[fila][columna] = secret[fila][columna];
            if (fila > 0 && fila < x - 1 && columna > 0 && columna < y - 1) {
                if (secret[fila - 1][columna - 1] != '*') {
                    tablero[fila - 1][columna - 1] = secret[fila - 1][columna - 1];
                    if (secret[fila - 1][columna - 1] == '·') {
                        vacio(tablero, secret, x, y, fila - 1, columna - 1);
                    }
                }
                if (secret[fila - 1][columna] != '*') {
                    tablero[fila - 1][columna] = secret[fila - 1][columna];
                    if (secret[fila - 1][columna] == '·') {
                        vacio(tablero, secret, x, y, fila - 1, columna);
                    }
                }
                if (secret[fila - 1][columna + 1] != '*') {
                    tablero[fila - 1][columna + 1] = secret[fila - 1][columna + 1];
                    if (secret[fila - 1][columna + 1] == '·') {
                        vacio(tablero, secret, x, y, fila - 1, columna + 1);
                    }
                }
                if (secret[fila][columna - 1] != '*') {
                    tablero[fila][columna - 1] = secret[fila][columna - 1];
                    if (secret[fila][columna - 1] == '·') {
                        vacio(tablero, secret, x, y, fila, columna - 1);
                    }
                }
                if (secret[fila][columna + 1] != '*') {
                    tablero[fila][columna + 1] = secret[fila][columna + 1];
                    if (secret[fila][columna + 1] == '·') {
                        vacio(tablero, secret, x, y, fila, columna + 1);
                    }
                }
                if (secret[fila + 1][columna - 1] != '*') {
                    tablero[fila + 1][columna - 1] = secret[fila + 1][columna - 1];
                    if (secret[fila + 1][columna - 1] == '·') {
                        vacio(tablero, secret, x, y, fila + 1, columna - 1);
                    }
                }
                if (secret[fila + 1][columna] != '*') {
                    tablero[fila + 1][columna] = secret[fila + 1][columna];
                    if (secret[fila + 1][columna] == '·') {
                        vacio(tablero, secret, x, y, fila + 1, columna);
                    }
                }
            }
        }
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
            System.out.printf("%2d ", i);
            for (int j = 0; j < y; j++) {
                System.out.printf("%2c ", tablero[i][j]);
            }
            System.out.println();
        }
        
        System.out.print("   ");
        for (int j = 0; j < y; j++) {
            System.out.printf("%2d ", j);
        }
        System.out.println();
    }
}

