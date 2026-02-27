package org.rododin.algorithms.yandex.interview_preparation;

import org.junit.jupiter.api.Test;
import org.rododin.algorithms.tests.AbstractTest;

/**
 * Unit Test(s) for <code>{@link Anagrams}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class AnagramsTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest(
			stringsToStringByLine(
				"""
				qiu
				iuq
				"""
			),
			() -> Anagrams.main(null),
			stringsToStringByLine(
				"""
				1
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
				zprl
				zprc
				"""
			),
			() -> Anagrams.main(null),
			stringsToStringByLine(
				"""
				0
				"""
			)
		);
	}
}
