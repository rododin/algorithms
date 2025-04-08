package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaStringTokens}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStringTokensTest
	extends AbstractTest
{
	@Test
	public void simplestTaskTest()
	{
		doTest( "He is a very very good boy, isn't he?"
		      , () -> JavaStringTokens.main(null)
		      , stringArrayToStringByLine("10", "He", "is", "a", "very", "very", "good", "boy", "isn", "t", "he")
		      );
	}

	@Test
	public void trailingSpacesTest()
	{
		doTest( "           YES      leading spaces        are valid,    problemsetters are         evillllll"
		      , () -> JavaStringTokens.main(null)
		      , stringArrayToStringByLine("8", "YES", "leading", "spaces", "are", "valid", "problemsetters", "are", "evillllll")
		      );
	}
}
