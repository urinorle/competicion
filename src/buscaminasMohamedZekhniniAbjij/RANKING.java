package buscaminasMohamedZekhniniAbjij;

public class RANKING {
	public static final int MAX_JUGADORES = 50;
	public static final int NUM_COLUMNAS = 3;

	public static final String[][] ListaDeJugadores = new String[NUM_COLUMNAS][MAX_JUGADORES];

	public static void mostrarRanking() {
		System.out.println("  NOM:       GUANYADES:       PERDUDES:");
		int maxJugRank = 48;
		for (int j = 0; j < MAX_JUGADORES; j++) {
			if (ListaDeJugadores[0][j].equals("")) {
				maxJugRank = j;
				break;
			}
		}

		for (int i = 0; i <= maxJugRank; i++) {
			for (int j = 1; j < NUM_COLUMNAS; j++) {
				System.out.print(ListaDeJugadores[j][i] + " ");
			}
			System.out.println();
		}
	}

	public static void inicializarRanking() {
		for (int j = 0; j < MAX_JUGADORES; j++) {
			ListaDeJugadores[0][j] = "";
		}

		for (int i = 0; i < NUM_COLUMNAS; i++) {
			for (int j = 1; j < MAX_JUGADORES; j++) {
				ListaDeJugadores[i][j] = "0";
			}
		}
	}

	public static void registrarNombre(String nombre) {
		
		boolean existeEste = false;
		for (int i = 0; i < MAX_JUGADORES; i++) {
			if (ListaDeJugadores[0][i].equals(nombre)) {
				existeEste = true;
				break;
			}
		}
		if (!existeEste) {
			
			for (int j = 0; j < MAX_JUGADORES; j++) {
				if (ListaDeJugadores[0][j] == "") {
					ListaDeJugadores[0][j] = nombre;
					
					break;
				}
			}
		}
	}
}
