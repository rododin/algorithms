package org.rododin.algorithms.sort_algorithms;

import java.util.List;

import org.rododin.algorithms.measure.ComputationComplexity;

/**
 * Implements the well known <a href="https://en.wikipedia.org/wiki/Bubble_sort">Bubble Sort Algorithm</a> in the
 * most traditional (classical) way, where each minimal element goes up on each iteration, i.e. after the first outer
 * iteration we have the minimal element placed on the top (at the index of {@code 0}) of the list, then
 * after the second outer iteration we have the next minimal element placed at the index of {@code 1}, and so on,
 * until we finish with maximal element placed at the end of the list.
 */
public class BubbleSortAlgorithm <T extends Comparable<T>>
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
			for(int j = last; j > i; j--)
			{
				itCount.accumulateAndGet(1, (a, b) -> a >= 0 ? a + b : a);
				if (source.get(i).compareTo(source.get(j)) >= 0)
					swap(source, i, j);
			}
			//System.out.println(getClass().getSimpleName() + ": Out   \u001B[47m\u001B[31m" + i + "\u001B[0m: " + source.subList(startIndexIncl, endIndexExcl));
			doVisualizeLn("%25s: Out-iteration %3d: %s", getClass().getSimpleName(), i, source.subList(startIndexIncl, endIndexExcl));
		}
		doVisualizeLn(getClass().getSimpleName() + ": Sorted : " + source.subList(startIndexIncl, endIndexExcl)
			                  + (itCount.get() >= 0 ? "\n         Estimation: n=" + (endIndexExcl - startIndexIncl) + ", itCount=" + itCount + ", O=" + ComputationComplexity.estimate(endIndexExcl - startIndexIncl, itCount.get()) : ""));
		return source;
	}
}
