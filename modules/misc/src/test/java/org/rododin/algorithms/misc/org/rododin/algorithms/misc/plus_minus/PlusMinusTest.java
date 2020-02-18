/*
 * PlusMinusTest.java
 */

package org.rododin.algorithms.misc.org.rododin.algorithms.misc.plus_minus;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.misc.plus_minus.PlusMinus;

/**
 * Unit Test(s) for <code>{@link PlusMinus}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class PlusMinusTest
{
	@Test
	public void test01()
	{
		Assert.assertArrayEquals(new double[]{0.4, 0.4, 0.2}, PlusMinus.plusMinus(new int[] {1, 1, 0, -1, -1}), 0.0001D);
	}

	@Test
	public void test02()
	{
		Assert.assertArrayEquals(new double[]{0.5, 0.375, 0.125}, PlusMinus.plusMinus(new int[] {-4, 3, -9, 0, 4, 1, -2, 8}), 0.0001D);
	}
}
