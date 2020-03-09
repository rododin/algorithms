/*
 * JavaBigDecimalTest.java
 */

package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaBigDecimal}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaBigDecimalTest
{
	@Test
	public void test01()
	{
		final String[] initialArray = new String []
		{
			"9",
			"-100",
			"50",
			"0",
			"56.6",
			"90",
			"0.12",
			".12",
			"02.34",
			"000.000",
		};
		final String[] expectedSortedArray = new String []
		{
			"90",
			"56.6",
			"50",
			"9",
			"02.34",
			"0.12",
			".12",
			"0",
			"000.000",
			"-100",
		};

		JavaBigDecimal.printSortBigDecimals(initialArray); // the initial array is modified on sort
		Assert.assertArrayEquals(expectedSortedArray, initialArray);
	}
}
