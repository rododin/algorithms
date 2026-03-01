package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link LinkedListCycle}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class LinkedListCycleTest
{
	@Test
	public void test0()
	{
		Assert.assertFalse(new LinkedListCycle().hasCycle(null));
	}

	@Test
	public void test1()
	{
		Assert.assertFalse(new LinkedListCycle().hasCycle(new LinkedListCycle.ListNode(1)));
	}

	@Test
	public void test1SelfLinked()
	{
		Assert.assertTrue(new LinkedListCycle().hasCycle(new LinkedListCycle.ListNode(1, true)));
	}

	@Test
	public void testMinorCycled()
	{
		Assert.assertTrue(new LinkedListCycle().hasCycle(listOf(1, 0, 1, 2, 3, 4, 5)));
	}

	@Test
	public void testMinorNonCycled()
	{
		Assert.assertFalse(new LinkedListCycle().hasCycle(listOf(-1, 0, 1, 2, 3, 4, 5)));
	}

	private static LinkedListCycle.ListNode listOf(int cycleTo, int... values)
	{
		LinkedListCycle.ListNode rootNode = null;
		LinkedListCycle.ListNode cycleNode = null;
		LinkedListCycle.ListNode previousNode = null;
		for (int i = 0; i < values.length; i++)
		{
			LinkedListCycle.ListNode currentNode = new LinkedListCycle.ListNode(values[i]);
			if (rootNode == null)
				rootNode = currentNode;
			if (previousNode != null)
				previousNode.next = currentNode;
			previousNode = currentNode;
			if (i == cycleTo)
				cycleNode = currentNode;
		}
		if (cycleNode != null && previousNode != null)
			previousNode.next = cycleNode;
		return rootNode;
	}
}
