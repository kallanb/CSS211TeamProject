package teamProject02;
/* Team 4 - Renee White, Kallan Brainard, Shangyu Chan, Yasir Egal
 * CS 211 Project 2
 * August 5, 2020 */

//compiler directive	to	eliminate superfluous warnings.
@SuppressWarnings("unchecked")

public class ListClient3 {
	public static void main(String[] args) {
		// lists to display the abstract class works
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		LinkedList<Integer> list2 = new LinkedList<Integer>();

		// lists for addAll() function
		ArrayList<Integer> compare1 = new ArrayList<Integer>();
		LinkedList<Integer> compare2 = new LinkedList<Integer>();
		compare1.add(-10);
		compare1.add(34);
		compare2.add(99);
		compare2.add(4);

		// display contents of list1 and list2
		System.out.println("Testing an ArrayList:");
		processList(list1, compare1, compare2);
		System.out.println("\nTesting a LinkedList:");
		processList(list2, compare1, compare2);
	}

	public static void processList(List<Integer> list, List<Integer> list2, List<Integer> list3) {
		// add(value) method
		list.add(42);
		list.add(18);
		list.add(27);
		list.add(93);
		System.out.println("Adding Values: " + list);
		// remove(index) method
		// NOTE: remove cannot be in abstract class because the iterator method we have
		// cannot remove the first value or first index of a list
		list.remove(2);
		list.remove(0);
		System.out.println("Removing Values at Index 0 and 2. Updated List: " + list);

		// add(index, value) method
		list.add(1, 50);
		System.out.println("Adding 50 at index 1. Updated List: " + list);

		// size() method
		System.out.println("List Size: " + list.size());

		// get() method
		System.out.println("Value at index position 0: " + list.get(0));
		System.out.println("Value at index position 2: " + list.get(2));

		// indexOf(value) method
		System.out.println("Position for the value 93: " + list.indexOf(93));
		System.out.println("Position for the value 18: " + list.indexOf(18));

		// contains(value) method
		System.out.println("Does this list contain 100? " + list.contains(100));

		// isEmpty() method
		System.out.println("Is this list empty? " + list.isEmpty());

		// set(index, value) method
		list.set(1, 10);
		list.set(0, 2);
		System.out.println("Set index 0 of the list to 2 and index 1 of the list to 10. Updated List: " + list);

		// addAll() method with a ArrayList
		list.addAll(list2);
		System.out.println("List after adding " + list2 + ": " + list);
		// addAll() method with an LinkedList
		list.addAll(list3);
		System.out.println("List after adding " + list3 + ": " + list);

		System.out.println("Clearing List...");
		// clear() method
		list.clear();

		// isEmpty() method
		System.out.println("Is this list empty? " + list.isEmpty());

		// size() method
		System.out.println("List Size: " + list.size());
		System.out.println("Final List: " + list);
	}
}
