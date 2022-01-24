package jogoDaVelha;

public class Main {

	public static void main(String[] args) {

		JogoDaVelha j = new JogoDaVelha();

		String nomeJogadorp = Teclado.leString("Coloque o nome do primeiro jogador: ");
		Jogador p = new Jogador(nomeJogadorp, 'X', j);

		System.out.println(p);

		String nomeJogadorq = Teclado.leString("Coloque o nome do segundo jogador: ");
		Jogador q = new Jogador(nomeJogadorq, 'O', j);
		System.out.println(q);

		j.printaTabuleiro();
		while (j.tabuleiroCheio() == false && j.verificaGanhador() == false) {
			System.out.println(p.getNome() + " é sua vez:");
			int linha = Teclado.leInt("Escolha uma linha ");
			int coluna = Teclado.leInt("Escolha uma coluna ");
			p.joga(linha, coluna);
			j.printaTabuleiro();
			if (j.verificaGanhador() == true) {
				System.out.println("Nós temos um vencedor!");
				break;
			} else if (j.tabuleiroCheio() == true) {
				System.out.println("Nós temos um empate!");
				break;
			} else {
				System.out.println(q.getNome() + " é sua vez:");
				int linha2 = Teclado.leInt("Escolha uma linha: ");
				int coluna2 = Teclado.leInt("Escolha uma coluna: ");
				q.joga(linha2, coluna2);
				j.printaTabuleiro();
				if (j.verificaGanhador() == true) {
					System.out.println("Nós temos um vencedor!");
					break;
				} else if (j.tabuleiroCheio() == true) {
					System.out.println("Nós temos um empate!");
					break;
				}

			}

		}
	}
}
