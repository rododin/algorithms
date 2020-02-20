package org.rododin.algorithms.misc;

import java.util.Arrays;

import org.rododin.algorithms.Constants;
import org.rododin.algorithms.misc.day_of_the_programmer.DayOfTheProgrammer;
import org.rododin.algorithms.misc.grading_students.GradingStudents;

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
		GradingStudents.printGradingStudents(Arrays.asList(4, 7, 9, 28, 38, 44, 58, 83, 87, 92, 99, 100));
	}
}
