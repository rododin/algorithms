package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for {@link Java2DArray}.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Java2DArrayTest
	extends AbstractTest
{
	@Test
	public void testSample0()
	{
		doTest
		( stringsToStringByLine
			(	"""
				1 1 1 0 0 0
				0 1 0 0 0 0
				1 1 1 0 0 0
				0 0 0 0 0 0
				0 0 0 0 0 0
				0 0 0 0 0 0
				"""
			)
		, () -> Java2DArray.main(null)
		, stringsToStringByLine("7")
		);
	}

	@Test
	public void testSample1()
	{
		doTest
		( stringsToStringByLine
			(	"""
				1 1 1 0 0 0
				0 1 0 0 0 0
				1 1 1 0 0 0
				0 0 2 4 4 0
				0 0 0 2 0 0
				0 0 1 2 4 0
				"""
			)
		, () -> Java2DArray.main(null)
		, stringsToStringByLine("19")
		);
	}

	@Test
	public void testSample2()
	{
		doTest
		( stringsToStringByLine
			(	""" 
				 1  1  1  0  0  0
				 0  1  0  0  0  0
				 1  1  1  0  0  0
				 0  9  2 -4 -4  0
				 0  0  0 -2  0  0
				 0  0 -1 -2 -4  0
				"""
			)
		, () -> Java2DArray.main(null)
		, stringsToStringByLine("13")
		);
	}

	@Test
	public void testSample3()
	{
		doTest
		( stringsToStringByLine
			(	"""
				-1 -1  0 -9 -2 -2
				-2 -1 -6 -8 -2 -5
				-1 -1 -1 -2 -3 -4
				-1 -9 -2 -4 -4 -5
				-7 -3 -3 -2 -9 -9
				-1 -3 -1 -2 -4 -5
				"""
			)
		, () -> Java2DArray.main(null)
		, stringsToStringByLine("-6")
		);
	}
}
