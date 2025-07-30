package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaComparator}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaComparatorTest
	extends AbstractTest
{
	@Test
	public void test1()
	{
		doTest
			(stringsToStringByLine
					( """
						5
						amy 100
						david 100
						heraldo 50
						aakansha 75
						aleksa 150
						"""
					)
				, () -> JavaComparator.main(null)
				, stringsToStringByLine
					( """
						aleksa 150
						amy 100
						david 100
						aakansha 75
						heraldo 50
						"""
					)
			);
	}
}
