package org.rododin.algorithms.leetcode.problems;

import org.junit.Assert;
import org.junit.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * TODO: Add description.
 */
public class MaximizeNumberTest
	extends AbstractTest
{
	@Test
	public void testSample0()
	{
		doTest(
			stringsToStringByLine(
				"""
				2
				1
				"""
			)
			, () -> MaximizeNumber.main(null)
			, stringsToStringByLine("2")
		);
	}

	@Test
	public void testSample1()
	{
		doTest(
			stringsToStringByLine(
				"""
				123
				456
				"""
			)
			, () -> MaximizeNumber.main(null)
			, stringsToStringByLine("654")
		);
	}

	@Test
	public void testSample2()
	{
		doTest(
			stringsToStringByLine(
				"""
				12115
				522
				"""
			)
			, () -> MaximizeNumber.main(null)
			, stringsToStringByLine("52225")
		);
	}

}
