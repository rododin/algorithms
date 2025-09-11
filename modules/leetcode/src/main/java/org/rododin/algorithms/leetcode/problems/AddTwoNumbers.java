package org.rododin.algorithms.leetcode.problems;

import java.math.BigInteger;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">
 *   LeetCode > Problems > Add Two numbers <sub>(medium)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AddTwoNumbers
{
	/**
	 * Computes the summary of 2 numbers represented by the {@code l1} and {@code l2} {@link ListNode} chains appropriately.
	 * <p>NOTE: The signature of the method precisely repeats the one defined on LettCode, despite generally the method could be defined {@code static}.
	 * <p>NOTE: The result of addition of two {@code null}s is also {@code null}.
	 *          If only one of the numbers is {@code null}, it's interpreted as {@code 0}, i.e. the other one is returned.
	 * <p>NOTE: Generally the algorithm is unlimited by the length of the numbers, i.e. it should work well even for
	 *          enormously large numbers with thousands or even millions of decimal places, however we didn't test it.
	 *
	 * @param l1 the number 1, nullable, the head node refers the least-significant decimal place of the number
	 * @param l2 the number 2, nullable, the head node refers the least-significant decimal place of the number
	 * @return the summary of the numbers {@code l1} and {@code l2}, or {@code null} if both numbers are {@code null}s,
	 *         the returned result is ordered the same as the numbers (the head refers the least-significant decimal place)
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2)
	{
		return addTwoNumbersVersion3MostOptimal(l1, l2);
	}

	/**
	 * Version 3 of the algorithm.
	 * It's probably most long by line numbers, but should be most optimal even compared
	 * with {@link #addTwoNumbersVersion2Fast(ListNode, ListNode) version 2} because avoids duplicated checks in the loop.
	 * <p>
	 * The computation complexity of this algorithm version is {@code O(n+1)},
	 * where {@code n} is the maximal number of decimal places in the numbers.
	 */
	private static ListNode addTwoNumbersVersion3MostOptimal(ListNode l1, ListNode l2)
	{
		ListNode result = null;
		ListNode lastAssigned = null;
		int nextInc = 0;
		boolean doMoreJob;
		while (true)
		{
			doMoreJob = false;
			int curSum = nextInc;
			if (l1 != null)
			{
				curSum += l1.val;
				l1 = l1.next;
				doMoreJob = true;
			}
			if (l2 != null)
			{
				curSum += l2.val;
				l2 = l2.next;
				doMoreJob = true;
			}
			if (doMoreJob || nextInc > 0)
			{
				if (curSum > 9)
				{
					curSum %= 10;
					nextInc = 1;
				}
				else
					nextInc = 0;
				if (lastAssigned == null)
				{
					lastAssigned = new ListNode(curSum);
					result = lastAssigned;
				}
				else
				{
					lastAssigned.next = new ListNode(curSum);
					lastAssigned = lastAssigned.next;
				}
			}
			else
				break;
		}
		return result;
	}

	/**
	 * Version 2 of the algorithm.
	 * It works much faster compared with the {@link #addTwoNumbersVersion1Slow(ListNode, ListNode) version 1}
	 * by direct implementation of the mathematical decimal place-wise addition algorithm (well known as "column addition"),
	 * and thus totally avoids any conversion to/from {@link String}s and {@link BigInteger}s.
	 * <p>
	 * The computation complexity of this algorithm version is {@code O(n+1)},
	 * where {@code n} is the maximal number of decimal places in the numbers. Thus, it's about 8 times
	 * faster compared with the {@link #addTwoNumbersVersion1Slow(ListNode, ListNode) version 1}.
	 *
	 * @see #addTwoNumbersVersion3MostOptimal(ListNode, ListNode)
	 */
	private static ListNode addTwoNumbersVersion2Fast(ListNode l1, ListNode l2)
	{
		ListNode result = null;
		ListNode lastAssigned = null;
		int nextInc = 0;
		for (; l1 != null || l2 != null || nextInc != 0; l1 = l1 != null ? l1.next : null, l2 = l2 != null ? l2.next : null)
		{
			int curSum = nextInc;
			if (l1 != null) curSum += l1.val;
			if (l2 != null) curSum += l2.val;
			if (curSum > 9)
			{
				curSum %= 10;
				nextInc = 1;
			}
			else
				nextInc = 0;
			if (lastAssigned == null)
			{
				lastAssigned = new ListNode(curSum);
				result = lastAssigned;
			}
			else
			{
				lastAssigned.next = new ListNode(curSum);
				lastAssigned = lastAssigned.next;
			}
		}
		return result;
	}

	/**
	 * Version 1 of the algorithm.
	 * It works pretty slowly, but looks most simple from view point of implementation, i.e. it's a typical brutal implementation.
	 * So, to do the job it converts the given numbers {@code l1} and {@code l2} to {@link String}s first,
	 * then it converts the {@link String}s to {@link BigInteger}s, then it performs the addition operation for the two
	 * {@link BigInteger} instances using {@link BigInteger#add(BigInteger)} operation, and finally it converts the result
	 * back to {@link String} and then to {@link ListNode} chain.
	 * Additionally, it also uses {@link StringBuilder#reverse()} operation internally for the {@link #listNodeToString(ListNode head)} operation.
	 * <p>
	 * Thus, it's hard to estimate the computation complexity of this algorithm version precisely, but
	 * we expect it should be at least about {@code O(8×n)}, where {@code n} is the number of decimal places in the numbers
	 * (for each number it may vary of course, and thus often the computation complexity is something less than when
	 * {@code n} is the same for both numbers). The number {@code 8} consists of: {@code 2} operations of converting numbers to
	 * {@link String}s + {@code 2×0.5} string reverse operations + {@code 2} operations of converting {@link String}s
	 * to {@link BigInteger}s + the main addition operation + {@code 1} operation of converting the result {@link BigInteger} to
	 * {@link String} + {@code 1} operation of converting the {@code result} {@link String} to the {@code LinkNode} chain.
	 *
	 * @see #addTwoNumbersVersion2Fast(ListNode, ListNode)
	 * @see #addTwoNumbersVersion3MostOptimal(ListNode, ListNode)
	 */
	private static ListNode addTwoNumbersVersion1Slow(ListNode l1, ListNode l2)
	{
		if (l1 == null)
			return l2;
		else if (l2 == null)
			return l1;
		final BigInteger n1 = new BigInteger(listNodeToString(l1));
		final BigInteger n2 = new BigInteger(listNodeToString(l2));
		final BigInteger sum = n1.add(n2);
		return stringToListNode(sum.toString());
	}

	public static String listNodeToString(ListNode head)
	{
		final StringBuilder sb = new StringBuilder();
		for (ListNode cur = head; cur != null; cur = cur.next)
			sb.append(cur.val);
		return sb.reverse().toString();
	}

	public static ListNode stringToListNode(String val)
	{
		ListNode head = null;
		for (char c : val.toCharArray())
			head = new ListNode(c - '0', head);
		return head;
	}
}

class ListNode
{
	int val;
	ListNode next;

	ListNode()
	{
	}

	ListNode(int val)
	{
		this.val = val;
	}

	ListNode(int val, ListNode next)
	{
		this.val = val;
		this.next = next;
	}
}
