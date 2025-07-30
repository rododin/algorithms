package org.rododin.algorithms.hackerrank;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.rododin.algorithms.hackerrank.java.easy.JavaEOF;

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

		Assert.assertEquals(stringsToStringByLine(resultExpectedOnStdOut.trim()), stringsToStringByLine(producedResult.trim()));
	}

	public static void doTest(InputStream testStream, InputStream expectedResultStream, Runnable theCaseToTest)
	{
		final InputStream systemStdIn = System.in;
		final PrintStream systemStdOut = System.out;
		System.setIn(testStream);
		final ByteArrayOutputStream output = new ByteArrayOutputStream(64 * 1024);
		System.setOut(new PrintStream(output));
		theCaseToTest.run();
		final String producedResult = output.toString();
		System.setOut(systemStdOut);
		System.setIn(systemStdIn);
		System.out.printf(producedResult);

		final String expectedResult =
			new BufferedReader(new InputStreamReader(expectedResultStream))
				.lines().collect(Collectors.joining(System.lineSeparator()));

		Assert.assertEquals(expectedResult.trim(), producedResult.trim());
	}

	public static void doTest(String testResourceName, String expectedResultResourceName, Runnable theCaseToTest)
	{
		doTest( AbstractTest.class.getClassLoader().getResourceAsStream(testResourceName)
		      , AbstractTest.class.getClassLoader().getResourceAsStream(expectedResultResourceName)
		      , theCaseToTest
		      );
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
