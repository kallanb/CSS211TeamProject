package teamProject02;
/* Team 4 - Renee White, Kallan Brainard, Shangyu Chan, Yasir Egal
 * CS 211 Project 2
 * August 5, 2020 */

import java.util.*;

public abstract class AbstractList<E> implements List<E> {
	protected int size; // current number of elements in the list.

	// concrete methods-----------------------------------------------------
	// post: returns the current number of elements in the list
	public int size() {
		return size;
	}

	// post: returns true if list is empty, false otherwise
	public boolean isEmpty() {
		return size() == 0;
	}

	// post: returns true if the given value is contained in the list,
	// false otherwise
	public boolean contains(E value) {
		return indexOf(value) >= 0;
	}

	// post: list is empty
	public void clear() {
		this.size = 0;
	}

	// post: appends the given value to the end of the list
	// index of value added on at the end = size of list
	public void add(E value) {
		add(size, value);
	}

	// post: appends all values in the given list to the end of this list
	public void addAll(List<E> other) {
		for (E value : other) {
			add(value);
		}
	}

	// post : returns the position of the first occurrence of the given
	// value (-1 if not found)
	public int indexOf(E value) {
		int index = 0;
		Iterator<E> itr = iterator();
		while (itr.hasNext()) {
			if (itr.next().equals(value)) {
				return index;
			}
			index++;
		}
		return -1;
	}

	// post: creates a comma-separated, bracketed version of the list
	public String toString() {
		if (size == 0) {
			return "[]";
		} else {
			Iterator<E> itr = iterator();
			String result = "[" + itr.next();
			while (itr.hasNext()) {
				result += ", " + itr.next();
			}
			result += "]";
			return result;
		}
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: returns the value at the given index in the list
	public E get(int index) {
		checkIndex(index);
		Iterator<E> itr = iterator();
		int position = -1;
		while (itr.hasNext()) {
			position++;
			E value = itr.next();
			if (position == index) {
				return value;
			}
		}
		return null;
	}

	// pre : 0 <= index < size() (throws IndexOutOfBoundsException if not)
	// post: replaces the value at the given index with the given value
	public void set(int index, E value) {
		checkIndex(index);
		add(index, value);
		Iterator<E> itr = iterator();
		int position = -1;
		while (itr.hasNext()) {
			position++;
			if (position == index) {
				remove(index + 1);
				break;
			}
		}
	}

	// post: throws an IndexOutOfBoundsException if the given index is
	// not a legal index of the current list
	protected void checkIndex(int index) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException("index: " + index);
		}
	}

	// unimplemented methods------------------------------------------------
	// pre : 0 <= index <= size() (throws IndexOutOfBoundsException if not)
	// post: inserts the given value at the given index, shifting subsequent
	// values right
	public abstract void add(int index, E value);

	// post: returns an iterator for this list
	public abstract Iterator<E> iterator();

	// pre : next() has been called without a call on remove (i.e., at most
	// one call per call on next)
	// post: removes the last element returned by the iterator
	// remove(index) method
	// NOTE: remove cannot be in abstract class because the iterator method we have
	// cannot remove the first value or first index of a list
	public abstract void remove(int index);
}
