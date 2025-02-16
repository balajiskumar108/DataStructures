package model;

import java.util.ArrayList;
import java.util.List;

/*
 * Requirement:
 * You are required to implement all methods recursively.
 */
public class RecursiveMethods {

	/*
	 * A useful extension to the original `splitArray` problem.
	 * 
	 * If a split of equal sums is possible, return an ArrayList of size 2: - index
	 * 1 of the returned ArrayList stores the list of integers representing group 1.
	 * - index 0 of the returned ArrayList stores the list of integers representing
	 * group 1.
	 * 
	 * If a split is not possible, both indices store empty lists.
	 * 
	 * Requirements (as an example, see `testSplitArrayHarder_14` in
	 * RecursiveMethodTests): When an equal split is possible, then: + The first
	 * element of the input array `ns` (i.e., ns[0]) must be put into group1. + The
	 * order in which elements appear in each group must be the same as they appear
	 * in the input array `ns`.
	 * 
	 * Assumption: when a split is possible, there is a single, unique split only.
	 * 
	 * Hints: + Pass as arguments two empty lists, representing group1 and group2,
	 * to the call to a recursive helper method. + Via call by value, the two lists
	 * should be modified properly among as the recursion tree is built. + Upon the
	 * call terminating, return a list containing the two modified lists.
	 */
	public ArrayList<ArrayList<Integer>> splitArrayHarder(int[] ns) {

		if (ns.length == 0) {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<>()); 
			result.add(new ArrayList<>()); 
			return result; 
		}

		// Create two arraylist which stores integers
		ArrayList<Integer> group1 = new ArrayList<>();
		ArrayList<Integer> group2 = new ArrayList<>();

		// Make sure the first element is always in group 1, ns[0] should be in group 1
		group1.add(ns[0]);

		// Call the helper method to check if a split is possible, if it is add to the
		// result ararylist
		if (splitHelper(ns, 1, ns[0], 0, group1, group2)) {

			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			result.add(group1);
			result.add(group2);

			return result;
		} else {
			ArrayList<ArrayList<Integer>> result = new ArrayList<>();
			result.add(new ArrayList<>());
			result.add(new ArrayList<>());

			return result;
		}
	}

	/**
	 * Helper Method
	 */
	private boolean splitHelper(int[] ns, int index, int sum1, int sum2, List<Integer> group1, List<Integer> group2) {

		// Base case
		if (ns.length == index) {
			return sum1 == sum2;
		}

		// Check if split is possible in group 1, using the helper method recursively
		group1.add(ns[index]);

		if (splitHelper(ns, index + 1, sum1 + ns[index], sum2, group1, group2)) {
			return true;
		}

		group1.remove(group1.size() - 1);

		// Check if split is possible in group2, using helper method recursively
		group2.add(ns[index]);

		// return true if possible
		if (splitHelper(ns, index + 1, sum1, sum2 + ns[index], group1, group2)) {
			return true;
		}
		// Backtrack
		group2.remove(group2.size() - 1);

		// return false if no split found
		return false;
	}
}
