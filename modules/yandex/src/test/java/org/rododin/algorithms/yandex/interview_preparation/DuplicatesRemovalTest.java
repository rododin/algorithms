package org.rododin.algorithms.yandex.interview_preparation;

import org.junit.jupiter.api.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * Unit Test(s) for <code>{@link DuplicatesRemoval}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class DuplicatesRemovalTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest(
			stringsToStringByLine(
				"""
				5
				2
				4
				8
				8
				8
				"""
			),
			() -> DuplicatesRemoval.main(null),
			stringsToStringByLine(
				"""
				2
				4
				8
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
				5
				2
				2
				2
				8
				8
				"""
			),
			() -> DuplicatesRemoval.main(null),
			stringsToStringByLine(
				"""
				2
				8
				"""
			)
		);
	}
}
