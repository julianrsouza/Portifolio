package estruturasDados.lista;

import estruturasDados.OverflowException;
import estruturasDados.UnderflowException;

public class StaticList<E> implements List<E> {
	private E[] elements;
	private int numElements;

	@SuppressWarnings("unchecked")
	public StaticList(int maxSize) {
		elements = (E[]) new Object[maxSize];
		numElements = 0;
	}

	public int numElements() {
		return numElements;
	}

	public boolean isEmpty() {
		return numElements == 0;
	}

	public boolean isFull() {
		return numElements == elements.length;
	}

	public void insert(E element, int pos) throws OverflowException, IndexOutOfBoundsException {
		if (isFull())
			throw new OverflowException();

		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();

		for (int i = numElements - 1; i >= pos; i--)
			elements[i + 1] = elements[i];

		elements[pos] = element;
		numElements++;
	}

	public E remove(int pos) throws UnderflowException, IndexOutOfBoundsException {
		if (isEmpty())
			throw new UnderflowException();

		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		E element = elements[pos];

		for (int i = pos; i < numElements - 1; i++)
			elements[i] = elements[i + 1];

		elements[numElements - 1] = null;
		numElements--;

		return element;
	}

	public E get(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		return elements[pos];
	}

	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;

		return -1;
	}

	public int contaElementos(E el) throws IllegalArgumentException {
		int i = 0;
		int contagem = 0;
		if (this.numElements() == 0)
			return 0;
		if (this.get(0).getClass() != el.getClass())
			throw new IllegalArgumentException();
		if (this.get(i) == el)
			contagem++;
		return contaElementos(el, ++i, contagem);
	}

	private int contaElementos(E el, int i, int contagem) {
		if (this.numElements() == i) {
			System.out.println("O elemento " + el + " aparece " + contagem + " vezes na lista.");
			return contagem;
		}
		if (this.get(i) == el)
			contagem++;
		return contaElementos(el, ++i, contagem);
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < numElements; i++)
			s += elements[i] + " ";
		return s;
	}
}