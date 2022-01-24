package logicaLeituraEscritaArquivos;

public class LinkedStack<E> implements Stack<E> {
	private Node<E> top;
	private int numElements = 0;

	@Override
	public boolean isEmpty() {
		return top == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public int numElements() {
		return numElements;
	}

	@Override
	public void push(E element) throws OverflowException {
		Node<E> n = new Node<E>(element);
		if (top == null) {
			top = n;
		} else {
			n.setNext(top);
			top = n;
		}
		numElements++;
	}

	@Override
	public E pop() throws UnderflowException {
		if (top == null) {
			throw new UnderflowException();
		}
		Node<E> n = top;
		top = top.getNext();
		numElements--;
		return n.getElement();
	}

	@Override
	public E top() throws UnderflowException {
		return top.getElement();
	}

	public String toString() {
		String s = "";
		Node<E> n = top;
		for (int i = 0; i < numElements; i++) {
			if (i == numElements - 1) {
				s += n.getElement();
			} else {
				s += n.getElement() + ", ";
			}
			n = n.getNext();
		}
		return s;
	}

}
