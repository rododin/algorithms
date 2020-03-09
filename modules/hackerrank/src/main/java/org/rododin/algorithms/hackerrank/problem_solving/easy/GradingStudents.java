package org.rododin.algorithms.hackerrank.problem_solving.easy;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href="https://www.hackerrank.com/challenges/grading/problem">
 *   HackerRank >  Practice > Algorithms > Warmup > Grading Students
 * </a> Problem Solution.
 *
 * @author Nikolay Chebotaryov (Rod Odin)
 */
public class GradingStudents
{
	public static void printGradingStudents(List<Integer> grades)
	{
		System.out.println(grades + " ->\n" + gradingStudents(grades));
	}

	public static List<Integer> gradingStudents(List<Integer> grades)
	{
		return grades.stream().map(grade -> grade >= 38 && grade % 5 >= 3 ? (grade / 5) * 5 + 5 : grade).collect(Collectors.toList());
	}
}
