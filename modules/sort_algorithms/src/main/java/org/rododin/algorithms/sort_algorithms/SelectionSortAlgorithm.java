package org.rododin.algorithms.sort_algorithms;

import java.util.List;

import org.rododin.algorithms.measure.ComputationComplexity;

/**
 * Implements the well known <a href="https://en.wikipedia.org/wiki/Selection_sort">Selection Sort Algorithm</a> in the
 * most traditional (classical) way, where on each outer iteration we find the index of the minimal element in the
 * tail of the list and exchange it with the element at the current outer index if required.
 * Compared with {@link BubbleSortAlgorithm} it executes not more than {@code n-1} swap operations, but the performance
 * is still estimated as {@code O(n²/2)} in worst case.
 *
 * @author Nikolay Chebotaryov
 */
public class SelectionSortAlgorithm  <T extends Comparable<T>>
	extends AbstractSortAlgorithm<T>
{
	@Override
	public List<T> sort(List<T> source, int startIndexIncl, int endIndexExcl)
	{
		doVisualizeLn("--------------------");
		doVisualizeLn("%25s: Sorting: %s", getClass().getSimpleName(), source.subList(startIndexIncl, endIndexExcl));

		final int last = endIndexExcl - 1;
		for (int i = startIndexIncl; i < last; i++)
		{
			int min = i;
			for (int j = i + 1; j < endIndexExcl; j++)
			{
				itCount.accumulateAndGet(1, (a, b) -> a >= 0 ? a + b : a);
				if (source.get(j).compareTo(source.get(min)) < 0)
					min = j;
			}
			if (i != min)
				swap(source, i, min);

			doVisualizeLn("%25s: Out-iteration %3d: %s", getClass().getSimpleName(), i, source.subList(startIndexIncl, endIndexExcl));
		}
		doVisualizeLn("%25s: Sorted : %s", getClass().getSimpleName(), source.subList(startIndexIncl, endIndexExcl));
		if (itCount.get() >= 0)
			doVisualizeLn("         Estimation: n=%d, itCount=%d, O=%s",(endIndexExcl - startIndexIncl), itCount.get(), ComputationComplexity.estimate(endIndexExcl - startIndexIncl, itCount.get()));
		return source;
	}
}
