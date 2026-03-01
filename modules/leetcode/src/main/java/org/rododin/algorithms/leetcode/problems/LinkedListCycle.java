package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/linked-list-cycle/">
 *   LeetCode > Problems > Linked List Cycle <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class LinkedListCycle
{
	public static class ListNode
	{
		int val;
		ListNode next;

		ListNode(int val)
		{
			this (val, null);
		}

		ListNode(int val, ListNode next)
		{
			this.val = val;
			this.next = next;
		}

		ListNode(int val, boolean selfLinked)
		{
			this.val = val;
			this.next = selfLinked ? this : null;
		}
  }

	public boolean hasCycle(ListNode head)
	{
		if (head == null)
			return false;

		ListNode slow = head;
		ListNode fast = head;
		do
		{
			slow = slow.next;
			if (slow == null)
				return false;
			if (fast.next == null)
				return false;
			fast = fast.next.next;
			if (fast == null)
				return false;
		} while (fast != slow);

		return true;
	}
}
