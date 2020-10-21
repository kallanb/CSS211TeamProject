package teamProject02;
/* Team 4 - Renee White, Kallan Brainard, Shangyu Chan, Yasir Egal
 * CS 211 Project 2
 * August 5, 2020 */

//Class ArrayList<E>	can be used	to	store	a list of values of type E.

import java.util.*;

public class ArrayList<E> extends AbstractList<E> {
	private E[] elementData; // list of values

	public static final int DEFAULT_CAPACITY = 100;

	// pre : capacity >= 0 (throws IllegalArgumentException if not)
	// post: constructs an empty list with the given capacity
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		if (capacity < 0) {
			throw new IllegalArgumentException("capacity: " + capacity);
		}
		elementData = (E[]) new Object[capacity];
		size = 0;
	}

	// post: constructs an empty list of default capacity
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	// pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// post: inserts the given value at the given index, shifting subsequent
	// values right
	public void add(int index, E value) {
		checkIndex(index);
		ensureCapacity(size + 1);
		for (int i = size; i >= index + 1; i--) {
			elementData[i] = elementData[i - 1];
		}
		elementData[index] = value;
		size++;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: removes value at the given index, shifting subsequent values left
	public void remove(int index) {
		checkIndex(index);
		for (int i = index; i < size - 1; i++) {
			elementData[i] = elementData[i + 1];
		}
		elementData[size - 1] = null;
		size--;
	}

	// post: returns an iterator for this list
	public Iterator<E> iterator() {
		return new ArrayListIterator();
	}

	// post: ensures that the underlying array has the given capacity; if not,
	// the size is doubled (or more if given capacity is even larger)
	public void ensureCapacity(int capacity) {
		if (capacity > elementData.length) {
			int newCapacity = elementData.length * 2 + 1;
			if (capacity > newCapacity) {
				newCapacity = capacity;
			}
			elementData = Arrays.copyOf(elementData, newCapacity);
		}
	}

	private class ArrayListIterator implements Iterator<E> {
		private int position; // current position within the list
		private boolean removeOK; // whether it's okay to remove now

		// post: constructs an iterator for the given list
		public ArrayListIterator() {
			position = 0;
			removeOK = false;
		}

		// post: returns true if there are more elements left, false otherwise
		public boolean hasNext() {
			return position < size();
		}

		// pre : hasNext() (throws NoSuchElementException if not)
		// post: returns the next element in the iteration
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			E result = elementData[position];
			position++;
			removeOK = true;
			return result;
		}

		// pre : next() has been called without a call on remove (throws
		// IllegalStateException if not)
		// post: removes the last element returned by the iterator
		public void remove() {
			if (!removeOK) {
				throw new IllegalStateException();
			}
			for (int i = position - 1; i < size - 1; i++) {
				elementData[i] = elementData[i + 1];
			}
			elementData[size - 1] = null;
			position--;
			size--;
			removeOK = false;
		}
	}
}
