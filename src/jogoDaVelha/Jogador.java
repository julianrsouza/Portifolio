package jogoDaVelha;

public class Jogador {
	private String nome;
	private int pontos;
	private char simbolo;
	private JogoDaVelha tabuleiro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos() {
		this.pontos = 0;
	}

	public Jogador(String n, char s, JogoDaVelha t) {
		this.nome = n;
		this.pontos = 0;
		this.simbolo = s;
		this.tabuleiro = t;

	}

	public void joga(int fileira, int coluna) {
		tabuleiro.realizaJogada(fileira, coluna, this.simbolo);
	}

	public String toString() {
		return "Nome: " + this.nome + "\nPontos: " + this.pontos + "\nMarca: " + this.simbolo;
	}

}
