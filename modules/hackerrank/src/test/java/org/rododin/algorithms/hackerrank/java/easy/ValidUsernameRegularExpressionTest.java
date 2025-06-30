package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link ValidUsernameRegularExpression}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class ValidUsernameRegularExpressionTest
	extends AbstractTest
{
	@Test
	public void testSimple()
	{
		doTest( stringsToStringByLine("8", "Julia", "Samantha", "Samantha_21", "1Samantha", "Samantha?10_2A", "JuliaZ007", "Julia@007", "_Julia007")
			, () -> ValidUsernameRegularExpression.main(null)
			, stringsToStringByLine("Invalid", "Valid", "Valid", "Invalid", "Invalid", "Valid", "Invalid", "Invalid")
		);
	}
}
