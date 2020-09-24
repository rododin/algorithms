package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link InsertionSortPart1}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class InsertionSortPart1Test
{
	@Test
	public void testCornerCases()
	{
		doTest("TEST CORNER CASES 0",
		       new int[] {}, Arrays.asList());

		doTest("TEST CORNER CASES 1",
		       new int[] {1}, Arrays.asList(
		       new int[] {1}
		      ));
	}

	@Test
	public void test1()
	{
		doTest("TEST-1",
		       new int[] {1, 2, 4, 5, 3}, Arrays.asList(
		       new int[] {1, 2, 4, 5, 5},
		       new int[] {1, 2, 4, 4, 5},
		       new int[] {1, 2, 3, 4, 5}
		      ));
	}

	@Test
	public void test2()
	{
		doTest("TEST-2",
		       new int[] {2, 4, 6, 8, 3}, Arrays.asList(
		       new int[] {2, 4, 6, 8, 8},
		       new int[] {2, 4, 6, 6, 8},
		       new int[] {2, 4, 4, 6, 8},
		       new int[] {2, 3, 4, 6, 8}
		      ));
	}

	@Test
	public void test3()
	{
		doTest("TEST-3",
		       new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 1}, Arrays.asList(
		       new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 10},
		       new int[] {2, 3, 4, 5, 6, 7, 8, 9, 9, 10},
		       new int[] {2, 3, 4, 5, 6, 7, 8, 8, 9, 10},
		       new int[] {2, 3, 4, 5, 6, 7, 7, 8, 9, 10},
		       new int[] {2, 3, 4, 5, 6, 6, 7, 8, 9, 10},
		       new int[] {2, 3, 4, 5, 5, 6, 7, 8, 9, 10},
		       new int[] {2, 3, 4, 4, 5, 6, 7, 8, 9, 10},
		       new int[] {2, 3, 3, 4, 5, 6, 7, 8, 9, 10},
		       new int[] {2, 2, 3, 4, 5, 6, 7, 8, 9, 10},
		       new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		      ));
	}

	@Test
	public void test4()
	{
		doTest("TEST-4",
		       new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, Arrays.asList(
		       new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
		      ));
	}

	public void doTest(String testName, int[] given, List<int[]> expected)
	{
		System.out.println("\n== " + getClass().getSimpleName() + "." + testName + " =====\n");
		System.out.println("GIVEN:");
		System.out.print("      ");
		InsertionSortPart1.println(given);
		final List<int[]> computed = new ArrayList<>();
		InsertionSortPart1.insertionSort1(given.length, given, a -> {
			final int[] copied = new int[a.length];
			System.arraycopy(a, 0, copied, 0, a.length);
			computed.add(copied);
		});
		Assert.assertEquals(expected.size(), computed.size());
		System.out.println("COMPUTED:");
		for (int i = 0; i < expected.size(); i++)
		{
			try
			{
				Assert.assertArrayEquals(expected.get(i), computed.get(i));
				System.out.print("  OK: ");
				InsertionSortPart1.println(computed.get(i));
			}
			catch (Throwable t)
			{
				System.out.print("  ERROR   : ");
				InsertionSortPart1.println(computed.get(i));
				System.out.print("  EXPECTED: ");
				InsertionSortPart1.println(expected.get(i));
				throw t;
			}
		}
	}
}
