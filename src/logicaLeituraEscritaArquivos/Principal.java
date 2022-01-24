package logicaLeituraEscritaArquivos;
import java.io.IOException;

public class Principal {

	public static void main(String[] args) throws IOException {
		LinkedQueue<Integer> fila = new LinkedQueue<>();
		fila.enqueue(1);
		fila.enqueue(2);
		fila.enqueue(3);
		fila.enqueue(4);
		fila.enqueue(5);
		String fileName = "lePilha.txt";
		CriaArquivos.gravaFila(fileName, fila);
		System.out.println(CriaArquivos.lePilha(fileName));
	}

}
