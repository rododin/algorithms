/*
 * CompareTripletsTest.java
 */

package org.rododin.algorithms.hackerrank.easy;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link CompareTriplets}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CompareTripletsTest
{
	@Test
	public void test01()
	{
		Assert.assertEquals( Arrays.asList(1, 1)
		                   , CompareTriplets.compareTriplets(Arrays.asList(5, 6, 7), Arrays.asList(3, 6, 10))
		                   );
	}

	@Test
	public void test02()
	{
		Assert.assertEquals( Arrays.asList(2, 1)
		                   , CompareTriplets.compareTriplets(Arrays.asList(17, 28, 30), Arrays.asList(99, 16, 8))
		                   );
	}
}
