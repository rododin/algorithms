package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaBitSet}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaBitSetTest
	extends AbstractTest
{
	@Test
	public void testEmpty()
	{
		doTest
			( stringsToStringByLine
					(	"""
						0 1
						XOR 1 2
						"""
					)
				, () -> JavaBitSet.main(null)
				, stringsToStringByLine
					(	"""
						0 0
						"""
					)
			);
	}

	@Test
	public void testSimple()
	{
		doTest
			( stringsToStringByLine
					(	"""
						5 4
						AND 1 2
						SET 1 4
						FLIP 2 2
						OR 2 1
						"""
					)
				, () -> JavaBitSet.main(null)
				, stringsToStringByLine
					(	"""
						0 0
						1 0
						1 1
						1 2
						"""
					)
			);
	}

	@Test
	public void testMedium()
	{
		doTest
			( stringsToStringByLine
					(	"""
						946 19
						OR 2 1
						FLIP 1 918
						OR 2 1
						XOR 2 1
						AND 2 1
						XOR 2 1
						AND 2 1
						FLIP 1 537
						FLIP 2 874
						SET 1 586
						SET 1 785
						XOR 1 2
						XOR 1 2
						FLIP 2 57
						OR 2 1
						AND 2 1
						OR 2 1
						XOR 1 2
						AND 1 2
						"""
					)
				, () -> JavaBitSet.main(null)
				, stringsToStringByLine
					(	"""
						0 0
						1 0
						1 1
						1 0
						1 0
						1 1
						1 1
						2 1
						2 2
						3 2
						4 2
						4 2
						4 2
						4 3
						4 6
						4 4
						4 4
						0 4
						0 4
						"""
					)
			);
	}
}
