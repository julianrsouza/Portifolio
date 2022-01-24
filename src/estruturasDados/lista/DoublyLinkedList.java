package estruturasDados.lista;

import estruturasDados.UnderflowException;

public class DoublyLinkedList<E> implements List<E> {
	protected DNode<E> head;
	protected DNode<E> tail;
	protected int numElements;

	public DoublyLinkedList() {
		this.head = null;
		this.tail = null;
		this.numElements = 0;
	}

	@Override
	public int numElements() {
		return numElements;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public boolean isFull() {
		return false;
	}

	public void insertFirst(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();
		DNode<E> newNode = new DNode<>(element);
		if (isEmpty())
			head = tail = newNode;
		else {
			newNode.setNext(head);
			head.setPrevious(newNode);
			head = newNode;
		}
		numElements++;
	}

	public void insertLast(E element) {
		DNode<E> n = new DNode<E>(element);
		if (this.isEmpty()) {
			head = tail = n;
		} else {
			tail.setNext(n);
			n.setPrevious(tail);
			tail = n;
		}
		numElements++;
	}

	public E removeFirst() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = head.getElement();
		if (head == tail)
			head = tail = null;
		else {
			head = head.getNext();
			head.setPrevious(null);
		}
		numElements--;
		return element;
	}

	public E removeLast() throws UnderflowException {
		if (isEmpty())
			throw new UnderflowException();
		E element = tail.getElement();
		if (head == tail)
			head = tail = null;
		else {
			tail = tail.getPrevious();
			tail.setNext(null);
		}
		numElements--;
		return element;
	}

	@Override
	public void insert(E element, int pos) throws NullPointerException, IndexOutOfBoundsException {
		if (element == null)
			throw new NullPointerException();
		if (pos < 0 || pos > numElements)
			throw new IndexOutOfBoundsException();
		if (pos == 0)
			insertFirst(element);
		else if (pos == numElements)
			insertLast(element);
		else {
			DNode<E> current = head;
			for (int i = 0; i < pos - 1; i++)
				current = current.getNext();
			DNode<E> newNode = new DNode<>(element);
			current.getNext().setPrevious(newNode);
			newNode.setNext(current.getNext());
			newNode.setPrevious(current);
			current.setNext(newNode);
			numElements++;
		}

	}

	@Override
	public E remove(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();
		if (pos == 0)
			return removeFirst();
		else if (pos == numElements - 1)
			return removeLast();
		else {
			DNode<E> current = head;
			for (int i = 0; i < pos - 1; i++)
				current = current.getNext();
			E element = current.getNext().getElement();
			current.getNext().getNext().setPrevious(current);
			current.setNext(current.getNext().getNext());
			numElements--;
			return element;
		}
	}

	@Override
	public E get(int pos) throws IndexOutOfBoundsException {
		if (pos < 0 || pos >= numElements)
			throw new IndexOutOfBoundsException();

		DNode<E> current = head;
		for (int i = 0; i < pos; i++)
			current = current.getNext();

		return current.getElement();

	}

	@Override
	public int search(E element) throws NullPointerException {
		if (element == null)
			throw new NullPointerException();

		DNode<E> current = head;
		int i = 0;
		while (current != null) {
			if (element.equals(current.getElement()))
				return i;
			i++;
			current = current.getNext();
		}

		return -1;

	}

	public void print() {
		DNode<E> current = head;
		while (current != null) {
			System.out.println(current.getElement());
			current = current.getNext();
		}
	}

	public String toString() {
		String s = "";

		DNode<E> current = head;
		while (current != null) {
			s += current.getElement().toString() + " - ";
			current = current.getNext();
		}
		return s;

	}

}
