package org.rododin.algorithms.leetcode.problems;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 /**
 * Unit Test(s) for <code>{@link AddTwoNumbers}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AddTwoNumbersTest
{
	@Test
	public void testNulls()
	{
		final ListNode l1 = null;
		final ListNode l2 = null;
		final ListNode expected = null; // Both nulls give null in result
		doTest(l1, l2, expected);
	}

	@Test
	public void testOneNull()
	{
		final ListNode l1 = new ListNode(2, new ListNode(1));
		final ListNode l2 = null;
		final ListNode expected = new ListNode(2, new ListNode(1)); // One null is interpreted as 0
		doTest(l1, l2, expected);
	}

	@Test
	public void testZeros()
	{
		final ListNode l1 = new ListNode(0);
		final ListNode l2 = new ListNode(0);
		final ListNode expected = new ListNode(0);
		doTest(l1, l2, expected);
	}

	@Test
	public void testOneZero()
	{
		final ListNode l1 = new ListNode(1);
		final ListNode l2 = new ListNode(0);
		final ListNode expected = new ListNode(1);
		doTest(l1, l2, expected);
	}

	@Test
	public void testMinorNumbers()
	{
		final ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
		final ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
		final ListNode expected = new ListNode(7, new ListNode(0, new ListNode(8)));
		doTest(l1, l2, expected);
	}

	@Test
	public void testMediumNumbers()
	{
		final ListNode l1 = AddTwoNumbers.stringToListNode("54321");
		final ListNode l2 = AddTwoNumbers.stringToListNode("56789");
		final ListNode expected = AddTwoNumbers.stringToListNode("111110");
		doTest(l1, l2, expected);
	}

	@Test
	public void testMajorNumbers()
	{
		final ListNode l1 = AddTwoNumbers.stringToListNode("9999999999999999"); // 16 decimal places
		final ListNode l2 = AddTwoNumbers.stringToListNode("9999999999");       // 10 decimal places
		final ListNode expected = AddTwoNumbers.stringToListNode("10000009999999998");
		doTest(l1, l2, expected);
	}

	@Test
	public void testVeryMajorNumbers()
	{
		final String s1_100_decimal_places = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		final String s2_200_decimal_places = "99999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
		final BigInteger bi1 = new BigInteger(s1_100_decimal_places);
		final BigInteger bi2 = new BigInteger(s2_200_decimal_places);
		final BigInteger biExpected = bi1.add(bi2);
		final ListNode l1 = AddTwoNumbers.stringToListNode(s1_100_decimal_places);
		final ListNode l2 = AddTwoNumbers.stringToListNode(s2_200_decimal_places);
		final ListNode expected = AddTwoNumbers.stringToListNode(biExpected.toString());
		doTest(l1, l2, expected);
	}

	static void doTest(ListNode l1, ListNode l2, ListNode expected)
	{
		final ListNode result = new AddTwoNumbers().addTwoNumbers(l1, l2);
		Assertions.assertTrue(areListNodesEqual(expected, result));
		System.out.println( (l1     == null ? null : AddTwoNumbers.listNodeToString(l1    )) + " + "
		                  + (l2     == null ? null : AddTwoNumbers.listNodeToString(l2    )) + " = "
		                  + (result == null ? null : AddTwoNumbers.listNodeToString(result))
		                  );
	}

	static boolean areListNodesEqual(ListNode l1, ListNode l2)
	{
		for (; l1 != null && l2 != null; l1 = l1.next, l2 = l2.next)
		{
			if (l1.val != l2.val)
				return false;
		}
		return l1 == null && l2 == null;
	}
}
