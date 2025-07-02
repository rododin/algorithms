package org.rododin.algorithms.hackerrank.java.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * <a href="https://www.hackerrank.com/challenges/java-2d-array/problem">
 *   HackerRank > Prepare > Java > Data Structures > Java 2D Array
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Java2DArray
{
	public static void main(String[] args)
	{
		try (final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)))
		{
			final List<List<Integer>> arr = new ArrayList<>();
			IntStream.range(0, 6).forEach(i ->
			{
				try
				{
					arr.add(Stream.of(bufferedReader.readLine().replaceAll("^\\s+|\\s+$", "").split("\\s+"))
					              .map(Integer::parseInt)
					              .collect(toList()));
				}
				catch (IOException x)
				{
					throw new RuntimeException(x);
				}
			});
			System.out.println(computeMaxHourglass3x3Sum(arr));
		}
		catch (Exception x)
		{
			x.printStackTrace();
		}
	}

	/**
	 * The following method implements the main task of problem as defined in the problem definition.
	 * <p>NOTE: The following method does NOT provide a unified algorithm which can be easily applicable for
	 *          any size of the hourglass. Our task doesn't require a unified solution, so it should be enough here.
	 *          Thus, it's very primitive but applicable for exactly the {@code 3×3} hourglasses only,
	 *          however I decided to do it such way as it's the simplest for reading and most effective. The given
	 *          {@code matrix} can be any size though, not {@code 6×6} only as defined in the problem conditions,
	 *          it can be even a non-square matrix. And thus, the computation complexity of the algorithm is precisely
	 *          {@code O((m-2)×(n-2))} where {@code m} and {@code n} define the dimension of the rectangle {@code matrix}.
	 *          More unified algorithm would formally cause higher complexity which would be
	 *          <code>O((m-2)×(n-2)×k²)</code> where {@code k} is the dimension of the square hourglass.
	 */
	private static int computeMaxHourglass3x3Sum(List<List<Integer>> matrix)
	{
		int maxSum = Integer.MIN_VALUE;
		for (int i = 0; i < matrix.size() - 2; i++)
		{
			int curSum = 0;
			final List<Integer> row0 = matrix.get(i);
			final List<Integer> row1 = matrix.get(i + 1);
			final List<Integer> row2 = matrix.get(i + 2);
			for(int j = 0; j < row0.size() - 2; j++)
			{
				curSum += row0.get(j) + row0.get(j + 1) + row0.get(j + 2)
				                      + row1.get(j + 1)
				       +  row2.get(j) + row2.get(j + 1) + row2.get(j + 2);
				if (maxSum < curSum)
					maxSum = curSum;
				curSum = 0;
			}
		}
		return maxSum;
	}
}
