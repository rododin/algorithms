package org.rododin.algorithms.yandex.interview_preparation;

import org.junit.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * Unit Test(s) for <code>{@link ConsecutiveUnits}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ConsecutiveUnitsTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest(
			stringsToStringByLine(
				"""
				5
				1
				0
				1
				0
				1
				"""
			),
			() -> ConsecutiveUnits.main(null),
			stringsToStringByLine(
				"""
				1
				"""
			)
		);
	}
}
