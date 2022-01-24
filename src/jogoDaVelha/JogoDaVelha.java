package jogoDaVelha;

public class JogoDaVelha {
	private char[][] tabuleiro;
	// private int dimensaoTabuleiro;

	public JogoDaVelha() {
		inicializaTabuleiro();
	}

	public void inicializaTabuleiro() {
		tabuleiro = new char[3][3];
		for (int i = 0; i < tabuleiro.length; i++) {
			for (int j = 0; j < tabuleiro.length; j++) {
				tabuleiro[i][j] = ' ';
			}
		}
	}

	public void printaTabuleiro() {
		System.out.println("-------------");
		for (int i = 0; i < tabuleiro.length; i++) {
			System.out.print("| ");
			for (int j = 0; j < tabuleiro.length; j++) {
				System.out.print(tabuleiro[i][j] + " | ");
			}
			System.out.println();
			System.out.println("-------------");
		}
	}

	public boolean tabuleiroCheio() {
		boolean cheio = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (tabuleiro[i][j] == ' ') {
					cheio = false;
				}
			}
		}
		return cheio;
	}

	private boolean verificaLinhaColuna(char c1, char c2, char c3) {
		return ((c1 != ' ') && (c1 == c2) && (c2 == c3));
	}

	public boolean verificaGanhador() {
		return (verificaLinha() || verificaColuna() || verificaDiagonais());

	}

	private boolean verificaLinha() {
		for (int i = 0; i < 3; i++) {
			if (verificaLinhaColuna(tabuleiro[i][0], tabuleiro[i][1], tabuleiro[i][2]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean verificaColuna() {
		for (int i = 0; i < 3; i++) {
			if (verificaLinhaColuna(tabuleiro[0][i], tabuleiro[1][i], tabuleiro[2][i]) == true) {
				return true;
			}
		}
		return false;
	}

	private boolean verificaDiagonais() {
		return ((verificaLinhaColuna(tabuleiro[0][0], tabuleiro[1][1], tabuleiro[2][2]) == true
				|| (verificaLinhaColuna(tabuleiro[0][2], tabuleiro[1][1], tabuleiro[2][0]) == true)));
	}

	public void realizaJogada(int fileira, int coluna, char simbolo) {
		tabuleiro[fileira][coluna] = simbolo;

	}

}
