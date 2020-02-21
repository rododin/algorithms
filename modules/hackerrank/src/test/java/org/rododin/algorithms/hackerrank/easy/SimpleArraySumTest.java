/*
 * SimpleArraySumTest.java
 */

package org.rododin.algorithms.hackerrank.easy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.Constants;
import org.rododin.algorithms.file.FileUtils;

/**
 * Unit Test(s) for <code>{@link SimpleArraySum}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SimpleArraySumTest
	implements Constants
{
	@Test
	public void test01()
	{
		doTest("org.rododin.algorithms.hackerrank.easy/simple_array_sum_01.txt");
	}

	@Test
	public void test02()
	{
		doTest("org.rododin.algorithms.hackerrank.easy/simple_array_sum_02.txt");
	}

	private static void doTest(String resourceFilePath)
	{
		final Iterator<String> it = FileUtils.readResourceByLine(resourceFilePath).iterator();
		final int arraySize = it.hasNext() ? Integer.parseInt(it.next()) : 0;
		final Stream<String> strStream = Arrays.stream(it.hasNext() ? it.next().split(" ") : new String[0])
		                                       .limit(arraySize)
		                                       .map(String::trim);
		final int expectedSum = it.hasNext() ? Integer.parseInt(it.next()) : 0;

		final int computedSum = SimpleArraySum.sumS(strStream);

		Assert.assertEquals(expectedSum, computedSum);
	}
}
