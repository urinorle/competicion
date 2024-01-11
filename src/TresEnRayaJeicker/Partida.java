package TresEnRayaJeicker;

public class Partida {

	public static void inicialitzar(Jugadors j1, char[][] Tablero) {
		if (j1 != null) {
			
			for (int i = 0;i < Menu.Medida;i++) {
				for (int j = 0;j < Menu.Medida;j++) {
					Tablero[i][j] = '-';
				}
			}

		}
		else {
			System.out.println("No hay jugadores definidos.");
		}
	}
	
	public static void jugada(char[][] Tablero, int j, int j1) {
		for (int i = 0;i < Menu.Medida;i++) {
			for (int j11 = 0;j11 < Menu.Medida;j11++) {
				System.out.print(Tablero[i][j11] + " ");
			}
		}System.out.println();
		
		System.out.println();
		System.out.println("Comienza ");
	}
	
}
