package org.rododin.algorithms.leetcode.problems;

/**
 * <a href="https://leetcode.com/problems/reverse-linked-list/description/">
 *   LeetCode > Problems > Reverse Linked List <sub>(easy)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ReverseLinkedList
{
	public static class ListNode
	{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode reverseList(ListNode head)
	{
		ListNode prev = null;
		while (head != null)
		{
			ListNode tmp = head.next;
			head.next = prev;
			prev = head;
			head = tmp;
		}
		return prev;
	}
}
