package org.rododin.algorithms.data_structures;

/**
 * Implements a simple sortable stack (sorted not on insertion automatically, but on demand)
 * with simple {@link #isEmpty()}, {@link #push(Comparable)}, {@link #peek()} and {@link #pop()} operations.
 * <p>
 * Also introduces the {@link #sort()} operation (with the <code>O(N<sup>2</sup>)</code> complexity) to be applied on demand.
 * <p>
 * It implements the <b><i>Task 3.5</i></b> from the book
 * <b><i>"Cracking the Coding Interview"</i></b>, <b><i>Chapter 3</i></b> of <b><i>G. Laakmann McDowell</i></b>.
 *
 * @author Nikolay Chebotaryov
 */
public class SortableStack<T extends Comparable<T>>
{
	private static class Node<T>
	{
		T element;
		Node<T> previous;

		public Node(T element, Node<T> previous)
		{
			this.element = element;
			this.previous = previous;
		}
	}

	private Node<T> top;

	public SortableStack()
	{
		this.top = null;
	}

	public boolean isEmpty()
	{
		return top == null;
	}

	public void push(T element)
	{
		top = new Node<>(element, top);
	}

	public T peek()
	{
		return top == null ? null : top.element;
	}

	public T pop()
	{
		if (top == null)
			return null;

		final T rv = top.element;
		top = top.previous;
		return rv;
	}

	public void sort()
	{
		for (Node<T> current = top; current != null; current = current.previous)
		{
			for (Node<T> previous = current.previous; previous != null; previous = previous.previous)
			{
				if (previous.element == null || (current.element != null && current.element.compareTo(previous.element) > 0))
				{
					final T temp = current.element;
					current.element = previous.element;
					previous.element = temp;
				}
			}
		}
	}

	@Override
	public String toString()
	{
		final StringBuilder rv = new StringBuilder(getClass().getSimpleName());
		rv.append('[');
		for (Node<T> current = top; current != null; current = current.previous)
			rv.append(current.element).append(',');
		if (rv.charAt(rv.length()-1) == ',')
			rv.deleteCharAt(rv.length()-1);
		rv.append(']');
		return rv.toString();
	}
}
