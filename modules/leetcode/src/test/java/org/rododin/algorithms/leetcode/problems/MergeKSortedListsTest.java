package org.rododin.algorithms.leetcode.problems;

import org.junit.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * Unit Test(s) for <code>{@link MergeKSortedLists}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MergeKSortedListsTest
	extends AbstractTest
{
	@Test
	public void test0()
	{
		doTest(
			stringsToStringByLine(
				"""
				0
				"""
			),
			() -> MergeKSortedLists.main(null),
			stringsToStringByLine(
				"""
				"""
			)
		);
	}

	@Test
	public void test1()
	{
		doTest(
			stringsToStringByLine(
				"""
				1
				3 1 2 3
				"""
			),
			() -> MergeKSortedLists.main(null),
			stringsToStringByLine(
				"""
				1 2 3
				"""
			)
		);
	}

	@Test
	public void test2()
	{
		doTest(
			stringsToStringByLine(
				"""
				2
				3 1 2 3
				4 1 2 3 4
				"""
			),
			() -> MergeKSortedLists.main(null),
			stringsToStringByLine(
				"""
				1 1 2 2 3 3 4
				"""
			)
		);
	}

	@Test
	public void test5()
	{
		doTest(
			stringsToStringByLine(
				"""
				5
				1 2
				4 5 7 10 11
				4 3 7 11 12
				3 4 8 9
				2 2 3
				"""
			),
			() -> MergeKSortedLists.main(null),
			stringsToStringByLine(
				"""
				2 2 3 3 4 5 7 7 8 9 10 11 11 12
				"""
			)
		);
	}
}
