package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaAnnotations}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaAnnotationsTest
	extends AbstractTest
{
	/** Implements the basic test case from HackerRank. */
	@Test
	public void testSimple()
	{
		doTest
			(stringsToStringByLine
					( """
						3
						SENIOR 75
						JUNIOR 45
						SENIOR 40
						"""
					)
				, () -> JavaAnnotations.main(null)
				, stringsToStringByLine
					( """
						Senior Member
						Spend: 75
						Budget Left: 25
						Junior Member
						Spend: 45
						Budget Left: 5
						Senior Member
						Spend: 40
						Budget Left: 60
						"""
					)
			);
	}
}
