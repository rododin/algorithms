package org.rododin.algorithms.hackerrank.java.medium;

import org.junit.Test;
import org.rododin.algorithms.hackerrank.AbstractTest;

/**
 * Unit Test(s) for {@link CanYouAccess}.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class CanYouAccessTest
	extends AbstractTest
{
	@Test
	public void testSimplePowerOf2()
	{
		doTest
			( "2"
				, () -> CanYouAccess.main(null)
				, stringsToStringByLine
					(	"""
						2 is power of 2
						An instance of class: org.rododin.algorithms.hackerrank.java.medium.CanYouAccess.Inner.Private has been created
						"""
					)
			);

		doTest
			( "8"
				, () -> CanYouAccess.main(null)
				, stringsToStringByLine
					(	"""
						8 is power of 2
						An instance of class: org.rododin.algorithms.hackerrank.java.medium.CanYouAccess.Inner.Private has been created
						"""
					)
			);

		doTest
			( "1024"
				, () -> CanYouAccess.main(null)
				, stringsToStringByLine
					(	"""
						1024 is power of 2
						An instance of class: org.rododin.algorithms.hackerrank.java.medium.CanYouAccess.Inner.Private has been created
						"""
					)
			);
	}

	@Test
	public void testSimpleNotPowerOf2()
	{
		doTest
			( "5"
				, () -> CanYouAccess.main(null)
				, stringsToStringByLine
					(	"""
						5 is not a power of 2
						An instance of class: org.rododin.algorithms.hackerrank.java.medium.CanYouAccess.Inner.Private has been created
						"""
					)
			);

		doTest
			( "31"
				, () -> CanYouAccess.main(null)
				, stringsToStringByLine
					(	"""
						31 is not a power of 2
						An instance of class: org.rododin.algorithms.hackerrank.java.medium.CanYouAccess.Inner.Private has been created
						"""
					)
			);

		doTest
			( "723"
				, () -> CanYouAccess.main(null)
				, stringsToStringByLine
					(	"""
						723 is not a power of 2
						An instance of class: org.rododin.algorithms.hackerrank.java.medium.CanYouAccess.Inner.Private has been created
						"""
					)
			);
	}
}
