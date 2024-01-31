package OSOJeicker;

import java.util.*;

public class Partida {
    static Scanner sc = new Scanner(System.in);    
    public static char[][] inicioTablero(int x, int y) {
        char[][] tablero = new char[x][y];

        char casilla = '·';

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                tablero[i][j] = casilla;
            }
        }
        return tablero;
    }

    public static char[][] inicioMemoria(int x, int y) {
        char[][] memoria = new char[x][y];
        char casilla = '·';

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
            	memoria[i][j] = casilla;
            }
        }
        return memoria;
    }

    public static void jugar(char[][] tablero, char[][] memoria, int x, int y, Jugadores j1, Jugadores j2, int posX, int posY) {
        int casillasLibres = 0;
        int contj1 = 0;
        int contj2 = 0;
        do {
            System.out.println();
            turnoJugador(tablero, memoria, x, y, j1, posX, posY);
            contj1 = validarOSO(tablero, memoria, x, y, j1, contj1, posX, posY);
            System.out.println();
            System.out.println("Contador jugador 1: " + contj1);
            
            casillasLibres += 1;

            System.out.println();
            turnoJugador(tablero, memoria, x, y, j2, posX, posY);
            contj2 = validarOSO(tablero, memoria, x, y, j2, contj2, posX, posY);
            System.out.println();
            System.out.println("Contador jugador 2: " + contj2);

            casillasLibres += 1;
        } while (casillasLibres < x * y); 

        win(contj1, contj2, j1, j2);
    }

    private static void win(int contj1, int contj2, Jugadores j1, Jugadores j2) {
        if (contj1 > contj2) {
            System.out.println("Ha ganado el jugador: " + j1.nomJugador);
            j1.partidesGuanyades += 1;
            j2.partidesPerdudes += 1;
        } else if (contj1 < contj2) {
            System.out.println("Ha ganado el jugador: " + j2.nomJugador);
            j2.partidesGuanyades += 1;
            j1.partidesPerdudes += 1;
        } else {
            System.out.println("Empate");
        }
    }

    private static int validarOSO(char[][] tablero, char[][] memoria, int x, int y, Jugadores j2, int contj, int posX, int posY) {
        if (posX >= 0 && posX < tablero.length && posY >= 0 && posY < tablero[0].length) {
            if (tablero[posX][posY] == 'O') {
                if (posY + 2 < tablero[0].length && tablero[posX][posY + 1] == 'S') {
                    if (tablero[posX][posY + 2] == 'O') {
                        contj++;
                    }
                }
                if (posY - 2 >= 0 && tablero[posX][posY - 1] == 'S') {
                    if (tablero[posX][posY - 2] == 'O') {
                        contj++;
                    }
                }
                if (posX + 2 < tablero.length && tablero[posX + 1][posY] == 'S') {
                    if (tablero[posX + 2][posY] == 'O') {
                        contj++;
                    }
                }
                if (posX - 2 >= 0 && tablero[posX - 1][posY] == 'S') {
                    if (tablero[posX - 2][posY] == 'O') {
                        contj++;
                    }
                }
                if (posX + 2 < tablero.length && posY + 2 < tablero[0].length && tablero[posX + 1][posY + 1] == 'S') {
                    if (tablero[posX + 2][posY + 2] == 'O') {
                        contj++;
                    }
                }
                if (posX - 2 >= 0 && posY - 2 >= 0 && tablero[posX - 1][posY - 1] == 'S') {
                    if (tablero[posX - 2][posY - 2] == 'O') {
                        contj++;
                    }
                }
                if (posX + 2 < tablero.length && posY - 2 >= 0 && tablero[posX + 1][posY - 1] == 'S') {
                    if (tablero[posX + 2][posY - 2] == 'O') {
                        contj++;
                    }
                }
                if (posX - 2 >= 0 && posY + 2 < tablero[0].length && tablero[posX - 1][posY + 1] == 'S') {
                    if (tablero[posX - 2][posY + 2] == 'O') {
                        contj++;
                    }
                }
            } else if (tablero[posX][posY] == 'S') {
                if (posY + 1 < tablero[0].length && posY - 1 >= 0 && tablero[posX][posY + 1] == 'O') {
                    if (tablero[posX][posY - 1] == 'O') {
                        contj++;
                    }
                }
                if (posX + 1 < tablero.length && posX - 1 >= 0 && tablero[posX + 1][posY] == 'O') {
                    if (tablero[posX - 1][posY] == 'O') {
                        contj++;
                    } 
                }
                if (posX + 1 < tablero.length && posY + 1 < tablero[0].length && posX - 1 >= 0 && posY - 1 >= 0 && tablero[posX + 1][posY + 1] == 'O') {
                    if (tablero[posX - 1][posY - 1] == 'O') {
                        contj++;
                    } 
                }
            }
        }
        return contj;
    }

    public static void turnoJugador(char[][] tablero, char[][] memoria, int x, int y, Jugadores j, int posX, int posY) {
        System.out.println("Le toca a: " + j.nomJugador);
        for (int i = 0; i < x; i++) {
            for (int k = 0; k < y; k++) {
                System.out.print(tablero[i][k] + " ");
            }
            System.out.println();
        }
        do{
            System.out.println("Dime la posicion que quieres poner");
            posX = sc.nextInt();
            posY = sc.nextInt();

            if (tablero[posX][posY] == '·') {
                System.out.println("Que quieres poner O/S");
                char letra = sc.next().charAt(0);
                letra = Character.toUpperCase(letra);
                if (letra == 'O' || letra == 'S') {
                    tablero[posX][posY] = letra;
                }
                else{
                    System.out.println("Letra incorrecta"); 
                }
            }
            else{
                System.out.println("Casilla ocupada");
    
            }
        }while(tablero[posX][posY] == '·');

    }

}
