package org.rododin.algorithms.misc.ozon;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link MostFrequentArrayElements}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class MostFrequentArrayElementsTest
{
	@Test
	public void test0()
	{
		Assert.assertArrayEquals(new int[] {}, MostFrequentArrayElements.topK(new int[] {}, 1));
	}

	@Test
	public void test1()
	{
		Assert.assertArrayEquals(new int[] {1,3,4}, MostFrequentArrayElements.topK(new int[] {1,1,1,1,2,3,3,3,4,4}, 3));
	}

	@Test
	public void test2()
	{
		Assert.assertArrayEquals(new int[] {2,7,8}, MostFrequentArrayElements.topK(new int[] {1,2,4,5,1,2,4,3,3,4,3,7,8,7,7,7,7,7,7,7,8,8,8,8,8,8,2,2,2,2,2,2,2}, 3));
	}

	@Test
	public void test3()
	{
		Assert.assertArrayEquals(new int[] {1,2,3}, MostFrequentArrayElements.topK(new int[] {1,2,3,1,2,3,1,2,3,4}, 3));
	}
}
