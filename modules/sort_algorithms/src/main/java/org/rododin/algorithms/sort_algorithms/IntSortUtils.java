/*
 * AbstractSortAlgorithm.java
 */

package org.rododin.algorithms.sort_algorithms;

import java.util.List;
import java.util.Random;

import org.rododin.algorithms.Constants;

/**
 * Introduces some useful data manipulation operations like value swap, etc.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public abstract class IntSortUtils
	implements Constants
{
	/**
	 * Swaps the element i with the element j in the given array.
	 * @param array the array
	 * @param i the index of the 1-st element
	 * @param j the index of the 2-nd element
	 */
	public static void swap(int[] array, int i, int j)
	{
		//if (i == j)
		//	return;
		final int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	/**
	 * Swaps the element i with the element j in the given list.
	 * @param list the list
	 * @param i the index of the 1-st element
	 * @param j the index of the 2-nd element
	 */
	public static <T> void swap(List<T> list, int i, int j)
	{
		//if (i == j)
		//	return;
		final T tmp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, tmp);
	}

	public static void generateRandomArray(int[] array, int maxValue)
	{
		for (int i = 0; i < array.length; i++)
			array[i] = RANDOM.nextInt(maxValue);
	}

	public static void generateRandomList(List<Integer> list, int count, int maxValue)
	{
		list.clear();
		for (int i = 0; i < count; i++)
			list.add(RANDOM.nextInt(maxValue));
	}

	public static void generateRandomList(List<Integer> list, int first, int afterLast, int maxValue)
	{
		for (int i = first; i < afterLast; i++)
			list.set(i, RANDOM.nextInt(maxValue));
	}

	public static String toString(int[] array)
	{
		return toString(array, ", ");
	}

	public static String toString(int[] array, String delimiter)
	{
		return toString(array, "[", "]", delimiter);
	}

	public static String toString(int[] array, String opening, String closing, String delimiter)
	{
		final StringBuilder sb = new StringBuilder(opening);
		final int last = array.length - 1;
		if (array.length > 0)
		{
			for (int i = 0; ; i++)
			{
				sb.append(array[i]);
				if (i == last)
					break;
				sb.append(delimiter);
			}
		}
		return sb.append(closing).toString();
	}

	public static boolean assertSorted(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if (array[i] > array[i+1])
				return false;
		}
		return true;
	}

	public static boolean assertSortedDescending(int[] array)
	{
		for (int i = 0; i < array.length - 1; i++)
		{
			if (array[i] < array[i+1])
				return false;
		}
		return true;
	}

	public static boolean assertSorted(List<Integer> list)
	{
		for (int i = 0; i < list.size() - 1; i++)
		{
			if (list.get(i) > list.get(i+1))
				return false;
		}
		return true;
	}

	public static boolean assertSortedDescending(List<Integer> list)
	{
		for (int i = 0; i < list.size() - 1; i++)
		{
			if (list.get(i) < list.get(i+1))
				return false;
		}
		return true;
	}

	public static int sortAndAssert(int[] array, IntSortAlgorithm algorithm, boolean log)
	{
		String info = null;
		if (log)
			info = algorithm.getClass().getSimpleName()
				+  "\n{"
				+  "\n  Array:"
				+  "\n    Initial : arLength=" + array.length + ", array=" + IntSortUtils.toString(array)
				;

		final int itCount = algorithm.sort(array);
		final boolean sorted = IntSortUtils.assertSorted(array);

		if (log)
		{
			info
				+= "\n    Sorted  : itCount =" + itCount + ", array=" + IntSortUtils.toString(array)
				   + "\n    isSorted: " + sorted
				   + "\n}";
			Log.info(info);
		}

		return sorted ? itCount : -1;
	}

	public static int sortAndAssert(List<Integer> list, IntSortAlgorithm algorithm, boolean log)
	{
		String info = null;
		if (log)
			info = algorithm.getClass().getSimpleName()
				+  "\n{"
				+  "\n  List:"
				+  "\n    Initial : listSize=" + list.size() + ", list=" + list
				;

		final int itCount = algorithm.sort(list);
		final boolean sorted = IntSortUtils.assertSorted(list);

		if (log)
		{
			info
				+= "\n    Sorted  : itCount =" + itCount + ", list=" + list
				+  "\n    isSorted: " + sorted
				+  "\n}";
			Log.info(info);
		}

		return sorted ? itCount : -1;
	}

	private static final Random RANDOM = new Random();
}
