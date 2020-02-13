/*
 * SortAlgorithms.java
 */

package org.rododin.algorithms.sort_algorithms;

import java.util.ArrayList;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.sort_algorithms.algorithms.BubbleSortMaxGoesDown;
import org.rododin.algorithms.sort_algorithms.algorithms.BubbleSortMinGoesUp;
import org.rododin.algorithms.sort_algorithms.algorithms.InsertionSort;
import org.rododin.algorithms.sort_algorithms.algorithms.SelectionSort;

/**
 * The main application class.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SortAlgorithms
	implements Constants
{
	public static final int DEF_DATA_SIZE = 50;
	public static final int DEF_MAX_VALUE = 50;

	public static void main(String[] args)
	{
		sortBy(new BubbleSortMaxGoesDown());
		sortBy(new BubbleSortMinGoesUp());
		sortBy(new SelectionSort());
		sortBy(new InsertionSort());

		//sortBy(new QuickSort());
		//sortBy(new MergeSort(10, null));
		//sortBy(new ShellSort());
	}

	public static void sortBy(IntSortAlgorithm algorithm)
	{
		final int[] array = new int[DEF_DATA_SIZE];
		final ArrayList<Integer> list = new ArrayList<Integer>(DEF_DATA_SIZE);

		IntSortUtils.generateRandomArray(array, DEF_MAX_VALUE);
		IntSortUtils.generateRandomList(list, DEF_DATA_SIZE, DEF_MAX_VALUE);

		String info = algorithm.getClass().getSimpleName()
			+  "\n{"
			+  "\n  Array:"
			+  "\n    Initial : arLength=" + array.length + ", array=" + IntSortUtils.toString(array)
			;
		int itCount = algorithm.sort(array);
		info
			+= "\n    Sorted  : itCount =" + itCount + ", array=" + IntSortUtils.toString(array)
			+  "\n    isSorted: " + IntSortUtils.assertSorted(array)
			+  "\n  List:"
			+  "\n    Initial : listSize=" + list.size() + ", list=" + list;
		itCount = algorithm.sort(list);
		info
			+= "\n    Sorted  : itCount =" + itCount + ", list=" + list
			+  "\n    isSorted: " + IntSortUtils.assertSorted(list)
			+  "\n}";

		Log.info(info);
	}
}
