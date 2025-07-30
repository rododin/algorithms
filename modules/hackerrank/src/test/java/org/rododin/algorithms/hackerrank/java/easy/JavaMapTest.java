package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaMap}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaMapTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest
			( stringsToStringByLine
					(	"""
						3
						uncle sam
						99912222
						tom
						11122222
						harry
						12299933
						uncle sam
						uncle tom
						harry
						"""
					)
				, () -> JavaMap.main(null)
				, stringsToStringByLine
					(	"""
						uncle sam=99912222
						Not found
						harry=12299933
						"""
					)
			);
	}
}
