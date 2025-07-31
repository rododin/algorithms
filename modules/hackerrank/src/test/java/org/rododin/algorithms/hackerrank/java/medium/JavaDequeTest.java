package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaDeque}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaDequeTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest
			(stringsToStringByLine
					( """
						6 3
						5 3 5 2 3 2
						"""
					)
				, () -> JavaDeque.main(null)
				, "3"
			);
	}

	@Test
	public void test2()
	{
		doTest
			(stringsToStringByLine
					( """
						20 4
						5 3 5 2 3 2 7 8 8 8 7 5 9 1 1 0 0 1 9 7
						"""
					)
				, () -> JavaDeque.main(null)
				, "4"
			);
	}

	@Test
	public void test3()
	{
		doTest
			(stringsToStringByLine
					( """
						10 10
						1 2 3 4 5 6 7 8 9 0
						"""
					)
				, () -> JavaDeque.main(null)
				, "10"
			);
	}

	@Test
	public void test4()
	{
		doTest
			(stringsToStringByLine
					( """
						10 1
						1 2 3 4 5 6 7 8 9 0
						"""
					)
				, () -> JavaDeque.main(null)
				, "1"
			);
	}

	@Test
	public void test5()
	{
		doTest
			(stringsToStringByLine
					( """
						10 9
						1 1 1 1 1 1 1 1 1 1
						"""
					)
				, () -> JavaDeque.main(null)
				, "1"
			);
	}

	@Test
	public void test6()
	{
		doTest
			(stringsToStringByLine
					( """
						10 9
						1 1 1 1 1 1 1 1 1 9
						"""
					)
				, () -> JavaDeque.main(null)
				, "2"
			);
	}
}
