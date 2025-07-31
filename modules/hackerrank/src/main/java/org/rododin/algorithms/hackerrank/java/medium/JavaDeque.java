package org.rododin.algorithms.hackerrank.java.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * <a href="https://www.hackerrank.com/challenges/java-dequeue/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java Dequeue
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaDeque
{
	public static void main(String[] args)
	{
		solution2();
	}

	/**
	 * My 1st solution with complexity of {@code O(n) = 2×n}, however immediately after I completed with it,
	 * I asked me why do we need any deque here at all?
	 * Finally, I found, we still need a deque (at least it's probably a simplest solution), however we don't
	 * need to fill-out the full deque of the elements initially, i.e. we cen decrease the complexity twice.
	 * So, I implemented it within the {@link #solution2()}.
	 */
	public static void solution1()
	{
		final Scanner in = new Scanner(System.in);
		final Deque<Integer> deque = new ArrayDeque<>();
		final int n = in.nextInt();
		final int m = in.nextInt();

		for (int i = 0; i < n; i++)
		{
			final int num = in.nextInt();
			deque.push(num);
		}

		final Map<Integer, Integer> uniqueNumberCounts = new HashMap<>((int)(m / 0.75F + 1));

		final Iterator<Integer> it = deque.iterator();
		for (int i = 0; i < m; i++)
		{
			final int num = it.next();
			uniqueNumberCounts.merge(num, 1, Integer::sum);
		}

		int maxUniqueNumbers = uniqueNumberCounts.size();

		for (int i = m; i < n; i++)
		{
			final int numToRemove = deque.pollFirst();
			final int numToAdd = it.next();
			uniqueNumberCounts.compute(numToRemove, (ntr, count) -> count == 1 ? null : count-1);
			uniqueNumberCounts.merge(numToAdd, 1, Integer::sum);
			if (maxUniqueNumbers < uniqueNumberCounts.size())
				maxUniqueNumbers = uniqueNumberCounts.size();
		}

		System.out.println(maxUniqueNumbers);
	}

	/**
	 * My 2nd solution with complexity of {@code O(n) = n}, it's twice more optimal compared with {@link #solution1()}.
	 */
	public static void solution2()
	{
		final Scanner in = new Scanner(System.in);
		final Deque<Integer> deque = new ArrayDeque<>();
		final int n = in.nextInt();
		final int m = in.nextInt();

		final Map<Integer, Integer> uniqueNumberCounts = new HashMap<>((int)(m / 0.75F + 1));

		for (int i = 0; i < m; i++)
		{
			final int num = in.nextInt();
			deque.add(num);
			uniqueNumberCounts.merge(num, 1, Integer::sum);
		}

		int maxUniqueNumbers = uniqueNumberCounts.size();

		for (int i = m; i < n; i++)
		{
			final int numToRemove = deque.pollFirst();
			final int numToAdd = in.nextInt();
			deque.add(numToAdd);
			uniqueNumberCounts.compute(numToRemove, (ntr, count) -> count == 1 ? null : count-1);
			uniqueNumberCounts.merge(numToAdd, 1, Integer::sum);
			if (maxUniqueNumbers < uniqueNumberCounts.size())
				maxUniqueNumbers = uniqueNumberCounts.size();
		}

		System.out.println(maxUniqueNumbers);
	}
}
