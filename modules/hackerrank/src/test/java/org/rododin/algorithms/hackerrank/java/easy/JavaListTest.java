package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaList}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaListTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest
			( stringsToStringByLine
					(	"""
						5
						12 0 1 78 12
						2
						Insert
						5 23
						Delete
						0
						"""
					)
				, () -> JavaList.main(null)
				, stringsToStringByLine
					(	"""
						0 1 78 12 23
						"""
					)
			);
	}

}
