package org.rododin.algorithms.data_structures;

import org.junit.Assert;
import org.junit.Test;

/**
 * A set of unit tests for {@link SortableStack}.
 * @author Nikolay Chebotaryov
 */
public class SortableStackTest
{
	@Test
	public void testPush()
	{
		final SortableStack<Integer> stack = new SortableStack<>();
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[]", stack.toString());
		stack.push(3);
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[3]", stack.toString());
		stack.push(5);
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[5,3]", stack.toString());
		stack.push(1);
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[1,5,3]", stack.toString());
	}

	@Test
	public void testPeek()
	{
		final SortableStack<Integer> stack = new SortableStack<>();
		stack.push(3);
		stack.peek();
		Assert.assertEquals(Integer.valueOf(3), stack.peek());
		stack.push(5);
		Assert.assertEquals(Integer.valueOf(5), stack.peek());
		stack.push(1);
		Assert.assertEquals(Integer.valueOf(1), stack.peek());
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[1,5,3]", stack.toString());
	}

	@Test
	public void testPop1()
	{
		final SortableStack<Integer> stack = new SortableStack<>();
		stack.push(3);
		Assert.assertEquals(Integer.valueOf(3), stack.pop());
		stack.push(5);
		Assert.assertEquals(Integer.valueOf(5), stack.pop());
		stack.push(1);
		Assert.assertEquals(Integer.valueOf(1), stack.pop());
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[]", stack.toString());
	}

	@Test
	public void testPop2()
	{
		final SortableStack<Integer> stack = new SortableStack<>();
		stack.push(3);
		stack.push(5);
		Assert.assertEquals(Integer.valueOf(5), stack.pop());
		stack.push(1);
		stack.push(7);
		stack.push(4);
		Assert.assertEquals(Integer.valueOf(4), stack.pop());
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[7,1,3]", stack.toString());
	}

	@Test
	public void testIsEmpty()
	{
		final SortableStack<Integer> stack = new SortableStack<>();
		Assert.assertTrue(stack.isEmpty());
		stack.push(3);
		Assert.assertFalse(stack.isEmpty());
		stack.push(5);
		stack.push(1);
		Assert.assertFalse(stack.isEmpty());
		stack.pop();
		stack.pop();
		Assert.assertFalse(stack.isEmpty());
		stack.pop();
		Assert.assertTrue(stack.isEmpty());
	}

	@Test
	public void testSort()
	{
		final SortableStack<Integer> stack = new SortableStack<>();
		stack.push(null);
		stack.push(3);
		stack.push(5);
		stack.push(1);
		stack.push(7);
		stack.push(4);
		stack.push(9);
		stack.push(8);
		stack.push(2);
		stack.push(null);
		stack.push(6);
		stack.push(0);
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[0,6,null,2,8,9,4,7,1,5,3,null]", stack.toString());
		stack.sort();
		Assert.assertEquals(SortableStack.class.getSimpleName() + "[null,null,0,1,2,3,4,5,6,7,8,9]", stack.toString());
	}
}
