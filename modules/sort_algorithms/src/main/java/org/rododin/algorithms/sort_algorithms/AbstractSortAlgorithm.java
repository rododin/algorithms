package org.rododin.algorithms.sort_algorithms;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.rododin.algorithms.visualize.AlgorithmVisualizer;

/**
 * Provides a partial but useful implementation for {@link SortAlgorithm}.
 * Generally it provides basic implementation for the {@link SortAlgorithm#visualize()} and {@link SortAlgorithm#estimate()}
 * features.
 *
 * @author Nikolay Chebotaryov
 */
public abstract class AbstractSortAlgorithm <T extends Comparable<T>>
	implements SortAlgorithm<T>
{
	protected AlgorithmVisualizer visualizer;

	/**
	 * The sort algorithm iteration counter.
	 * A negative value means, the iteration counting is disabled on sorting. It's the default state.
	 * The 0 value means, the iteration counting will be started on sorting.
	 * A positive value means, the iteration counting may be continued for recursive algorithms, or may be
	 * skipped (behaves as disabled) for non-recursive algorithms.
	 * <p>NOTE: Use {@link #estimate()} to restart the counter before sorting.
	 */
	protected final AtomicInteger itCount = new AtomicInteger(-1);

	@Override
	public AbstractSortAlgorithm<T> visualize(AlgorithmVisualizer visualizer)
	{
		this.visualizer = visualizer;
		return this;
	}

	protected void doVisualize(String formatedText, Object... args)
	{
		if (visualizer != null)
			visualizer.visualize(formatedText, args);
	}

	protected void doVisualizeLn(String formatedText, Object... args)
	{
		if (visualizer != null)
			visualizer.visualizeLn(formatedText, args);
	}

	@Override
	public SortAlgorithm<T> estimate()
	{
		itCount.set(0);
		return this;
	}

	public int getIterationCount()
	{
		return itCount.get();
	}

	protected void swap(List<T> source, int i, int j)
	{
		final T tmp = source.get(i);
		source.set(i, source.get(j));
		source.set(j, tmp);
	}
}
