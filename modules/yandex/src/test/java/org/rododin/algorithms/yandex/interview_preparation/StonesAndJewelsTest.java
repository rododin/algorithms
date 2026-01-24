package org.rododin.algorithms.yandex.interview_preparation;

import org.junit.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * Unit Test(s) for <code>{@link StonesAndJewels}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class StonesAndJewelsTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest(
			stringsToStringByLine(
				"""
				ab
				aabbccd
				"""
			),
			() -> StonesAndJewels.main(null),
			stringsToStringByLine(
				"""
				4
				"""
			)
		);
	}

	@Test
	public void test2()
	{
		doTest(
			stringsToStringByLine(
				"""
				abcdefghijklmnopqrstuvwxyz
				aabbccdd
				"""
			),
			() -> StonesAndJewels.main(null),
			stringsToStringByLine(
				"""
				8
				"""
			)
		);
	}
}
