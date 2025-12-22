package org.rododin.algorithms.hackerrank.problem_solving.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link UtopianTree}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class UtopianTreeTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest
			(stringsToStringByLine
				( """
					3
					0
					1
					4
					"""
				)
				, () -> UtopianTree.main(null)
				, stringsToStringByLine
				( """
					1
					2
					7
					"""
				)
			);
	}

	@Test
	public void testAverage()
	{
		doTest
			(stringsToStringByLine
				( """
					15
					0
					1
					2
					3
					4
					5
					6
					7
					8
					9
					10
					11
					12
					13
					14
					"""
				)
				, () -> UtopianTree.main(null)
				, stringsToStringByLine
				( """
					1
					2
					3
					6
					7
					14
					15
					30
					31
					62
					63
					126
					127
					254
					255
					"""
				)
			);
	}
}
