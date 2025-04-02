package org.rododin.algorithms.hackerrank.java.easy;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit Test(s) for <code>{@link JavaEOF}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaEOFTest
{
	@Test
	public void testPlainEmptyStrings()
	{
		doTest( new ByteArrayInputStream("".getBytes())
		      , new ByteArrayInputStream("".getBytes())
		      );
	}

	@Test
	public void testOnlyOneLineStrings()
	{
		doTest( new ByteArrayInputStream("Hello".getBytes())
		      , new ByteArrayInputStream("1 Hello".getBytes())
		      );
	}

	@Test
	public void testFewLineStrings()
	{
		doTest( new ByteArrayInputStream("Hello world\nI am a file\nRead me until end-of-file.".getBytes())
		      , new ByteArrayInputStream("1 Hello world\n2 I am a file\n3 Read me until end-of-file.".getBytes())
		      );
	}

	@Test
	public void testHello()
	{
		doTest( "org/rododin/algorithms/hackerrank/java/easy/java-eof-input-hello.txt"
		      , "org/rododin/algorithms/hackerrank/java/easy/java-eof-output-hello.txt"
		      );
	}

	@Test
	public void testSample()
	{
		doTest( "org/rododin/algorithms/hackerrank/java/easy/java-eof-input-sample.txt"
		      , "org/rododin/algorithms/hackerrank/java/easy/java-eof-output-sample.txt"
		      );
	}

	private void doTest(String testFilePath, String expectedResultFilePath)
	{
		doTest( getClass().getClassLoader().getResourceAsStream(testFilePath)
		      , getClass().getClassLoader().getResourceAsStream(expectedResultFilePath)
		      );
	}

	private void doTest(InputStream testStream, InputStream expectedResultStream)
	{
		final InputStream systemStdIn = System.in;
		final PrintStream systemStdOut = System.out;
		System.setIn(testStream);
		final ByteArrayOutputStream output = new ByteArrayOutputStream(64 * 1024);
		System.setOut(new PrintStream(output));
		JavaEOF.enumerateStdInLines();
		final String producedResult = output.toString();
		System.setOut(systemStdOut);
		System.setIn(systemStdIn);
		System.out.printf(producedResult);

		final String expectedResult =
			new BufferedReader(new InputStreamReader(expectedResultStream))
				.lines().collect(Collectors.joining(System.lineSeparator()));

		Assert.assertEquals(expectedResult.trim(), producedResult.trim());
	}
}
