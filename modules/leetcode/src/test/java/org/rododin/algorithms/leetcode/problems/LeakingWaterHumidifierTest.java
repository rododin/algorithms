package org.rododin.algorithms.leetcode.problems;

import org.junit.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * TODO: Add description.
 */
public class LeakingWaterHumidifierTest
	extends AbstractTest
{
	@Test
	public void testSample0()
	{
		doTest(
			stringsToStringByLine(
				"""
				4
				1 3
				3 1
				4 4
				7 1
				"""
			)
			, () -> LeakingWaterHumidifier.main(null)
			, stringsToStringByLine("3")
		);
	}

	@Test
	public void testSample1()
	{
		doTest(
			stringsToStringByLine(
				"""
				3
				1 8
				10 11
				21 5
				"""
			)
			, () -> LeakingWaterHumidifier.main(null)
			, stringsToStringByLine("5")
		);
	}

	@Test
	public void testSample3()
	{
		doTest(
			stringsToStringByLine(
				"""
				10
				2 1
				22 10
				26 17
				29 2
				45 20
				47 32
				72 12
				75 1
				81 31
				97 7
				"""
			)
			, () -> LeakingWaterHumidifier.main(null)
			, stringsToStringByLine("57")
		);
	}
}
