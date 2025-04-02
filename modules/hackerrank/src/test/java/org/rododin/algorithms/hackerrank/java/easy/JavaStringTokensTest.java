package org.rododin.algorithms.hackerrank.java.easy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaStringTokens}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaStringTokensTest
{
	@Test
	public void simplestTaskTest()
	{
		doTest( "He is a very very good boy, isn't he?"
		      , stringArrayToStringByLine(new String[] {"10", "He", "is", "a", "very", "very", "good", "boy", "isn", "t", "he"})
		      );
	}

	@Test
	public void trailingSpacesTest()
	{
		doTest( "           YES      leading spaces        are valid,    problemsetters are         evillllll"
		      , stringArrayToStringByLine(new String[] {"8", "YES", "leading", "spaces", "are", "valid", "problemsetters", "are", "evillllll"})
		      );
	}

	private void doTest(String testString, String expectedResult)
	{
		final InputStream systemStdIn = System.in;
		final PrintStream systemStdOut = System.out;
		System.setIn(new ByteArrayInputStream(testString.getBytes()));
		final ByteArrayOutputStream output = new ByteArrayOutputStream(64 * 1024);
		System.setOut(new PrintStream(output));
		JavaStringTokens.main(null);
		final String producedResult = output.toString();
		System.setOut(systemStdOut);
		System.setIn(systemStdIn);
		System.out.printf(producedResult);

		Assert.assertEquals(expectedResult.trim(), producedResult.trim());
	}

	private static String stringArrayToStringByLine(String[] strings)
	{
		return Arrays.stream(strings).collect(Collectors.joining(System.lineSeparator()));
	}
}
