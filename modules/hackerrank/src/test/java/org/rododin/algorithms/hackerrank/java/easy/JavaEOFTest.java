package org.rododin.algorithms.hackerrank.java.easy;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaEOF}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaEOFTest
	extends AbstractTest
{
	@Test
	public void testPlainEmptyStrings()
	{
		doTest( ""
		      , JavaEOF::enumerateStdInLines
		      , ""
		      );
	}

	@Test
	public void testOnlyOneLineStrings()
	{
		doTest( "Hello"
		      , JavaEOF::enumerateStdInLines
		      , "1 Hello"
		      );
	}

	@Test
	public void testFewLineStrings()
	{
		doTest( "Hello world\nI am a file\nRead me until end-of-file."
		      , JavaEOF::enumerateStdInLines
		      , "1 Hello world\n2 I am a file\n3 Read me until end-of-file."
		      );
	}

	@Test
	public void testHello()
	{
		doTest( "org/rododin/algorithms/hackerrank/java/easy/java-eof-input-hello.txt"
		      , "org/rododin/algorithms/hackerrank/java/easy/java-eof-output-hello.txt"
		      , JavaEOF::enumerateStdInLines
		      );
	}

	@Test
	public void testSample()
	{
		doTest( "org/rododin/algorithms/hackerrank/java/easy/java-eof-input-sample.txt"
		      , "org/rododin/algorithms/hackerrank/java/easy/java-eof-output-sample.txt"
		      , JavaEOF::enumerateStdInLines
		      );
	}
}
