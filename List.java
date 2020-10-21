package teamProject02;
/* Team 4 - Renee White, Kallan Brainard, Shangyu Chan, Yasir Egal
 * CS 211 Project 2
 * August 5, 2020 */

import java.util.*;

//	Generic interface for a List of E objects.

public interface List<E> extends Iterable<E>	{
	public int size();
	public E get(int index);
	public int indexOf(E value);
	public boolean isEmpty();
	public boolean contains(E value);
	public void add(E value);
	public void add(int index, E value);
	public void addAll(List<E> other);
	public void remove(int index);
	public void set(int index, E value);
	public void clear();
}
