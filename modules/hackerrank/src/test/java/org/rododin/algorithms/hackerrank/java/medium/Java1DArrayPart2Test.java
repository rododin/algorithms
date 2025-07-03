package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for {@link Java1DArrayPart2}.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Java1DArrayPart2Test
	extends AbstractTest
{
	@Test
	public void testSample()
	{
		doTest
			( stringsToStringByLine
				(	"""
					4
					5 3
					0 0 0 0 0
					6 5
					0 0 0 1 1 1
					6 3
					0 0 1 1 1 0
					3 1
					0 1 0
					"""
				)
			, () -> Java1DArrayPart2.main(null)
			, stringsToStringByLine
				(	"""
					YES
					YES
					NO
					NO
					"""
				)
			);
	}
}
