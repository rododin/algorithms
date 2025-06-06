package org.rododin.algorithms.sort_algorithms;

import java.util.List;

import org.rododin.algorithms.visualize.AlgorithmVisualizer;

/**
 * Introduces a sort algorithm for a {@link List} of elements of the type {@code T}, where {@code T} extends
 * {@link Comparable}.
 *
 * @author Nikolay Chebotaryov
 */
public interface SortAlgorithm <T extends Comparable<T>>
{
	default SortAlgorithm<T> visualize(AlgorithmVisualizer visualizer)
	{
		throw new UnsupportedOperationException();
	}

	default SortAlgorithm<T> estimate()
	{
		throw new UnsupportedOperationException();
	}

	/**
	 * Sorts the given {@code source} list entirely in ascending order.
	 * @param source the list to be sorted, cannot be {@code null}.
	 * @return the sorted list, it can be the same instance as the given one, or a newly created list instance,
	 *         depends on algorithm
	 */
	default List<T> sort(List<T> source)
	{
		return sort(source, 0, source.size());
	}

	/**
	 * Sorts the given {@code source} list in ascending order starting from the given {@code startIndexIncl} (inclusive)
	 * and ending on the given {@code endIndexExcl} (exclusive).
	 * @param source the list to be sorted, cannot be {@code null}.
	 * @return the sorted list, it can be the same instance as the given one, or a newly created list instance,
	 *         depends on algorithm implementation
	 */
	List<T> sort(List<T> source, int startIndexIncl, int endIndexExcl);
}
