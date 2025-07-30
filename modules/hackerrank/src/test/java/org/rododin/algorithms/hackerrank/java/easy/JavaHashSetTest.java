package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaHashSet}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaHashSetTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest
			( stringsToStringByLine
					(	"""
						5
						john tom
						john mary
						john tom
						mary anna
						mary anna
						"""
					)
				, () -> JavaHashSet.main(null)
				, stringsToStringByLine
					(	"""
						1
						2
						2
						3
						3
						"""
					)
			);
	}

	@Test
	public void test5()
	{
		doTest( "org/rododin/algorithms/hackerrank/java/easy/java-hash-set-test5-input.txt"
		      , "org/rododin/algorithms/hackerrank/java/easy/java-hash-set-test5-output.txt"
		      , () -> JavaHashSet.main(null)
		      );
	}
}
