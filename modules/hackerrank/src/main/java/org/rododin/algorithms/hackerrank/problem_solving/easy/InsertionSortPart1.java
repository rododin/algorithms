package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.function.Consumer;

/**
 * <a href="https://www.hackerrank.com/challenges/insertionsort1/problem">
 *   HackerRank > Practice > Algorithms > Sorting > Insertion Sort - Part 1
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class InsertionSortPart1
{
	/**
	 * Implements a trivial and effective solution described in the original task definition.
	 * The complexity is <code>O(n-1)</code> in worst case where {@code n = arr.length}.
	 * <p/>
	 * It precisely provides the method signature defined in the original task.
	 * Generally it just calls {@link #insertionSort1(int, int[], Consumer)} where the {@code printer} just prints
	 * the modified {@code arr} on each iteration.
	 *
	 * @param n     generally it's just the length/size of the given {@code arr}, i.e. {@code n = arr.length},
	 *              so it's a redundant parameter for a Java implementation coming from
	 *              the original {@code insertionSort1()} method signature from the original task definition,
	 *              but as a side effect it allows to sort a part of a bigger array if {@code 0 ≤ n < arr.length}.
	 *              The constraints are weaker compared with the original task.
	 * @param arr   the array to be sorted according to the original task definition
	 *              (the latest/right element should be reinserted at the right position),
	 *              where <code>0 ≤ arr.length ≤ {@link Integer#MAX_VALUE}</code>
	 *                and <code>arr[i] ∈ {{@link Integer#MIN_VALUE}...{@link Integer#MAX_VALUE}}</code>
	 *                and first {@code n-2} elements (starting from {@code 0}) are naturally sorted
	 *                but {@code arr[n-1]} is not sorted and should be reinserted to get the array fully sorted.
	 *                The constraints are also weaker compared with the original task.
	 *
	 * @see #insertionSort1(int, int[], Consumer)
	 */
	public static void insertionSort1(int n, int[] arr)
	{
		insertionSort1(n, arr, InsertionSortPart1::println);
	}

	/**
	 * Implements a trivial and effective solution described in the original task definition.
	 * The complexity is <code>O(n-1)</code> in worst case where {@code n = arr.length}.
	 *
	 * @param n     generally it's just the length/size of the given {@code arr}, i.e. {@code n = arr.length},
	 *              so it's a redundant parameter for a Java implementation coming from
	 *              the original {@code insertionSort1()} method signature from the original task definition,
	 *              but as a side effect it allows to sort a part of a bigger array if {@code 0 ≤ n < arr.length}.
	 *              The constraints are weaker compared with the original task.
	 * @param arr   the array to be sorted according to the original task definition
	 *              (the latest/right element should be reinserted at the right position),
	 *              where <code>0 ≤ arr.length ≤ {@link Integer#MAX_VALUE}</code>
	 *                and <code>arr[i] ∈ {{@link Integer#MIN_VALUE}...{@link Integer#MAX_VALUE}}</code>
	 *                and first {@code n-2} elements (starting from {@code 0}) are naturally sorted
	 *                but {@code arr[n-1]} is not sorted and should be reinserted to get the array fully sorted.
	 *                The constraints are also weaker compared with the original task.
	 * @param printer a {@link Consumer} for printing the modified {@code arr} on each iteration as requested
	 *                in the original task definition, but this {@code printer} can be also used for asserting
	 *                each intermediate sub-result in unit tests
	 *
	 * @see #insertionSort1(int, int[])
	 */
	public static void insertionSort1(int n, int[] arr, Consumer<int[]> printer)
	{
		if (n <= 0)
			return;
		final int e = arr[n-1];
		int i;
		for (i = n-2; i >= 0 && arr[i] > e; i--)
		{
			arr[i+1] = arr[i];
			printer.accept(arr);
		}
		arr[i+1] = e;
		printer.accept(arr);
	}

	/**
	 * Prints the given {@code arr} within a single line, where the elements are separated by a single space character.
	 * @param arr the array to be printed
	 */
	public static void println(int[] arr)
	{
		for (int a : arr)
		{
			System.out.print(a);
			System.out.print(' ');
		}
		System.out.println();
	}
}
