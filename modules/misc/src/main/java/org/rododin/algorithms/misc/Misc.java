package org.rododin.algorithms.misc;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.misc.staircase.StairCase;

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
		StairCase.stairCase(0);
		StairCase.stairCase(1);
		StairCase.stairCase(5);
		StairCase.stairCase(10);
	}
}
