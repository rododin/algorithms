package org.rododin.algorithms.hackerrank;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;

/**
 * Provides a set of useful methods for implementing typical HackerRank tests.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public abstract class AbstractTest
{
	public static void doTest(String testInputToPassToStdIn, Runnable theCaseToTest, String resultExpectedOnStdOut)
	{
		final InputStream systemStdIn = System.in;
		final PrintStream systemStdOut = System.out;
		System.setIn(new ByteArrayInputStream(testInputToPassToStdIn.getBytes()));
		final ByteArrayOutputStream output = new ByteArrayOutputStream(64 * 1024);
		System.setOut(new PrintStream(output));
		theCaseToTest.run();
		final String producedResult = output.toString();
		System.setOut(systemStdOut);
		System.setIn(systemStdIn);
		System.out.printf(producedResult);

		Assert.assertEquals(resultExpectedOnStdOut.trim(), producedResult.trim());
	}

	public static String stringsToStringByLine(String... strings)
	{
		return Arrays.stream(strings).flatMap(s -> Arrays.stream(s.split("\\r\\n|\\r|\\n"))).collect(Collectors.joining(System.lineSeparator()));
	}

	public static String booleansToStringByLine(Boolean... booleans)
	{
		return Arrays.stream(booleans).map(Object::toString).collect(Collectors.joining(System.lineSeparator()));
	}
}
