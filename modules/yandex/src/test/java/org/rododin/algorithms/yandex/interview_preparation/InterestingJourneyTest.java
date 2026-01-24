package org.rododin.algorithms.yandex.interview_preparation;

import org.junit.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * Unit Test(s) for <code>{@link InterestingJourney}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class InterestingJourneyTest
	extends AbstractTest
{
	@Test
	public void testSolution1()
	{
		doTest(
			stringsToStringByLine(
				"""
				2
				0 0
				2 2
				4
				1 2
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				1
				"""
			)
		);
	}

	@Test
	public void testSolution2()
	{
		doTest(
			stringsToStringByLine(
				"""
				4
				0 0
				2 0
				0 2
				2 2
				1
				1 4
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				-1
				"""
			)
		);
	}

	@Test
	public void testSolution3()
	{
		doTest(
			stringsToStringByLine(
				"""
				5
				0 0
				1 1
				2 2
				3 3
				4 4
				1
				1 5
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				-1
				"""
			)
		);
	}

	@Test
	public void testSolution4()
	{
		doTest(
			stringsToStringByLine(
				"""
				7
				0 0
				0 2
				2 2
				0 -2
				2 -2
				2 -1
				2 1
				2
				1 3
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				2
				"""
			)
		);
	}

	@Test
	public void testSolution5()
	{
		doTest(
			stringsToStringByLine(
				"""
				4
				0 0
				1 0
				0 1
				1 1
				2
				1 4
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				1
				"""
			)
		);
	}

	@Test
	public void testSolution6()
	{
		doTest(
			stringsToStringByLine(
				"""
				18
				0 0
				8 0
				2 1
				6 1
				4 2
				0 3
				8 3
				3 4
				5 4
				8 4
				1 5
				0 6
				6 6
				0 7
				4 7
				2 8
				7 8
				8 8
				3
				1 18
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				6
				"""
			)
		);
	}
	@Test

	public void testSolution7()
	{
		doTest(
			stringsToStringByLine(
				"""
				17
				0 0
				8 0
				2 1
				6 1
				4 2
				0 3
				8 3
				3 4
				5 4
				1 5
				0 6
				6 6
				0 7
				4 7
				2 8
				7 8
				8 8
				3
				7 17
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				7
				"""
			)
		);
	}

	@Test
	public void testSolution8()
	{
		doTest(
			stringsToStringByLine(
				"""
				2
				-1000000000 -1000000000
				1000000000 1000000000
				2000000000
				1 2
				"""
			),
			() -> InterestingJourney.main(null),
			stringsToStringByLine(
				"""
				-1
				"""
			)
		);
	}
}
