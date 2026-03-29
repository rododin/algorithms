package org.rododin.algorithms.sort_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.junit.Assert;
import org.junit.Before;

/**
 * A basic class for {@link SortAlgorithm} tests, introduces some useful testing utilities.
 * <p>NOTE: All predefined lists and all list-producing operations provide fully-functional non-shared
 * {@link ArrayList java.util.ArrayList} instances, i.e. we don't use {@link Arrays#asList} or other shared or limited lists
 * provided by {@link Collections} or {@link List#of()} API, or so.
 * @author Nikolay Chebotaryov
 */
public abstract class AbstractSortAlgorithmTest <T extends Comparable<T>>
{
	protected static final int DEFAULT_MINOR_LIST_SIZE = 10;
	protected static final int DEFAULT_AVERAGE_LIST_SIZE = 100;
	protected static final int DEFAULT_MAJOR_LIST_SIZE = 1000;

	// Predefined random element generators
	protected final Random random = new Random();
	protected final ThreadLocalRandom tlRandom = ThreadLocalRandom.current();

	protected List<T> emptyList = new ArrayList<>(0);
	protected List<T> singletonList;
	protected List<T> minorAscSortedList;
	protected List<T> minorDescSortedList;
	protected List<T> minorUnsortedList;

	protected SortAlgorithm<T> defaultSortAlgorithm;

	protected boolean estimate;
	protected boolean visualize;

	/**
	 * Should be implemented in descendants for initializing the following useful fields (if required for certain testing):
	 * <ul>
	 *   <li>{@link #singletonList}</li>
	 *   <li>{@link #minorAscSortedList}</li>
	 *   <li>{@link #minorDescSortedList}</li>
	 *   <li>{@link #minorUnsortedList}</li>
	 *   <li>{@link #defaultSortAlgorithm}</li>
	 * </ul>.
	 */
	@Before
	public abstract void setup();

	/**
	 * Creates a random value of the given type {@code T}.
	 */
	protected abstract T randomElement();

	/**
	 * Creates a random value of the given type {@code T} in the range of {@code minIncl} (inclusively) and
	 * {@code maxExcl} (exclusively).
	 */
	protected abstract T randomElement(T minIncl, T maxExcl);

	/**
	 * Creates a new {@link ArrayList} of the given {@code n} capacity and size, and populates it using
	 * {@link #randomElement()}.
	 *
	 * @see #randomList(int, Comparable, Comparable, BiFunction)
	 */
	protected List<T> randomList(int n)
	{
		return randomList(n, this::randomElement);
	}

	/**
	 * Creates a new {@link ArrayList} of the given {@code n} capacity and size, and populates it using the given
	 * {@code creator} which should produce random values.
	 *
	 * @see #randomList(int, Comparable, Comparable, BiFunction)
	 */
	protected List<T> randomList(int n, Supplier<T> creator)
	{
		final List<T> rv = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			rv.add(creator.get());
		return rv;
	}

	/**
	 * Creates a new {@link ArrayList} of the given {@code n} capacity and size, and populates it using
	 * {@link #randomElement(), int, int} with values in the range of {@code minIncl} (inclusively) and
	 * {@code maxExcl} (exclusively).
	 *
	 * @see #randomList(int, Comparable, Comparable, BiFunction)
	 */
	 protected List<T> randomList(int n, T minIncl, T maxExcl)
	{
		return randomList(n, minIncl, maxExcl, this::randomElement);
	}

	/**
	 * Creates a new {@link ArrayList} of the given {@code n} capacity and size, and populates it using the given
	 * {@code creator} which should produce random values in the range of {@code minIncl} (inclusively) and
	 * {@code maxExcl} (exclusively).
	 *
	 * @param n The capacity and size of the list to be created and populated.
	 * @param minIncl The minimal possible element value (inclusively).
	 * @param maxExcl The maximal possible element value (exclusively).
	 * @param creator The random value creator.
	 * @return Non-{null} {@link ArrayList} instance with the given {@code n} capacity and size with randomly populated element values.
	 */
	protected List<T> randomList(int n, T minIncl, T maxExcl, BiFunction<T, T, T> creator)
	{
		final List<T> rv = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			rv.add(creator.apply(minIncl, maxExcl));
		return rv;
	}

	/**
	 * Sorts the given {@code sourceList} using the {@link #defaultSortAlgorithm} (if defined) fully,
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, boolean)} by passing {@code false} for
	 * {@code assertContainsAllPrecisiously}.
	 */
	protected void doTest(List<T> sourceList)
	{
		doTest(sourceList, false);
	}

	/**
	 * Sorts the given {@code sourceList} using the {@link #defaultSortAlgorithm} (if defined) fully,
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, int, int, boolean)} by passing {@code 0} for
	 * {@code startIndexIncl} and {@code sourceList.size()} for {@code endIndexExcl}.
	 */
	protected void doTest(List<T> sourceList, boolean assertContainsAllPrecisiously)
	{
		doTest(sourceList, 0, sourceList.size(), assertContainsAllPrecisiously);
	}

	/**
	 * Sorts the given {@code sourceList} using the given {@code sortAlgorithm} fully,
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, SortAlgorithm, boolean)} by passing {@code false} for
	 * {@code assertContainsAllPrecisiously}.
	 */
	protected void doTest(List<T> sourceList, SortAlgorithm<T> sortAlgorithm)
	{
		doTest(sourceList, sortAlgorithm, false);
	}

	/**
	 * Sorts the given {@code sourceList} using the given {@code sortAlgorithm} fully,
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, int, int, SortAlgorithm, boolean)} by passing {@code 0} for
	 * {@code startIndexIncl} and {@code sourceList.size()} for {@code endIndexExcl}.
	 */
	protected void doTest(List<T> sourceList, SortAlgorithm<T> sortAlgorithm, boolean assertContainsAllPrecisiously)
	{
		doTest(sourceList, 0, sourceList.size(), sortAlgorithm, assertContainsAllPrecisiously);
	}

	/**
	 * Sorts the given {@code sourceList} using the given {@link #defaultSortAlgorithm} if defined,
	 * starting from {@code startIndexIncl} (inclusively) and ending by {@code endIndexExcl} (exclusively),
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, int, int, boolean)} by passing {@code false} for
	 * {@code assertContainsAllPrecisiously}.
	 */
	protected void doTest(List<T> sourceList, int startIndexIncl, int endIndexExcl)
	{
		doTest(sourceList, startIndexIncl, endIndexExcl, false);
	}

	/**
	 * Sorts the given {@code sourceList} using the given {@link #defaultSortAlgorithm} if defined,
	 * starting from {@code startIndexIncl} (inclusively) and ending by {@code endIndexExcl} (exclusively),
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, int, int, SortAlgorithm, boolean)} by passing {@link #defaultSortAlgorithm} for
	 * {@code sortAlgorithm}.
	 */
	protected void doTest(List<T> sourceList, int startIndexIncl, int endIndexExcl, boolean assertContainsAllPrecisiously)
	{
		if (defaultSortAlgorithm == null)
			throw new IllegalStateException("Default sort algorithm is not defined");
		doTest(sourceList, startIndexIncl, endIndexExcl, defaultSortAlgorithm, assertContainsAllPrecisiously);
	}

	/**
	 * Sorts the given {@code sourceList} using the given {@code sortAlgorithm},
	 * starting from {@code startIndexIncl} (inclusively) and ending by {@code endIndexExcl} (exclusively),
	 * and ensures it sorted properly in ascending order.
	 * Generally it calls to {@link #doTest(List, int, int, SortAlgorithm, boolean)} by passing {@code false} for
	 * {@code assertContainsAllPrecisiously}.
	 */
	protected void doTest(List<T> sourceList, int startIndexIncl, int endIndexExcl, SortAlgorithm<T> sortAlgorithm)
	{
		doTest(sourceList, startIndexIncl, endIndexExcl, sortAlgorithm, false);
	}

	/**
	 * Sorts the given {@code sourceList} using the given {@code sortAlgorithm},
	 * starting from {@code startIndexIncl} (inclusively) and ending by {@code endIndexExcl} (exclusively),
	 * and ensures it sorted properly in ascending order. Optionally it also asserts the {@code sortedList} contents
	 * using {@link #containsAllPrecisiously(List, List, int, int)}, if {@code assertContainsAllPrecisiously} is set.
	 *
	 * <p>NOTE 1: It creates a copy of the sub-list of the given {@code sourceList},
	 *            starting from {@code startIndexIncl} (inclusively) and ending by {@code endIndexExcl} (exclusively),
	 *            and thus the given {@code sourceList} is kept unmodified. It may involve
	 *            additional {@code O(n)} computation complexity depending on the given {@code sourceList} implementation.
	 *            Here and below {@code n = endIndexExcl - startIndexIncl}.
	 *
	 * <p>NOTE 2: The assertion of the elements order in the {@code sortedList} involves addition {@code O(n)} computation complexity.
	 *
	 * <p>NOTE 3: The optional assertion of the {@code sortedList} contents using
	 *           {@link #containsAllPrecisiously(List, List, int, int)} involves additional <code>O(n<sup>2</sup>)</code>
	 *           computation complexity in worst case. Thus, we don't recommend to pass {@code true} for the
	 * 	         {@code assertContainsAllPrecisiously} parameter together with huge {@code n}.
	 *
	 * @param sourceList Non-{@code null} list to be copied and sorted, so, it will not be modified on sorting.
	 * @param startIndexIncl The starting index to start sorting from (inclusively), where {@code 0 ≤ startIndexIncl < endIndexExcl}.
	 * @param endIndexExcl The ending index to sort up to (exclusively), where {@code startIndexIncl < endIndexExcl ≤ sourceList.size()}.
	 * @param sortAlgorithm Non-{@code null} {@link SortAlgorithm} to sort the {@code sourceList} with.
	 * @param assertContainsAllPrecisiously Pass {@code true} to activate the assertion of the {@code sortedList} contents using
	 * 	                                    {@link #containsAllPrecisiously(List, List, int, int)}.
	 */
	protected void doTest(List<T> sourceList, int startIndexIncl, int endIndexExcl, SortAlgorithm<T> sortAlgorithm, boolean assertContainsAllPrecisiously)
	{
		if (estimate)
			sortAlgorithm.estimate();
		if (visualize)
			sortAlgorithm.visualize(System.out::printf);
		final List<T> sortedList = sortAlgorithm.sort(new ArrayList<>(sourceList.subList(startIndexIncl, endIndexExcl)), startIndexIncl, endIndexExcl);
		Assert.assertEquals(endIndexExcl - startIndexIncl, sortedList.size());
		if (sortedList.size() == 1)
		{
			Assert.assertEquals(sourceList.get(startIndexIncl), sortedList.getFirst());
			return;
		}
		for (int i = startIndexIncl, j = startIndexIncl + 1; j < endIndexExcl; i++, j++)
			Assert.assertTrue(sortedList.get(i).compareTo(sortedList.get(j)) <= 0);
		if (assertContainsAllPrecisiously)
			containsAllPrecisiously(sourceList, sortedList, startIndexIncl, endIndexExcl);
	}

	/**
	 * Precisely ensures, all the elements from {@code sortedList} are present in the {@code sourceList}, accounting
	 * the numbers of duplicated elements.
	 * @see #containsAllPrecisiously(List, List, int, int)
	 */
	protected boolean containsAllPrecisiously(List<T> sourceList, List<T> sortedList)
	{
		return containsAllPrecisiously(sourceList, sortedList, 0, sourceList.size());
	}

	/**
	 * Precisely ensures, all the elements from {@code sortedList}, starting from the index {@code startIndexIncl} (inclusively)
	 * and ending by the index {@code endIndexExcl} (exclusively), are present in the {@code sourceList}, accounting
	 * the numbers of duplicated elements. It differs from the regular {@link Collection#containsAll(Collection)} method
	 * which normally doesn't account the number of each element entrance.
	 *
	 * <p>Example:
	 * <ul>
	 *   <li>{@code List.of(2, 2, 1).containsAll(List.of(1, 1, 2))} - gives {@code true}.</li>
	 *   <li>{@code containsAllPrecisiously(List.of(2, 2, 1), List.of(1, 1, 2), 0, 3)} - gives {@code false}.</li>
	 * </ul>
	 *
	 * <p>NOTE: The computation complexity of the method may reach <code>O(n<sup>2</sup>)</code> in worst case,
	 *          where {@code n = endIndexExcl - startIndexIncl}.
	 *          And thus it's not recommended to use for assertions of too huge sorted lists.
	 *
	 * @param sourceList Non-{@code null} source list, can be empty, can be sorted or unsorted.
	 * @param sortedList Non-{@code null} sorted list, can be empty, must be sorted in ascending or descending order.
	 * @param startIndexIncl The starting index of the both, {@code sourceList} and {@code sortedList}, to check elements from (inclusively),
	 *                       where {@code 0 ≤ startIndexIncl < endIndexExcl}.
	 * @param endIndexExcl the ending index of the both, {@code sourceList} and {@code sortedList}, to check elements up to (exclusively),
	 *                     where {@code startIndexIncl < endIndexExcl ≤ sortedList.size()}.
	 * @return {@code true} if and only if each element from {@code sortedList} is present in {@code sourceList},
	 *         starting from the index {@code startIndexIncl} (inclusively) and ending by the index {@code endIndexExcl} (exclusively),
	 *         accounting the number of the element entrance.
	 */
	protected boolean containsAllPrecisiously(List<T> sourceList, List<T> sortedList, int startIndexIncl, int endIndexExcl)
	{
		for (int i = startIndexIncl, j = i+1, dupCount = 1; j < endIndexExcl; i++, j++)
		{
			if (Objects.equals(sortedList.get(i), sortedList.get(j)))
				dupCount++;
			else
			{
				int findCount = 0;
				for (int k = startIndexIncl; k < endIndexExcl; k++)
				{
					if (Objects.equals(sortedList.get(i), sourceList.get(k)))
						findCount++;
				}
				if (dupCount != findCount)
					return false;
				dupCount = 1;
			}
		}
		return true;
	}
}
