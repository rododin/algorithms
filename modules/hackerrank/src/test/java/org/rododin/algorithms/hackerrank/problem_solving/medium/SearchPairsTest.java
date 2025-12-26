package org.rododin.algorithms.hackerrank.problem_solving.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link SearchPairs}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class SearchPairsTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest
			( stringsToStringByLine
				( """
					5 2
					1 5 3 4 2
					"""
				)
			, () -> SearchPairs.main(null)
			, "3"
			);
	}
}
