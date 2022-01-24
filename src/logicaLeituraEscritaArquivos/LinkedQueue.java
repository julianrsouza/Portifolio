package logicaLeituraEscritaArquivos;

public class LinkedQueue<E> implements Queue<E> {
	private Node<E> first;
	private Node<E> last;
	private int numElements;

	public LinkedQueue() {
		first = last = null;
		numElements = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public boolean isFull() {
		return false;
	}

	public int numElements() {
		return numElements;
	}

	@Override
	public void enqueue(E element) throws OverflowException {
		Node<E> n = new Node<E>(element);
		if (isEmpty()) {
			first = last = n;
		} else {
			last.setNext(n);
			last = n;
		}
		numElements++;
	}

	@Override
	public E dequeue() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		Node<E> n = first;
		first = first.getNext();
		numElements--;
		return n.getElement();
	}

	@Override
	public E front() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return first.getElement();
	}

	@Override
	public E back() throws UnderflowException {
		if (isEmpty()) {
			throw new UnderflowException();
		}
		return last.getElement();
	}

	public String toString() {
		String s = "";
		Node<E> n = first;
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
