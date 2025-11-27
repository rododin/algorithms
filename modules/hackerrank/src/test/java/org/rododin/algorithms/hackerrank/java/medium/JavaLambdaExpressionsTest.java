package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaLambdaExpressions}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaLambdaExpressionsTest
	extends AbstractTest
{
	/** Implements the basic test case from HackerRank. */
	@Test
	public void testSimple()
	{
		doTest
			( stringsToStringByLine
					(	"""
						5
						1 4
						2 5
						3 898
						1 3
						2 12
						"""
					)
				, () -> { try { JavaLambdaExpressions.main(null); } catch (Exception x) { throw new RuntimeException(x); } }
				, stringsToStringByLine
					(	"""
						EVEN
						PRIME
						PALINDROME
						ODD
						COMPOSITE
						"""
					)
			);
	}
}
