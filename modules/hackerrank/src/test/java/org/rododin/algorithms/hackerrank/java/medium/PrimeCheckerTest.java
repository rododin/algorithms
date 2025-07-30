package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link PrimeChecker}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class PrimeCheckerTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest
			( stringsToStringByLine
					(	"""
						2
						1
						3
						4
						5
						"""
					)
				, () -> PrimeChecker.main(null)
				, stringsToStringByLine
					(	"""
						2
						2
						2 3
						2 3 5
						"""
					)
			);
	}

	@Test
	public void test2()
	{
		doTest
			( stringsToStringByLine
					(	"""
						17
						19
						31
						49
						97
						"""
					)
				, () -> PrimeChecker.main(null)
				, stringsToStringByLine
					(	"""
						17
						17 19
						17 19 31
						17 19 31 97
						"""
					)
			);
	}

	@Test
	public void test3()
	{
		doTest
			( stringsToStringByLine
					(	"""
						2
						2
						2
						2
						2
						"""
					)
				, () -> PrimeChecker.main(null)
				, stringsToStringByLine
					(	"""
						2
						2 2
						2 2 2
						2 2 2 2 2
						"""
					)
			);
	}

	@Test
	public void test4()
	{
		doTest
			( stringsToStringByLine
					(	"""
						1
						4
						6
						8
						12
						"""
					)
				, () -> PrimeChecker.main(null)
				, stringsToStringByLine
					(	"""
						
						
						
						
						"""
					)
			);
	}
}
