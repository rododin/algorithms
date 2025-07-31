package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaSortTest}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaSortTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest
			(stringsToStringByLine
					( """
						5
						33 Rumpa 3.68
						85 Ashis 3.85
						56 Samiha 3.75
						19 Samara 3.75
						22 Fahim 3.76
						"""
					)
				, () -> JavaSort.main(null)
				, stringsToStringByLine
					( """
						Ashis
						Fahim
						Samara
						Samiha
						Rumpa
						"""
					)
			);
	}
}
