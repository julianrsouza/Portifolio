package logicaLeituraEscritaArquivos;
import java.io.*;

public class CriaArquivos {

	public static LinkedStack<Integer> lePilha(String fileName) throws IOException {
		FileReader fr = new FileReader(fileName);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		LinkedStack<Integer> pilhaRetorno = new LinkedStack<>();
		LinkedStack<Integer> pilhaAux = new LinkedStack<>();
		while (line != null) {
			pilhaAux.push(Integer.parseInt(line.trim()));
			line = br.readLine();
		}
		while (!pilhaAux.isEmpty()) {
			pilhaRetorno.push(pilhaAux.pop());
		}
		br.close();
		fr.close();
		return pilhaRetorno;
	}

	public static void gravaFila(String fileName, LinkedQueue<Integer> fila) throws IOException {
		FileWriter fw = new FileWriter(fileName);
		BufferedWriter bw = new BufferedWriter(fw);
		LinkedStack<Integer> pilhaAux = new LinkedStack<>();
		LinkedQueue<Integer> filaAux = new LinkedQueue<>();
		while (!fila.isEmpty()) {
			Integer varTemp = fila.dequeue();
			pilhaAux.push(varTemp);
			filaAux.enqueue(varTemp);
		}
		while (!pilhaAux.isEmpty()) {
			bw.write(pilhaAux.pop().toString());
			bw.write("\n");
		}
		fila = filaAux;
		bw.close();
		fw.close();
	}

}
