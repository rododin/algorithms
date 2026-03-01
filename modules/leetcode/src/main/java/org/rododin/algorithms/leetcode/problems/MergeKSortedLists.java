package org.rododin.algorithms.leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * <a href="https://leetcode.com/problems/merge-k-sorted-lists/">
 *   LeetCode > Problems > Merge k sorted lists <sub>(hard)</sub>
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MergeKSortedLists
{
	public static class ListNode
	{
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode mergeKLists(ListNode[] lists)
	{
		ListNode root = null;
		ListNode lastMerged = null;
		while (true)
		{
			ListNode lastMinNode = null;
			int lastMinListIndex = -1;
			for (int i = 0; i < lists.length; i++)
			{
				final ListNode curNode = lists[i];
				if (curNode != null)
				{
					if (lastMinNode == null || lastMinNode.val > curNode.val)
					{
						lastMinNode = curNode;
						lastMinListIndex = i;
					}
					else if (lastMinNode.val == curNode.val)
					{
					}
				}
			}
			if (lastMinNode == null)
				break;
			if (lastMerged == null)
			{
				lastMerged = lastMinNode;
				root = lastMerged;
			}
			else
			{
				lastMerged.next = lastMinNode;
				lastMerged = lastMinNode;
			}
			lists[lastMinListIndex] = lastMinNode.next;
		}
		return root;
	}

	public ListNode mergeKLists2(ListNode[] lists)
	{
		//final ArrayList<ListNode> listNodes = new ArrayList<>(lists.length);
		//Collections.addAll(listNodes, lists);
		ListNode root = null;
		ListNode lastMerged = null;
		int listsLength = lists.length;
		while (true)
		{
			ListNode lastMinNode = null;
			int lastMinListIndex = -1;
			for (int i = 0; i < listsLength; i++)
			{
				final ListNode curNode = lists[i];
				if (curNode != null)
				{
					if (lastMinNode == null || lastMinNode.val > curNode.val)
					{
						lastMinNode = curNode;
						lastMinListIndex = i;
					}
					else if (lastMinNode.val == curNode.val)
					{
					}
				}
			}
			if (lastMinNode == null)
				break;
			if (lastMerged == null)
			{
				lastMerged = lastMinNode;
				root = lastMerged;
			}
			else
			{
				lastMerged.next = lastMinNode;
				lastMerged = lastMinNode;
			}
			lists[lastMinListIndex] = lastMinNode.next;
			if (lists[lastMinListIndex] == null)
			{
				if (lastMinListIndex + 1 < listsLength)
					System.arraycopy(lists, lastMinListIndex + 1, lists, lastMinListIndex, listsLength - lastMinListIndex - 1);
				listsLength--;
			}
		}
		return root;
	}

	public ListNode mergeKListsUsingHeap(ListNode[] lists)
	{
		final PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
		for (int i = 0; i < lists.length; i++)
		{
			ListNode node = lists[i];
			while (node != null)
			{
				pq.add(node);
				node = node.next;
			}
		}
		if (pq.isEmpty())
			return null;
		ListNode root = pq.poll();
		ListNode last = root;
		while (!pq.isEmpty())
		{
			ListNode node = pq.poll();
			last.next = node;
			last = node;
		}
		last.next = null;
		return root;
	}

	public static void main(String[] args)
	{
		final Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt(); // the number of lists
		final ListNode[] lists = new ListNode[n];
		for (int i = 0; i < n; i++)
		{
			int listSize = scanner.nextInt();
			ListNode list = new ListNode(scanner.nextInt());
			lists[i] = list;
			for (int j = 1; j < listSize; j++)
			{
				list.next = new ListNode(scanner.nextInt());
				list = list.next;
			}
		}

		//final ListNode mergedList = new MergeKSortedLists().mergeKLists(lists);
		final ListNode mergedList = new MergeKSortedLists().mergeKLists2(lists);
		//final ListNode mergedList = new MergeKSortedLists().mergeKListsUsingHeap(lists);

		String sep = "";
		ListNode list = mergedList;
		while (list != null)
		{
			System.out.print(sep + list.val);
			list = list.next;
			sep = " ";
		}
		System.out.println();
	}
}

