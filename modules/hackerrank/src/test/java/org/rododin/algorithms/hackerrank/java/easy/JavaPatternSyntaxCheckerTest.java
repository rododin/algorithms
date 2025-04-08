package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaPatternSyntaxChecker}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaPatternSyntaxCheckerTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest( stringsToStringByLine("3", "([A-Z])(.+)", "[AZ[a-z](a-z)", "batcatpat(nat")
		      , () -> JavaPatternSyntaxChecker.main(null)
		      , stringsToStringByLine("Valid", "Invalid", "Invalid")
		);
	}
}
