package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for <code>{@link JavaRegEx2DuplicateWords}</code>.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class JavaRegEx2DuplicateWordsTest
	extends AbstractTest
{
	@Test
	public void testBasic()
	{
		doTest( stringsToStringByLine("5", "Goodbye bye bye world world world", "Sam went went to to to his business", "Reya is is the the best player in eye eye game", "in inthe", "Hello hello Ab aB")
		      , () -> JavaRegEx2DuplicateWords.main(null)
		      , stringsToStringByLine("Goodbye bye world", "Sam went to his business", "Reya is the best player in eye game", "in inthe", "Hello Ab")
		);
	}
}
