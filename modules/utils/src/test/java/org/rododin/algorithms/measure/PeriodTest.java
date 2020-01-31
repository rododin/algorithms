/*
 * PeriodTest.java
 */

package org.rododin.algorithms.measure;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * TODO: Add description.
 * @author Nikolay Chebotaryov (Rod Odin)
 */
@RunWith(JUnit4.class)
public class PeriodTest
{
	@Test
	public void testLengthToString()
	{
		final String test1234 = Period.lengthToString(1234, " ", ", ", "ms", "secs", "mins", "hours", "days", "years");
		Assert.assertEquals("1 secs, 234 ms", test1234);

		final String test1234_1 = Period.lengthToString(1234, " ", ", ", "ms");
		Assert.assertEquals("1234 ms", test1234_1);

		final String test1234_2 = Period.lengthToString(1234, " ", ", ");
		Assert.assertEquals("1234", test1234_2);

		final String test1234567890 = Period.lengthToString(1234567890, " ", ", ", "ms", "secs", "mins", "hours", "days", "years");
		Assert.assertEquals("14 days, 6 hours, 56 mins, 7 secs, 890 ms", test1234567890);

		final String test1234567890_1 = Period.lengthToString(1234567890, " ", ", ", "ms", "secs", "mins");
		Assert.assertEquals("20576 mins, 7 secs, 890 ms", test1234567890_1);

		final String test86400000000 = Period.lengthToString(86400000000L, " ", ", ", "ms", "secs", "mins", "hours", "days", "years");
		Assert.assertEquals("2 years, 270 days, 0 hours, 0 mins, 0 secs, 0 ms", test86400000000);
	}
}
