package org.rododin.algorithms.misc;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.misc.time_conversion.TimeConversion;

/**
 * TODO: Add description.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class Misc
	implements Constants
{
	public static void main(String[] args)
	{
		TimeConversion.printTimeConversion("07:05:45PM");
		TimeConversion.printTimeConversion("12:00:00AM");
		TimeConversion.printTimeConversion("12:00:00PM");

		TimeConversion.printTimeConversionOld("07:05:45PM");
		TimeConversion.printTimeConversionOld("12:00:00AM");
		TimeConversion.printTimeConversionOld("12:00:00PM");
	}
}
