package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaStack}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStackTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest
			( stringsToStringByLine
					(	"""
						{}()
						({()})
						{}(
						[]
						"""
					)
				, () -> JavaStack.main(null)
				, stringsToStringByLine
					(	"""
						true
						true
						false
						true
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
						[{()}]
						({[]})
						({)}
						[[
						}{
						"""
					)
				, () -> JavaStack.main(null)
				, stringsToStringByLine
					(	"""
						true
						true
						false
						false
						false
						"""
					)
			);
	}
}
